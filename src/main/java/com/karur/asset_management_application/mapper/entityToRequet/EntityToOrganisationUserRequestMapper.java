package com.karur.asset_management_application.mapper.entityToRequet;

import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.request.OrganisationUserRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityToOrganisationUserRequestMapper {

    public static OrganisationUserRequest buildOrganisationUserRequest(OrganisationUserEntity userEntity){
        return OrganisationUserRequest.builder()
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .middleName(userEntity.getMiddleName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build();
    }
}
