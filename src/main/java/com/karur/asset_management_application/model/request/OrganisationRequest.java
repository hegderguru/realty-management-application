package com.karur.asset_management_application.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganisationRequest {
    private String number;
    private String name;
    private String description;
}
