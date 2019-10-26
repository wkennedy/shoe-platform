package com.github.wkennedy.shoeservice.repos;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeDimRepo extends JpaRepository<ShoeDimEntity, Integer> {

    ShoeDimEntity findByBrandAndModel(String brand, String model);
}
