package com.karur.asset_management_application.model.request;


import com.karur.asset_management_application.model.read.AddressDetail;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerUserRequest {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    private AddressDetail addressDetail;
}
