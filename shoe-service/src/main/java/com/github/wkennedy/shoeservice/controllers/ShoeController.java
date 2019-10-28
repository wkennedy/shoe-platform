package com.github.wkennedy.shoeservice.controllers;

import com.github.wkennedy.shoeservice.models.Shoe;
import com.github.wkennedy.shoeservice.services.ShoeDimService;
import com.github.wkennedy.shoeservice.services.ShoeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shoes")
@Api("Set of endpoints for creating and retrieving the true to size values of shoes")
public class ShoeController {

    private final ShoeService shoeService;

    private final ShoeDimService shoeDimService;

    public ShoeController(ShoeService shoeService, ShoeDimService shoeDimService) {
        this.shoeService = shoeService;
        this.shoeDimService = shoeDimService;
    }

    @GetMapping("/{brand}/{model}")
    @ApiOperation("Returns the true to size average of a specific shoe brand and model")
    private Shoe getTrueToSize(@ApiParam("The brand of the shoe (ex. Adidas)") @PathVariable String brand, @ApiParam("The model of the shoe (ex. Yeezy)") @PathVariable String model) {
        return shoeService.getTrueToSizeAverage(brand, model);
    }

    @PostMapping("/{brand}/{model}/{trueToSize}")
    @ApiOperation("Creates a true to size entry of a specific shoe brand and model")
    private Boolean addTrueToSizeValue(@ApiParam("The brand of the shoe (ex. Adidas)") @PathVariable String brand,
                                       @ApiParam("The model of the shoe (ex. Yeezy)") @PathVariable String model,
                                       @ApiParam(value = "The true to size value of the shoe (1: really small, 2: small, 3: true to size, 4: big and 5: really big)", example = "3") @PathVariable Short trueToSize) {
        return shoeService.createTrueToSizeFact(brand, model, trueToSize, null);
    }

    @GetMapping("/trueToSizeAverages")
    @ApiOperation("Returns the true to size averages of all shoes on record")
    private List<Shoe> getTrueToSizeAverages() {
        return shoeService.getTrueToSizeAverages();
    }

    @GetMapping("/brandModels")
    @ApiOperation("Returns all the shoe brands and models on record")
    private Map<String, List<String>> getBrandModels() {
        return shoeDimService.getBrandModels();
    }

}
