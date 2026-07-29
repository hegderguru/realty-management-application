package com.karur.asset_management_application.model.request;


import com.karur.asset_management_application.model.read.OrganisationDetail;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganisationUserRequest {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    private AddressRequest addressRequest;
    private OrganisationDetail organisationDetail;
}
