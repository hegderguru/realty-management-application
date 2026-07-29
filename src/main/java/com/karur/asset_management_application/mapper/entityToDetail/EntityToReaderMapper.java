package com.karur.asset_management_application.mapper.entityToDetail;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.model.read.AddressDetail;
import com.karur.asset_management_application.model.read.OrganisationDetail;
import com.karur.asset_management_application.model.read.SiteDetail;
import com.karur.asset_management_application.model.read.OrganisationUserDetail;
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

    public AddressDetail buildAddressDetail(AddressEntity addressEntity) {
       return EntityToAddressDetailMapper.buildAddressDetail(addressEntity);
    }

    public OrganisationUserDetail buildUserDetail(OrganisationUserEntity organisationUserEntity) {
        return EntityToOrganisationUserDetailMapper.buildOrganisationUserDetail(organisationUserEntity);
    }

    public SiteDetail buildSiteDetail(SiteEntity siteEntity) {
        return EntityToSiteDetailMapper.buildSiteDetail(siteEntity);
    }

    public OrganisationDetail buildOrganisationDetail(OrganisationEntity organisationEntity) {
        return EntityToOrganisationDetailMapper.buildOrganisationDetail(organisationEntity);
    }
}
