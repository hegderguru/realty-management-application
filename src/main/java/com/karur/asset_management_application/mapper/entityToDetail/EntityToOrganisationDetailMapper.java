package com.karur.asset_management_application.mapper.entityToDetail;

import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import org.springframework.stereotype.Component;

@Component
public class EntityToOrganisationDetailMapper {

    public static OrganisationDetail buildOrganisationDetail(OrganisationEntity organisationEntity){
        return OrganisationDetail.builder()
                .number(organisationEntity.getNumber())
                .name(organisationEntity.getName())
                .description(organisationEntity.getDescription())
                .build();
    }
}
