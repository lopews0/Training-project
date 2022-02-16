package com.trainingproject.services;

import com.trainingproject.domain.Asset;
import com.trainingproject.dtos.AssetsDto;
import com.trainingproject.mappers.AssetsMapper;
import com.trainingproject.repositories.AssetsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AssetsServiceTest {


    @Mock
    AssetsRepository assetsRepository;

    AssetsMapper assetsMapper = new AssetsMapper();

    AssetsService assetsService;

    @BeforeEach
    void setUp() {

        assetsService = new AssetsService(assetsRepository, assetsMapper);
    }

    @Test
    void getAssets() {
        //given

        Asset asset = new Asset.AssetBuilder()
                .withAmount(new BigDecimal(2))
                .build();
        given(assetsRepository.findAll()).willReturn(List.of(asset));

        //when
        AssetsDto assets = assetsService.getAssets();

        //then
        assertThat(assets.getAssets())
                .hasSize(1)
                .containsExactly(2);

    }

    @Test
    void getAssets2() {
        //given
        int asset1 = 3;
        int asset2 = 4;
        Asset as1 = new Asset.AssetBuilder()
                .withAmount(new BigDecimal(asset1))
                .build();
        Asset as2 = new Asset.AssetBuilder()
                .withAmount(new BigDecimal(asset2))
                .build();
        given(assetsRepository.findAll()).willReturn(List.of(as1, as2));
        //when
        AssetsDto assets = assetsService.getAssets();

        //then
        assertThat(assets.getAssets())
                .hasSize(2)
                .containsExactly(asset1, asset2);

    }

    @Test
    void verifyIfRepoWasCalled() {
        //given
        int asset = 1;
        Asset entity = new Asset.AssetBuilder()
                .withAmount(new BigDecimal(asset))
                .build();

        //when
        assetsService.setAsset(asset);

        //then
        then(assetsRepository).should(times(1)).save(entity);
    }
}