package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.DateDimEntity;
import com.github.wkennedy.shoeservice.entities.ShoeDimEntity;
import com.github.wkennedy.shoeservice.entities.ShoeSizeDimEntity;
import com.github.wkennedy.shoeservice.entities.TrueToSizeFactEntity;
import com.github.wkennedy.shoeservice.models.Shoe;
import com.github.wkennedy.shoeservice.models.TrueToSize;
import com.github.wkennedy.shoeservice.repos.DateDimRepo;
import com.github.wkennedy.shoeservice.repos.ShoeSizeDimRepo;
import com.github.wkennedy.shoeservice.repos.TrueToSizeFactRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShoeServiceImpl implements ShoeService {

    private static final Logger LOG = LoggerFactory.getLogger(ShoeServiceImpl.class);

    private final DateDimRepo dateDimRepo;

    private final ShoeDimService shoeDimService;

    private final ShoeSizeDimRepo shoeSizeDimRepo;

    private final TrueToSizeFactRepo trueToSizeFactRepo;

    public ShoeServiceImpl(DateDimRepo dateDimRepo, ShoeDimService shoeDimService, ShoeSizeDimRepo shoeSizeDimRepo, TrueToSizeFactRepo trueToSizeFactRepo) {
        this.dateDimRepo = dateDimRepo;
        this.shoeDimService = shoeDimService;
        this.shoeSizeDimRepo = shoeSizeDimRepo;
        this.trueToSizeFactRepo = trueToSizeFactRepo;
    }

    @Override
    public ShoeSizeDimEntity findBySizeUS(Float size) {
        return shoeSizeDimRepo.findByUs(size);
    }

    @Override
    public Boolean createTrueToSizeFact(String brand, String model, Short trueToSize, @Nullable Float size) {
        TrueToSizeFactEntity trueToSizeFactEntity = new TrueToSizeFactEntity();
        ShoeDimEntity shoeDimEntity = shoeDimService.findByBrandAndModel(brand, model);
        if (shoeDimEntity == null) {
            shoeDimEntity = shoeDimService.createShoeDimension(brand, model);
        }

        trueToSizeFactEntity.setTrueToSize(trueToSize);
        trueToSizeFactEntity.setShoeDimByShoeDim(shoeDimEntity);

        trueToSizeFactEntity.setDateDimByDateDim(getDateDimByToday());

        if (size != null) {
            ShoeSizeDimEntity bySizeUS = findBySizeUS(size);
            trueToSizeFactEntity.setShoeSizeDimByShoeSizeDim(bySizeUS);
        }

        trueToSizeFactRepo.save(trueToSizeFactEntity);

        return true;
    }

    @Override
    public Shoe getTrueToSizeAverage(String brand, String model) {
        Double trueToSizeAverage = trueToSizeFactRepo.findTrueToSizeAverage(brand.toLowerCase(), model.toLowerCase());

        Shoe shoe = new Shoe();
        shoe.setBrand(brand);
        shoe.setModel(model);
        shoe.setTrueToSizeAvg(trueToSizeAverage);
        shoe.setTrueToSizeDescription(TrueToSize.getDescriptionForRange(trueToSizeAverage));

        return shoe;
    }

    public List<Shoe> getTrueToSizeAverages() {
        List<Shoe> trueToSizeAverages = trueToSizeFactRepo.findTrueToSizeAverages();
        for (Shoe shoe : trueToSizeAverages) {
            shoe.setTrueToSizeDescription(TrueToSize.getDescriptionForRange(shoe.getTrueToSizeAvg()));
        }

        return trueToSizeAverages;
    }

    private DateDimEntity getDateDimByToday() {
        Integer dateDimId = getDateDimIDForToday();
        LOG.debug("Getting dateDim for dateDimId: " + dateDimId);
        return dateDimRepo.findById(dateDimId).get();
    }

    private Integer getDateDimIDForToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sdf.format(new Date()));
    }
}
