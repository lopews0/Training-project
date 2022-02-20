package com.trainingproject.services;

import com.trainingproject.domain.Asset;
import com.trainingproject.dtos.AssetDto;
import com.trainingproject.mappers.AssetsMapper;
import com.trainingproject.repositories.AssetsRepository;
import com.trainingproject.validators.AssetValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<AssetDto> getAssets() {
        return assetsRepository.findAll().stream()
                .map(assetsMapper::fromEntityToDto)
                .collect(Collectors.toList());
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

    public void updateAsset(AssetDto assetDto) {
        Optional<Asset> assetById = assetsRepository.findById(assetDto.getId());

        assetById.ifPresent(asset -> {
            asset.setAmount(assetDto.getAmount());
            assetsRepository.saveAndFlush(asset);
        });
    }
}
