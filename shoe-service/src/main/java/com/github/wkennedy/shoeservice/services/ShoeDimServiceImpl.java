package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import com.github.wkennedy.shoeservice.repos.ShoeDimRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoeDimServiceImpl implements ShoeDimService {

    private final ShoeDimRepo shoeDimRepo;

    public ShoeDimServiceImpl(ShoeDimRepo shoeDimRepo) {
        this.shoeDimRepo = shoeDimRepo;
    }

    @Override
    public ShoeDimEntity createShoeDimension(String brand, String model) {
        ShoeDimEntity shoeDimEntity = new ShoeDimEntity();
        shoeDimEntity.setBrand(brand.toLowerCase());
        shoeDimEntity.setModel(model.toLowerCase());
        return shoeDimRepo.save(shoeDimEntity);
    }

    @Override
    @Cacheable("ShoeDimBrandModelCache")
    public ShoeDimEntity findByBrandAndModel(String brand, String model) {
        if(brand == null || model == null) {
            return null;
        }

        return shoeDimRepo.findByBrandAndModel(brand.toLowerCase(), model.toLowerCase());
    }

    public Map<String, List<String>> getBrandModels() {
        List<ShoeDimEntity> all = shoeDimRepo.findAll();
        Map<String, List<String>> brandModels = new HashMap<>();
        List<String> models;
        for (ShoeDimEntity shoeDimEntity : all) {
            if(!brandModels.containsKey(shoeDimEntity.getBrand())) {
                models = new ArrayList<>();
                brandModels.put(shoeDimEntity.getBrand(), models);
            } else {
                models = brandModels.get(shoeDimEntity.getBrand());
            }
            models.add(shoeDimEntity.getModel());
        }

        return brandModels;
    }

}
