package com.karur.asset_management_application.repository;

import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.repository.inter.ISiteRealtyAssetEntityRepository;
import com.karur.asset_management_application.repository.inter.IUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository {

    @Autowired
    private IUserEntityRepository iUserEntityRepository;

    @Autowired
    private ISiteRealtyAssetEntityRepository iSiteRealtyAssetEntityRepository;

    public Optional<OrganisationUserEntity> fetchByUserEntityName(String username) {
        return iUserEntityRepository.findByUsername(username);
    }

    public Optional<OrganisationUserEntity> fetchByUserEntityId(Long id) {
        return iUserEntityRepository.findById(id);
    }

    public Optional<List<OrganisationUserEntity>> fetchUserEntitiesForOrganisationId(Long id) {
        return iUserEntityRepository.findByOrganisationEntityId(id);
    }

    public Optional<List<OrganisationUserEntity>> fetchUserEntitiesForOrganisationNumber(String number) {
        return iUserEntityRepository.findByOrganisationEntityNumber(number);
    }

    public Optional<List<OrganisationUserEntity>> fetchUserEntitiesForOrganisationNabe(String name) {
        return iUserEntityRepository.findByOrganisationEntityName(name);
    }

    public Optional<OrganisationUserEntity> fetchUserEntityBySiteAssetRealtyBelongsToId(Long id) {
        return iSiteRealtyAssetEntityRepository.findUserEntityByBelongsToId(id);
    }

}
