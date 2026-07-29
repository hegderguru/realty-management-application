package com.karur.asset_management_application.model.read;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganisationUserDetail {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
}
