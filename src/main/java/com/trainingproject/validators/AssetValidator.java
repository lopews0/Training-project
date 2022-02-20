package com.trainingproject.validators;

import com.trainingproject.dtos.AssetDto;
import com.trainingproject.enums.ValidatorAssetEnum;
import com.trainingproject.exceptions.AssetIncompleteException;
import org.springframework.stereotype.Component;

@Component
public class AssetValidator {

    public void validate(AssetDto assetDto) {
        if (assetDto.getAmount() == null)
            throw new AssetIncompleteException(ValidatorAssetEnum.NO_AMOUNT.getMessage(), "7264d85c-0b7e-4b74-9428-9f1d2b04ace3");
    }
}
