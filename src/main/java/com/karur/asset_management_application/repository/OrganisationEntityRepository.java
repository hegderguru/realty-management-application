package com.karur.asset_management_application.repository;

import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.repository.inter.IOrganisationEntityRepository;
import com.karur.asset_management_application.repository.inter.ISiteEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrganisationEntityRepository {


    @Autowired
    IOrganisationEntityRepository iOrganisationEntityRepository;

    @Autowired
    ISiteEntityRepository iSiteEntityRepository;

    public Optional<OrganisationEntity> fetchOrganisationEntityById(Long id) {
        return iOrganisationEntityRepository.findById(id);
    }

    public Optional<OrganisationEntity> fetchOrganisationEntityByNumber(String name) {
        return iOrganisationEntityRepository.findByNumber(name);
    }

    public Optional<OrganisationEntity> fetchOrganisationEntityByName(String name) {
        return iOrganisationEntityRepository.findByName(name);
    }

    public Optional<List<OrganisationEntity>> fetchOrganisationEntitiesByParentId(Long id) {
        return iOrganisationEntityRepository.findByParentOrganisationId(id);
    }

    public Optional<List<OrganisationEntity>> fetchOrganisationEntitiesByParentNumber(String number) {
        return iOrganisationEntityRepository.findByParentOrganisationNumber(number);
    }

    public Optional<List<OrganisationEntity>> fetchOrganisationEntitiesByParentName(String name) {
        return iOrganisationEntityRepository.findByParentOrganisationName(name);
    }

    public Optional<OrganisationEntity> fetchOrganisationBySiteAssetRealtyBelongsToId(Long id) {
        return iSiteEntityRepository.findOrganisationEntityByBelongsToId(id);
    }

    public Optional<OrganisationEntity> fetchByParentSiteRealtyAssetEntityId(Long id) {
        return iSiteEntityRepository.findOrganisationEntityByParentSiteEntityId(id);
    }

}
