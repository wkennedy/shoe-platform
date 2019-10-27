package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

public interface ShoeDimService {
    ShoeDimEntity createShoeDimension(String brand, String model);

    ShoeDimEntity findByBrandAndModel(String brand, String model);

    Map<String, List<String>> getBrandModels();
}
