package com.karur.realty_management_application.model.read;

import com.karur.realty_management_application.entity.asset.AssetEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

public class Price {
    private String priceMeasurementUnit;
    @Embedded
    private AssetEntity.Price.PricePerUnit pricePerUnit;

    @Embeddable
    private static class PricePerUnit {
        private String currency;
        private Double amount;
    }
}
