package com.karur.asset_management_application.model.request;


import com.karur.asset_management_application.model.read.PriceDetail;

import java.time.LocalDate;

public class SiteRequest {
    private String number;
    private LocalDate registrationDate;
    private PriceDetail priceDetail;
    private Integer nELength;
    private Integer eSLength;
    private Integer sWLength;
    private Integer wNLength;
}
