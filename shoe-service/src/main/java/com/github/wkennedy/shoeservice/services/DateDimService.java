package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.DateDimEntity;

public interface DateDimService {
    Integer getDateDimIDForToday();
    DateDimEntity getDateDimByToday();
    DateDimEntity getDateDimById(Integer id);
}
