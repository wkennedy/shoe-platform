package com.github.wkennedy.shoeservice.repos;

import com.github.wkennedy.shoeservice.entities.ShoeSizeDimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeSizeDimRepo extends JpaRepository<ShoeSizeDimEntity, Integer> {

    ShoeSizeDimEntity findByUs(float us);
}
