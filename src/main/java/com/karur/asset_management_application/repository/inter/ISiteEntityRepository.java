package com.karur.asset_management_application.repository.inter;

import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.OrganisationEntity;
import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISiteEntityRepository extends JpaRepository<SiteEntity,Long> {
    Optional<OrganisationEntity> findByNumber(String number);
    Optional<OrganisationUserEntity> findUserEntityByBelongsToId(Long id);
    Optional<OrganisationEntity> findOrganisationEntityByBelongsToId(Long id);
    Optional<OrganisationEntity> findOrganisationEntityByParentSiteEntityId(Long id);
    Optional<OrganisationUserEntity> findUserEntityByParentSiteEntityBelongsToId(Long id);
}
