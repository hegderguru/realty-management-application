package com.karur.asset_management_application.mapper.requestToEntity;

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
public class RequestToReaderMapper {

    public AddressEntity buildAddressEntity(AddressRequest addressRequest) {
        return RequestToAddressEntityMapper.buildAddressEntity(addressRequest);
    }

    public OrganisationUserEntity buildOrganisationUserEntity(OrganisationUserRequest organisationUserRequest) {
        return RequestToOrganisationUserEntityMapper.buildOrganisationUserEntity(organisationUserRequest);
    }

    public SiteEntity buildSiteEntity(SiteRequest siteRequest) {
        return RequestToSiteEntityMapper.buildSiteEntity(siteRequest);
    }

    public OrganisationEntity buildOrganisationEntity(OrganisationRequest organisationRequest) {
        return RequestToOrganisationEntityMapper.buildOrganisationEntity(organisationRequest);
    }
}
