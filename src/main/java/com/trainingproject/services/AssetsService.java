package com.trainingproject.services;

import com.trainingproject.domain.Asset;
import com.trainingproject.dtos.AssetDto;
import com.trainingproject.dtos.AssetsDto;
import com.trainingproject.mappers.AssetsMapper;
import com.trainingproject.repositories.AssetsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;
    private final AssetsMapper assetsMapper;

    public AssetsService(AssetsRepository assetsRepository, AssetsMapper assetsMapper) {
        this.assetsRepository = assetsRepository;
        this.assetsMapper = assetsMapper;
    }

    public AssetsDto getAssets() {

        List<Integer> assetsAmount = assetsRepository.findAll().stream()
                .map(asset -> asset.getAmount().intValue())
                .collect(Collectors.toList());

        AssetsDto assetsDto = new AssetsDto();
        assetsDto.setAssets(assetsAmount);
        return assetsDto;
    }

    public void setAsset(int asset) {

        AssetDto assetDto = new AssetDto();
        assetDto.setAmount(new BigDecimal(asset));

        Asset entity = assetsMapper.fromDtoToEntity(assetDto);

        assetsRepository.save(entity);
    }
}
