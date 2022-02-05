package com.trainingproject.controllers;

import com.trainingproject.dtos.AssetsDto;
import com.trainingproject.services.AssetsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    private final AssetsService assetsService;

    public AssetsController(AssetsService assetsService) {
        this.assetsService = assetsService;
    }

    @GetMapping
    public AssetsDto getAssets() {
        return assetsService.getAssets();
    }

    @PostMapping("/{asset}")
    public void setAsset(@PathVariable int asset) {
        assetsService.setAsset(asset);
    }


}
