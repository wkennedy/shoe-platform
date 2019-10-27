package com.github.wkennedy.shoeservice.controllers;

import com.github.wkennedy.shoeservice.models.Shoe;
import com.github.wkennedy.shoeservice.services.ShoeDimService;
import com.github.wkennedy.shoeservice.services.ShoeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    private final ShoeService shoeService;

    private final ShoeDimService shoeDimService;

    public ShoeController(ShoeService shoeService, ShoeDimService shoeDimService) {
        this.shoeService = shoeService;
        this.shoeDimService = shoeDimService;
    }

    @GetMapping("/{brand}/{model}")
    private Shoe getTrueToSize(@PathVariable String brand, @PathVariable String model) {
        return shoeService.getTrueToSizeAverage(brand, model);
    }

    @PostMapping("/{brand}/{model}/{trueToSize}")
    private Boolean addTrueToSizeValue(@PathVariable String brand, @PathVariable String model, @PathVariable Short trueToSize) {
        return shoeService.createTrueToSizeFact(brand, model, trueToSize, null);
    }

    @GetMapping("/brandModels")
    private Map<String, List<String>> getBrandModels() {
        return shoeDimService.getBrandModels();
    }

}
