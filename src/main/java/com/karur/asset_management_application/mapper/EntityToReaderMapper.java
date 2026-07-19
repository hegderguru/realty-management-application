package com.karur.asset_management_application.mapper;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.model.read.UserDetail;
import com.karur.asset_management_application.repository.OrganisationEntityRepository;
import com.karur.asset_management_application.repository.OrganisationUserEntityRepository;
import com.karur.asset_management_application.repository.SiteEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityToReaderMapper {

    @Autowired
    SiteEntityRepository siteEntityRepository;

    @Autowired
    OrganisationEntityRepository organisationUserEntity;

    @Autowired
    OrganisationUserEntityRepository organisationUserEntityRepository;

    public UserDetail buildUserDetail(OrganisationUserEntity userEntity) {
        return UserDetail.builder()
                .username(userEntity.getUsername())
                .firstName(userEntity.getFirstName())
                .middleName(userEntity.getMiddleName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .build();
    }

    public SiteDetail buildSiteDetail(SiteEntity siteEntity) {
        return SiteDetail.builder()
                .number(siteEntity.getNumber())
                .registrationDate(siteEntity.getRegistrationDate())
                .nELength(siteEntity.getNELength())
                .eSLength(siteEntity.getESLength())
                .sWLength(siteEntity.getSWLength())
                .wNLength(siteEntity.getWNLength())
                .build();
    }

    public OrganisationDetail buildOrganisationDetail(OrganisationEntity organisationEntity) {
        return OrganisationDetail.builder()
                .name(organisationEntity.getName())
                .number(organisationEntity.getNumber())
                .description(organisationEntity.getDescription())
                .build();
    }
}
