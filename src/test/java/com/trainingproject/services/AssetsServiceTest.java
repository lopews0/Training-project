package com.trainingproject.services;

import com.trainingproject.domain.Asset;
import com.trainingproject.dtos.AssetDto;
import com.trainingproject.enums.ValidatorAssetEnum;
import com.trainingproject.exceptions.AssetIncompleteException;
import com.trainingproject.mappers.AssetsMapper;
import com.trainingproject.repositories.AssetsRepository;
import com.trainingproject.validators.AssetValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AssetsServiceTest {

    AssetsService assetsService;

    @Mock
    AssetsRepository assetsRepository;

    AssetsMapper assetsMapper = new AssetsMapper();
    AssetValidator assetValidator = new AssetValidator();

    @BeforeEach
    void setUp() {

        assetsService = new AssetsService(assetsRepository, assetsMapper, assetValidator);
    }

    @Test
    void getAssets() {
        //given
        var assetVal = new BigDecimal(2);
        Asset asset = new Asset.AssetBuilder()
                .withAmount(assetVal)
                .build();
        given(assetsRepository.findAll()).willReturn(List.of(asset));

        //when
        List<AssetDto> assets = assetsService.getAssets();

        //then
        assertThat(assets)
                .hasSize(1)
                .contains(new AssetDto.AssetDtoBuilder().withAmount(assetVal).build());

    }

    @Test
    void getAssets2() {
        //given
        var asset1 = new BigDecimal(3);
        var asset2 = new BigDecimal(4);
        Asset as1 = new Asset.AssetBuilder()
                .withAmount(asset1)
                .build();
        Asset as2 = new Asset.AssetBuilder()
                .withAmount(asset2)
                .build();
        given(assetsRepository.findAll()).willReturn(List.of(as1, as2));
        //when
        List<AssetDto> assets = assetsService.getAssets();

        //then
        assertThat(assets  )
                .hasSize(2)
                .containsExactly(
                        new AssetDto.AssetDtoBuilder().withAmount(asset1).build(),
                        new AssetDto.AssetDtoBuilder().withAmount(asset2).build()
                );

    }

    @Test
    void verifyIfRepoWasCalled() {
        //given
        BigDecimal asset = BigDecimal.ONE;
        AssetDto assetDto = new AssetDto.AssetDtoBuilder()
                .withAmount(asset)
                .build();
        Asset entity = new Asset.AssetBuilder()
                .withAmount(asset)
                .build();

        //when
        assetsService.setAsset(assetDto);

        //then
        then(assetsRepository).should(times(1)).save(entity);
    }

    @Test
    void shouldVerifyIfTheRepositoryUpdateWasCalled() {
        //given
        AssetDto dto = new AssetDto.AssetDtoBuilder().withAmount(new BigDecimal(2)).build();
        Asset entity = new Asset.AssetBuilder().withAmount(new BigDecimal(2)).build();
        given(assetsRepository.findById(any())).willReturn(Optional.of(entity));
        //when
        assetsService.updateAsset(dto);
        //then
        then(assetsRepository).should().saveAndFlush(entity);

    }

    @Test
    void shouldThrowExceptionWhenAmountInAssetDtoIsNull() {

        //given
        AssetDto assetDto = new AssetDto();

        //when
        AssetIncompleteException assetIncompleteException =
                assertThrows(AssetIncompleteException.class, () -> assetsService.setAsset(assetDto));

        //then
        assertThat(assetIncompleteException.getMessage()).isEqualTo(ValidatorAssetEnum.NO_AMOUNT.getMessage());
    }
}