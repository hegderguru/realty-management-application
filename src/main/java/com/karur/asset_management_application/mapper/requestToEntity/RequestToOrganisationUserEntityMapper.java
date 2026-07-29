package com.karur.asset_management_application.mapper.requestToEntity;

import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.request.OrganisationUserRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestToOrganisationUserEntityMapper {

    public static OrganisationUserEntity buildOrganisationUserEntity(OrganisationUserRequest organisationUserRequest) {
        return OrganisationUserEntity.builder()
                .username(organisationUserRequest.getUsername())
                .firstName(organisationUserRequest.getFirstName())
                .middleName(organisationUserRequest.getMiddleName())
                .lastName(organisationUserRequest.getLastName())
                .email(organisationUserRequest.getEmail())
                .phone(organisationUserRequest.getPhone())
                .build();
    }
}
