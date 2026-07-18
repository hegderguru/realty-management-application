package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.asset.realty.SiteRealtyAssetEntity;
import com.karur.realty_management_application.entity.party.organisation.OrganisationEntity;
import com.karur.realty_management_application.entity.party.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiteRealtyAssetEntityRepository extends JpaRepository<SiteRealtyAssetEntity,Long> {
    Optional<UserEntity> findUserEntityByBelongsToId(Long id);
    Optional<OrganisationEntity> findOrganisationEntityByBelongsToId(Long id);
    Optional<OrganisationEntity> findOrganisationEntityByParentSiteRealtyAssetEntityId(Long id);
    Optional<UserEntity> findUserEntityByParentSiteRealtyAssetEntityBelongsToId(Long id);
}
