package com.karur.asset_management_application.model.read;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AddressDetail {
    private String number;
    private String name;
    private  String line1;
    private  String line2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private Long latitude;
    private Long longitude;
    private String phone;
}
