package com.trainingproject.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "assets")
public class Asset {

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
        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Asset{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }


    public static final class AssetBuilder {
        private Long id;
        private BigDecimal amount;


        public static AssetBuilder anAsset() {
            return new AssetBuilder();
        }

        public AssetBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AssetBuilder withAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Asset build() {
            Asset asset = new Asset();
            asset.setId(id);
            asset.setAmount(amount);
            return asset;
        }
    }
}
