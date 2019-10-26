package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import org.springframework.cache.annotation.Cacheable;

public interface ShoeDimService {
    ShoeDimEntity createShoeDimension(String brand, String model);

    @Cacheable("ShoeDimBrandModelCache")
    ShoeDimEntity findByBrandAndModel(String brand, String model);
}
