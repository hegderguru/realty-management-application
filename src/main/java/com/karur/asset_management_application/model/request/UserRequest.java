package com.karur.asset_management_application.model.request;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
}
