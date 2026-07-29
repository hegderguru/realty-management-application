package com.karur.asset_management_application.model.price;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class PricePerUnit {
    private String currency;
    private Double amount;
}
