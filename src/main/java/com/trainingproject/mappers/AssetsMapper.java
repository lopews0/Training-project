package com.trainingproject.mappers;

import com.trainingproject.domain.Asset;
import com.trainingproject.dtos.AssetDto;
import org.springframework.stereotype.Component;

@Component
public class AssetsMapper {

    public Asset fromDtoToEntity(AssetDto dto) {
        if (dto == null)
            return null;

        Asset.AssetBuilder assetBuilder = new Asset.AssetBuilder();

        if (dto.getId() != null) {
            assetBuilder.withId(dto.getId());
        }

        if (dto.getAmount() != null) {
            assetBuilder.withAmount(dto.getAmount());
        }

        return assetBuilder.build();
    }

    public AssetDto fromEntityToDto(Asset asset) {
        if (asset == null)
            return null;

        AssetDto.AssetDtoBuilder assetDtoBuilder = new AssetDto.AssetDtoBuilder();

        if (asset.getId() != null) {
            assetDtoBuilder.withId(asset.getId());
        }

        if (asset.getAmount() != null) {
            assetDtoBuilder.withAmount(asset.getAmount());
        }

        return assetDtoBuilder.build();
    }

}
