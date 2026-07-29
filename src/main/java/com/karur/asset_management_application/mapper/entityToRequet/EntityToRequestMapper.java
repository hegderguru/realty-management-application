package com.karur.asset_management_application.mapper.entityToRequet;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.request.AddressRequest;
import com.karur.asset_management_application.model.request.OrganisationRequest;
import com.karur.asset_management_application.model.request.OrganisationUserRequest;
import com.karur.asset_management_application.model.request.SiteRequest;
import org.springframework.stereotype.Component;

@Component
public class EntityToRequestMapper {

    public AddressRequest buildAddressRequest(AddressEntity addressEntity) {
        return EntityToAddressRequestMapper.buildAddressRequest(addressEntity);
    }

    public OrganisationUserRequest buildUserRequest(OrganisationUserEntity organisationUserEntity) {
        return EntityToOrganisationUserRequestMapper.buildOrganisationUserRequest(organisationUserEntity);
    }

    public SiteRequest buildSiteRequest(SiteEntity siteEntity) {
        return EntityToSiteRequestMapper.buildSiteRequest(siteEntity);
    }

    public OrganisationRequest buildOrganisationRequest(OrganisationEntity organisationEntity) {
        return EntityToOrganisationRequestMapper.buildOrganisationRequest(organisationEntity);
    }
}
