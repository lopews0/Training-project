package com.trainingproject.services;

import com.trainingproject.dtos.AssetsDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AssetsServiceTest {

    @Test
    void getAssets() {
        //given
        AssetsService assetsService = new AssetsService();
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
        AssetsService assetsService = new AssetsService();
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