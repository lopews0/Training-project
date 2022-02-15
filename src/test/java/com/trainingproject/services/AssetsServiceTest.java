package com.trainingproject.services;

import com.trainingproject.dtos.AssetsDto;
import com.trainingproject.mappers.AssetsMapper;
import com.trainingproject.repositories.AssetsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AssetsServiceTest {



    @Autowired
    AssetsRepository assetsRepository;
    @Autowired
    AssetsMapper assetsMapper;

    @Test
    void getAssets() {
        //given
        AssetsService assetsService = new AssetsService(assetsRepository, assetsMapper);
        assetsService.setAsset(2);
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
        AssetsService assetsService = new AssetsService(assetsRepository, assetsMapper);
        assetsService.setAsset(asset1);
        assetsService.setAsset(asset2);
        //when
        AssetsDto assets = assetsService.getAssets();

        //then
        assertThat(assets.getAssets())
                .hasSize(2)
                .containsExactly(asset1, asset2);

    }
}