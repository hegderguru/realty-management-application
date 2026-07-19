package com.karur.asset_management_application.model.read;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SiteDetail {
    private String number;
    private LocalDate registrationDate;
    private PriceDetail priceDetail;
    private Integer nELength;
    private Integer eSLength;
    private Integer sWLength;
    private Integer wNLength;
}
