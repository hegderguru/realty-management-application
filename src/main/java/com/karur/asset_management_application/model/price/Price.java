package com.karur.asset_management_application.model.price;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class Price {
    private String priceMeasurementUnit;

    @Embedded
    private PricePerUnit pricePerUnit;
}
