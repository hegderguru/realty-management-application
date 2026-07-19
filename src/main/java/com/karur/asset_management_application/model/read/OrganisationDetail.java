package com.karur.asset_management_application.model.read;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganisationDetail {
    private String number;
    private String name;
    private String description;
}
