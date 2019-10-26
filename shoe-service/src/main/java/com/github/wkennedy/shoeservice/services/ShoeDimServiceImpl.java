package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import com.github.wkennedy.shoeservice.repos.ShoeDimRepo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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


}
