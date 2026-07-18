package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.party.user.UserEntity;
import com.karur.realty_management_application.repository.inter.ISiteRealtyAssetEntityRepository;
import com.karur.realty_management_application.repository.inter.IUserEntityRepository;
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

    public Optional<UserEntity> fetchByUserEntityName(String username) {
        return iUserEntityRepository.findByUsername(username);
    }

    public Optional<UserEntity> fetchByUserEntityId(Long id) {
        return iUserEntityRepository.findById(id);
    }

    public Optional<List<UserEntity>> fetchUserEntitiesForOrganisationId(Long id) {
        return iUserEntityRepository.findByOrganisationEntityId(id);
    }

    public Optional<List<UserEntity>> fetchUserEntitiesForOrganisationNumber(String number) {
        return iUserEntityRepository.findByOrganisationEntityNumber(number);
    }

    public Optional<List<UserEntity>> fetchUserEntitiesForOrganisationNabe(String name) {
        return iUserEntityRepository.findByOrganisationEntityName(name);
    }

    public Optional<UserEntity> fetchUserEntityBySiteAssetRealtyBelongsToId(Long id) {
        return iSiteRealtyAssetEntityRepository.findUserEntityByBelongsToId(id);
    }

}
