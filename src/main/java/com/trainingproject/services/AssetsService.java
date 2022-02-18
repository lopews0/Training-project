package com.trainingproject.services;

import com.trainingproject.domain.Asset;
import com.trainingproject.dtos.AssetDto;
import com.trainingproject.dtos.AssetsDto;
import com.trainingproject.mappers.AssetsMapper;
import com.trainingproject.repositories.AssetsRepository;
import com.trainingproject.validators.AssetValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetsService {
    private final AssetsRepository assetsRepository;
    private final AssetsMapper assetsMapper;
    private final AssetValidator assetValidator;

    public AssetsService(AssetsRepository assetsRepository, AssetsMapper assetsMapper, AssetValidator assetValidator) {
        this.assetsRepository = assetsRepository;
        this.assetsMapper = assetsMapper;
        this.assetValidator = assetValidator;
    }

    public AssetsDto getAssets() {

        List<Integer> assetsAmount = assetsRepository.findAll().stream()
                .map(asset -> asset.getAmount().intValue())
                .collect(Collectors.toList());

        AssetsDto assetsDto = new AssetsDto();
        assetsDto.setAssets(assetsAmount);
        return assetsDto;
    }

    public void setAsset(AssetDto assetDto) {
        assetValidator.validate(assetDto);
        Asset entity = assetsMapper.fromDtoToEntity(assetDto);

        assetsRepository.save(entity);
    }

    public void deleteAsset(AssetDto assetDto) {
        Asset asset = assetsMapper.fromDtoToEntity(assetDto);
        assetsRepository.delete(asset);
    }
}
