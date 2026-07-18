package com.karur.realty_management_application.repository.inter;

import com.karur.realty_management_application.entity.asset.realty.SiteRealtyAssetEntity;
import com.karur.realty_management_application.entity.party.OrganisationEntity;
import com.karur.realty_management_application.entity.party.OrganisationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISiteRealtyAssetEntityRepository extends JpaRepository<SiteRealtyAssetEntity,Long> {
    Optional<OrganisationUserEntity> findUserEntityByBelongsToId(Long id);
    Optional<OrganisationEntity> findOrganisationEntityByBelongsToId(Long id);
    Optional<OrganisationEntity> findOrganisationEntityByParentSiteRealtyAssetEntityId(Long id);
    Optional<OrganisationUserEntity> findUserEntityByParentSiteRealtyAssetEntityBelongsToId(Long id);
}
