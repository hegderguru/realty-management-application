package com.karur.asset_management_application.mapper.requestToEntity;

import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.model.request.OrganisationRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestToOrganisationEntityMapper {

    public static OrganisationEntity buildOrganisationEntity(OrganisationRequest organisationRequest) {
        OrganisationEntity organisationEntity = OrganisationEntity.builder()
                .number(organisationRequest.getNumber())
                .build();
        organisationEntity.setName(organisationRequest.getName());
        organisationRequest.setDescription(organisationRequest.getDescription());
        return organisationEntity;
    }
}
