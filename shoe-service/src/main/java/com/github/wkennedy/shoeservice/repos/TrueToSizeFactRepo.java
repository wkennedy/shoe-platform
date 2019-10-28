package com.github.wkennedy.shoeservice.repos;

import com.github.wkennedy.shoeservice.entities.TrueToSizeFactEntity;
import com.github.wkennedy.shoeservice.models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrueToSizeFactRepo extends JpaRepository<TrueToSizeFactEntity, Integer> {

    @Query(value = "select AVG(true_to_size) from true_to_size_fact join shoe_dim sd on true_to_size_fact.shoe_dim = sd.id where sd.brand = :brand and sd.model = :model group by shoe_dim", nativeQuery = true)
    Double findTrueToSizeAverage(@Param("brand") String brand, @Param("model") String model);

    @Query(value = "select new com.github.wkennedy.shoeservice.models.Shoe(sde.brand, sde.model, avg(tts.trueToSize)) from TrueToSizeFactEntity tts join ShoeDimEntity sde on tts.shoeDimByShoeDim = sde.id group by sde.brand, sde.model")
    List<Shoe> findTrueToSizeAverages();
}
