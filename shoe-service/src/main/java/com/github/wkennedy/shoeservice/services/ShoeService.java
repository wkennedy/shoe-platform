package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import com.github.wkennedy.shoeservice.entities.ShoeSizeDimEntity;
import com.github.wkennedy.shoeservice.entities.TrueToSizeFactEntity;
import com.github.wkennedy.shoeservice.models.Shoe;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.lang.Nullable;

public interface ShoeService {

    ShoeSizeDimEntity findBySizeUS(Float size);

    Boolean createTrueToSizeFact(String brand, String model, Short trueToSize, @Nullable Float size);

    Shoe getTrueToSizeAverage(String brand, String model);
}
