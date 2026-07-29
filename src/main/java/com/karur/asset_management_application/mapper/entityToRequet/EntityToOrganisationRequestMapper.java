package com.karur.asset_management_application.mapper.entityToRequet;

import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import com.karur.asset_management_application.model.request.OrganisationRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityToOrganisationRequestMapper {

    public static OrganisationRequest buildOrganisationRequest(OrganisationEntity organisationEntity){
        return OrganisationRequest.builder()
                .number(organisationEntity.getNumber())
                .name(organisationEntity.getName())
                .description(organisationEntity.getDescription())
                .build();
    }
}
