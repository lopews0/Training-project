package com.trainingproject.controllers;

import com.trainingproject.dtos.AssetDto;
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

    @PostMapping
    public void setAsset(@RequestBody AssetDto assetDto) {;
        assetsService.setAsset(assetDto);
    }

    @DeleteMapping
    public void deleteAsset(@RequestBody AssetDto assetDto) {
        assetsService.deleteAsset(assetDto);
    }
}
