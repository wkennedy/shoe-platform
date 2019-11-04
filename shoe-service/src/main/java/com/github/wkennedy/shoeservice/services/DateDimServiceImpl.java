package com.github.wkennedy.shoeservice.services;

import com.github.wkennedy.shoeservice.entities.DateDimEntity;
import com.github.wkennedy.shoeservice.repos.DateDimRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateDimServiceImpl implements DateDimService {
    private static final Logger LOG = LoggerFactory.getLogger(DateDimServiceImpl.class);

    private final DateDimRepo dateDimRepo;

    public DateDimServiceImpl(DateDimRepo dateDimRepo) {
        this.dateDimRepo = dateDimRepo;
    }

    @Override
    @Cacheable(value = "dateDimCache", key = "{#root.methodName}")
    public DateDimEntity getDateDimByToday() {
        Integer dateDimId = getDateDimIDForToday();
        LOG.debug("Getting dateDim for dateDimId: " + dateDimId);
        return getDateDimById(dateDimId);
    }

    public DateDimEntity getDateDimById(Integer id) {
        return dateDimRepo.findById(id).get();
    }

    public Integer getDateDimIDForToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.parseInt(sdf.format(new Date()));
    }

    @CacheEvict(allEntries = true, cacheNames = { "dateDimCache" })
    @Scheduled(fixedDelay = 86400000)
    public void cacheEvict() {
        LOG.debug("Evicting all from dateDimCache...");
    }
}
