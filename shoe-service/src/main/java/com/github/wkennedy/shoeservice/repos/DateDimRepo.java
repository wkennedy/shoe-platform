package com.github.wkennedy.shoeservice.repos;

import com.github.wkennedy.shoeservice.entities.DateDimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateDimRepo extends JpaRepository<DateDimEntity, Integer> {
}
