package com.trainingproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    @GetMapping
    public Dto getAssets() {
        Dto dto = new Dto();
        dto.setAssets(Arrays.asList(1, 2, 3));
        return dto;
    }

    private class Dto {
        private List<Integer> assets;

        public List<Integer> getAssets() {
            return assets;
        }

        public void setAssets(List<Integer> assets) {
            this.assets = assets;
        }
    }
}
