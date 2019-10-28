package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import com.github.wkennedy.shoeservice.repos.ShoeDimRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoeDimServiceImplTest {

    @Autowired
    private ShoeDimService shoeDimService;

    @Autowired
    private ShoeDimRepo shoeDimRepo;

    @Before
    public void before() {
        shoeDimRepo.deleteAll();
    }

    @Test
    public void createShoeDimension() {
        ShoeDimEntity shoeDimension = shoeDimService.createShoeDimension("Nike", "Tanjun");
        assertEquals("nike", shoeDimension.getBrand());
        assertEquals("tanjun", shoeDimension.getModel());
    }

    @Test
    public void findByBrandAndModel() {
        ShoeDimEntity shoeDimension = shoeDimService.createShoeDimension("Nike", "Tanjun");
        ShoeDimEntity byBrandAndModel = shoeDimService.findByBrandAndModel("Nike", "Tanjun");
        assertEquals("nike", byBrandAndModel.getBrand());
        assertEquals("tanjun", byBrandAndModel.getModel());
    }

    @Test
    public void getBrandModels() {
        ShoeDimEntity nike = shoeDimService.createShoeDimension("Nike", "Tanjun");
        ShoeDimEntity vans = shoeDimService.createShoeDimension("Vans", "Ward");

        Map<String, List<String>> brandModels = shoeDimService.getBrandModels();
        assertEquals(2, brandModels.size());
        assertEquals("tanjun", brandModels.get("nike").get(0));
        assertEquals("ward", brandModels.get("vans").get(0));
    }
}