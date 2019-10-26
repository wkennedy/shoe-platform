package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest
class ShoeServiceImplTest {

    @Autowired
    private ShoeDimService shoeDimService;

    @Test
    void createShoeDimension() {
        ShoeDimEntity shoeDimension = shoeDimService.createShoeDimension("Addidas", "Model 1");
        ShoeDimEntity addidas = shoeDimService.findByBrandAndModel("Addidas", "Model 1");
        assertEquals(shoeDimension, addidas);
    }


    @Test
    void findByBrandAndModel() {
    }

    @Test
    void findBySizeUS() {
    }

    @Test
    void createTrueToSizeFact() {
//        TrueToSizeFactEntity addidas = shoeService.createTrueToSizeFact("Addidas", "Model 1", (short) 3, null);
//        assertNotNull(addidas);
    }

    @Test
    void getDateDimByToday() {
    }

    @Test
    void getDateDimIDForToday() {
    }

    @Test
    void getTrueToSizeAverage() {
//        Float trueToSizeAverage = shoeService.getTrueToSizeAverage("Addidas", "Model 1");
//        assertEquals(2.0F, trueToSizeAverage);
    }
}