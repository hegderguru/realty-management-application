package com.karur.asset_management_application.model.read;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

public class PriceDetail {
    private String priceMeasurementUnit;
    @Embedded
    private PricePerUnit pricePerUnit;

    @Embeddable
    private static class PricePerUnit {
        private String currency;
        private Double amount;
    }
}
