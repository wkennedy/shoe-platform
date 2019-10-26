package com.github.wkennedy.shoeservice.repos;

import com.github.wkennedy.shoeservice.entities.TrueToSizeFactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrueToSizeFactRepo extends JpaRepository<TrueToSizeFactEntity, Integer> {

    @Query(value = "select AVG(true_to_size) from true_to_size_fact join shoe_dim sd on true_to_size_fact.shoe_dim = sd.id where sd.brand = :brand and sd.model = :model group by shoe_dim", nativeQuery = true)
    Float findTrueToSizeAverage(@Param("brand") String brand, @Param("model") String model);
}
