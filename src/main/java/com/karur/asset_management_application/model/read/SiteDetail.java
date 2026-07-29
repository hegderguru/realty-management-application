package com.karur.asset_management_application.model.read;

import com.karur.asset_management_application.model.price.Price;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SiteDetail {
    private String number;
    private LocalDate registrationDate;
    private Price price;
    private Integer nELength;
    private Integer eSLength;
    private Integer sWLength;
    private Integer wNLength;

    private SiteDetail parentSiteDetail;

    private AddressDetail presentAddressDetail;

    private OrganisationUserDetail belongsToOrganisationUserDetail;

    private OrganisationDetail belongsToOrganisation;


}
