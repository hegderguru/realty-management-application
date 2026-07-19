package com.karur.asset_management_application.repository;

import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import com.karur.asset_management_application.repository.inter.ISiteEntityRepository;
import com.karur.asset_management_application.repository.inter.IOrganisationUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrganisationUserEntityRepository {

    @Autowired
    private IOrganisationUserEntityRepository iOrganisationUserEntityRepository;

    @Autowired
    private ISiteEntityRepository iSiteEntityRepository;

    public Optional<OrganisationUserEntity> fetchByUsername(String username) {
        return iOrganisationUserEntityRepository.findByUsername(username);
    }

    public Optional<OrganisationUserEntity> fetchById(Long id) {
        return iOrganisationUserEntityRepository.findById(id);
    }

    public Optional<List<OrganisationUserEntity>> fetchAllByOrganisationId(Long id) {
        return iOrganisationUserEntityRepository.findAllByOrganisationEntityId(id);
    }

    public Optional<List<OrganisationUserEntity>> fetchUserEntitiesForOrganisationNumber(String number) {
        return iOrganisationUserEntityRepository.findAllByOrganisationEntityNumber(number);
    }

    public Optional<List<OrganisationUserEntity>> fetchUserEntitiesForOrganisationNabe(String name) {
        return iOrganisationUserEntityRepository.findAllByOrganisationEntityName(name);
    }

    public Optional<OrganisationUserEntity> fetchUserEntityBySiteAssetRealtyBelongsToId(Long id) {
        return iSiteEntityRepository.findUserEntityByBelongsToId(id);
    }

}
