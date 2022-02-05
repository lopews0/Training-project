package com.trainingproject.services;

import com.trainingproject.dtos.AssetsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AssetsService {
    AssetsDto assetsDto = new AssetsDto();

    public AssetsDto getAssets() {

        return assetsDto;
    }

    public void setAsset(int asset) {
        if (assetsDto.getAssets() == null) {
            assetsDto.setAssets(new ArrayList<>());
        }
        assetsDto.getAssets().add(asset);
    }
}
