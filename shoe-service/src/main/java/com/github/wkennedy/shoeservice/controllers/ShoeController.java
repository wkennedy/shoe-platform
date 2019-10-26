package com.github.wkennedy.shoeservice.controllers;

import com.github.wkennedy.shoeservice.models.Shoe;
import com.github.wkennedy.shoeservice.services.ShoeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    private final ShoeService shoeService;

    public ShoeController(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping("/{brand}/{model}")
    private Shoe getTrueToSize(@PathVariable String brand, @PathVariable String model) {
        return shoeService.getTrueToSizeAverage(brand, model);
    }

    @PostMapping("/{brand}/{model}/{trueToSize}")
    private Boolean addTrueToSizeValue(@PathVariable String brand, @PathVariable String model, @PathVariable Short trueToSize) {
        return shoeService.createTrueToSizeFact(brand, model, trueToSize, null);
    }

}
