package com.trainingproject.validators;

import com.trainingproject.dtos.AssetDto;
import com.trainingproject.enums.ValidatorAssetEnum;
import com.trainingproject.exceptions.AssetIncompleteException;
import org.springframework.stereotype.Component;

@Component
public class AssetValidator {

    public void validate(AssetDto assetDto) {
        if (assetDto.getAmount() == null)
            throw new AssetIncompleteException(ValidatorAssetEnum.NO_AMOUNT.getMessage());
    }
}
