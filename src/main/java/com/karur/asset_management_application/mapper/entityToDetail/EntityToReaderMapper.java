package com.karur.asset_management_application.mapper.entityToDetail;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.read.AddressDetail;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.model.read.OrganisationUserDetail;
import org.springframework.stereotype.Component;

@Component
public class EntityToReaderMapper {

    public AddressDetail buildAddressDetail(AddressEntity addressEntity) {
        return EntityToAddressDetailMapper.buildAddressDetail(addressEntity);
    }

    public OrganisationUserDetail buildUserDetail(OrganisationUserEntity organisationUserEntity) {
        OrganisationUserDetail organisationUserDetail = EntityToOrganisationUserDetailMapper.buildOrganisationUserDetail(organisationUserEntity);
        organisationUserDetail.setAddressDetail(buildAddressDetail(organisationUserEntity.getHomeAddressEntity()));
        organisationUserDetail.setOrganisationDetail(buildOrganisationDetail(organisationUserEntity.getOrganisationEntity()));
        return organisationUserDetail;
    }

    public SiteDetail buildSiteDetail(SiteEntity siteEntity) {
        SiteDetail siteDetail = EntityToSiteDetailMapper.buildSiteDetail(siteEntity);
        siteDetail.setParentSiteDetail(EntityToSiteDetailMapper.buildSiteDetail(siteEntity.getParentSiteEntity()));
        return siteDetail;
    }

    public OrganisationDetail buildOrganisationDetail(OrganisationEntity organisationEntity) {
        OrganisationDetail organisationDetail = EntityToOrganisationDetailMapper.buildOrganisationDetail(organisationEntity);
        organisationDetail.setParentOrganisationDetail(EntityToOrganisationDetailMapper.buildOrganisationDetail(organisationEntity.getParentOrganisation()));
        return organisationDetail;
    }
}
