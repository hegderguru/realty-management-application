package com.karur.asset_management_application.mapper;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.model.read.UserDetail;
import com.karur.asset_management_application.model.request.OrganisationRequest;
import com.karur.asset_management_application.model.request.SiteRequest;
import com.karur.asset_management_application.model.request.UserRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityToRequestMapper {

    public UserRequest buildUserDetail(OrganisationUserEntity userEntity) {
        return UserRequest.builder()
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .middleName(userEntity.getMiddleName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build();
    }

    public SiteRequest buildSiteDetail(SiteEntity siteEntity) {
        return SiteRequest.builder()
                .number(siteEntity.getNumber())
                .registrationDate(siteEntity.getRegistrationDate())
                .nELength(siteEntity.getNELength())
                .eSLength(siteEntity.getESLength())
                .sWLength(siteEntity.getSWLength())
                .wNLength(siteEntity.getWNLength())
                .build();
    }

    public OrganisationRequest buildOrganisationDetail(OrganisationEntity organisationEntity) {
        return OrganisationRequest.builder()
                .name(organisationEntity.getName())
                .number(organisationEntity.getNumber())
                .description(organisationEntity.getDescription())
                .build();
    }
}
