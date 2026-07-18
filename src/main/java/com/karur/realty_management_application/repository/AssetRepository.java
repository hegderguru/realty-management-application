package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.asset.realty.SiteRealtyAssetEntity;
import com.karur.realty_management_application.entity.party.organisation.OrganisationEntity;
import com.karur.realty_management_application.entity.party.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AssetRepository {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    OrganisationEntityRepository organisationEntityRepository;

    @Autowired
    SiteRealtyAssetEntityRepository siteRealtyAssetEntityRepository;

    public Optional<UserEntity> fetchByUserEntityName(String username) {
        return userEntityRepository.findByUsername(username);
    }

    public Optional<UserEntity> fetchByUserEntityId(Long id) {
        return userEntityRepository.findById(id);
    }

    public Optional<List<UserEntity>> fetchUserEntitiesForOrganisationId(Long id) {
        return userEntityRepository.findByOrganisationEntityId(id);
    }

    public Optional<List<UserEntity>> fetchUserEntitiesForOrganisationNumber(String number) {
        return userEntityRepository.findByOrganisationEntityNumber(number);
    }

    public Optional<List<UserEntity>> fetchUserEntitiesForOrganisationNabe(String name) {
        return userEntityRepository.findByOrganisationEntityName(name);
    }

    public Optional<UserEntity> fetchUserEntityBySiteAssetRealtyBelongsToId(Long id) {
        return siteRealtyAssetEntityRepository.findUserEntityByBelongsToId(id);
    }

    public Optional<OrganisationEntity> fetchOrganisationEntityById(Long id) {
        return organisationEntityRepository.findById(id);
    }

    public Optional<OrganisationEntity> fetchOrganisationEntityByNumber(String name) {
        return organisationEntityRepository.findByNumber(name);
    }

    public Optional<OrganisationEntity> fetchOrganisationEntityByName(String name) {
        return organisationEntityRepository.findByName(name);
    }

    public Optional<List<OrganisationEntity>> fetchOrganisationEntitiesByParentId(Long id) {
        return organisationEntityRepository.findByParentOrganisationId(id);
    }

    public Optional<List<OrganisationEntity>> fetchOrganisationEntitiesByParentNumber(String number) {
        return organisationEntityRepository.findByParentOrganisationNumber(number);
    }

    public Optional<List<OrganisationEntity>> fetchOrganisationEntitiesByParentName(String name) {
        return organisationEntityRepository.findByParentOrganisationName(name);
    }

    public Optional<OrganisationEntity> fetchOrganisationBySiteAssetRealtyBelongsToId(Long id) {
        return siteRealtyAssetEntityRepository.findOrganisationEntityByBelongsToId(id);
    }

    public Optional<OrganisationEntity> fetchByParentSiteRealtyAssetEntityId(Long id) {
        return siteRealtyAssetEntityRepository.findOrganisationEntityByParentSiteRealtyAssetEntityId(id);
    }

    public Optional<SiteRealtyAssetEntity> fetchBySiteRealtyAssetEntityId(Long id) {
        return siteRealtyAssetEntityRepository.findById(id);
    }

}
