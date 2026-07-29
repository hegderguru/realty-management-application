package com.karur.asset_management_application.mapper.entityToDetail;

import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.read.OrganisationUserDetail;
import org.springframework.stereotype.Component;

@Component
public class EntityToOrganisationUserDetailMapper {

    public static OrganisationUserDetail buildOrganisationUserDetail(OrganisationUserEntity userEntity){
        return OrganisationUserDetail.builder()
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .middleName(userEntity.getMiddleName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build();
    }
}
