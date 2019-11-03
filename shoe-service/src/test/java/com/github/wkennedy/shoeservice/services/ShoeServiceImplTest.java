package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.DateDimEntity;
import com.github.wkennedy.shoeservice.models.Shoe;
import com.github.wkennedy.shoeservice.repos.DateDimRepo;
import com.github.wkennedy.shoeservice.repos.ShoeDimRepo;
import com.github.wkennedy.shoeservice.repos.TrueToSizeFactRepo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ShoeServiceImplTest {

    @Autowired
    private ShoeService shoeService;

    @Autowired
    private DateDimRepo dateDimRepo;

    @Autowired
    private ShoeDimRepo shoeDimRepo;

    @Autowired
    private TrueToSizeFactRepo trueToSizeFactRepo;

    private DateDimEntity dateDimEntity;

    @BeforeEach
    public void before() {
        if(dateDimEntity == null) {
            dateDimEntity = new DateDimEntity();
            dateDimEntity.setDateDimId(getDateDimIDForToday());
            dateDimRepo.save(dateDimEntity);
        }

    }

    @AfterEach
    public void afterEach() {
        trueToSizeFactRepo.deleteAll();
        shoeDimRepo.deleteAll();
    }

    @Test
    public void findBySizeUS() {
        shoeService.findBySizeUS(8F);
    }

    @Test
    public void createTrueToSizeFact() {
        Boolean trueToSizeFact = shoeService.createTrueToSizeFact("Nike", "Tanjun", (short) 3, null);
        assertTrue(trueToSizeFact);
    }

    @Test
    public void getTrueToSizeAverage() {
        Boolean trueToSizeFact1 = shoeService.createTrueToSizeFact("Nike", "Tanjun", (short) 1, null);
        Boolean trueToSizeFact5 = shoeService.createTrueToSizeFact("Nike", "Tanjun", (short) 5, null);

        Shoe trueToSizeAverage = shoeService.getTrueToSizeAverage("Nike", "Tanjun");
        assertEquals(Double.valueOf(3), trueToSizeAverage.getTrueToSizeAvg());
    }

    @Test
    public void getTrueToSizeAverages() {
        Boolean trueToSizeFact1 = shoeService.createTrueToSizeFact("Nike", "Tanjun", (short) 1, null);
        Boolean trueToSizeFact5 = shoeService.createTrueToSizeFact("Nike", "Tanjun", (short) 5, null);

        Boolean trueToSizeFact3 = shoeService.createTrueToSizeFact("Vans", "Ward", (short) 3, null);
        Boolean trueToSizeFact4 = shoeService.createTrueToSizeFact("Vans", "Ward", (short) 4, null);

        List<Shoe> trueToSizeAverages = shoeService.getTrueToSizeAverages();
        assertEquals(2, trueToSizeAverages.size());
        for (Shoe trueToSizeAverage : trueToSizeAverages) {
            if(trueToSizeAverage.getModel().equalsIgnoreCase("ward")) {
                assertEquals(Double.valueOf(3.5), trueToSizeAverage.getTrueToSizeAvg());
            }

            if(trueToSizeAverage.getModel().equalsIgnoreCase("Tanjun")) {
                assertEquals(Double.valueOf(3), trueToSizeAverage.getTrueToSizeAvg());
            }
        }
    }

    private Integer getDateDimIDForToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sdf.format(new Date()));
    }

}