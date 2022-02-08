package com.trainingproject.dtos;

import com.trainingproject.domain.Asset;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

public class AssetDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetDto assetDto = (AssetDto) o;
        return Objects.equals(id, assetDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AssetDto{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }


    public static final class AssetDtoBuilder {
        private Long id;
        private BigDecimal amount;


        public static AssetDtoBuilder anAssetDto() {
            return new AssetDtoBuilder();
        }

        public AssetDtoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AssetDtoBuilder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public AssetDto build() {
            AssetDto assetDto = new AssetDto();
            assetDto.setId(id);
            assetDto.setAmount(amount);
            return assetDto;
        }
    }
}
