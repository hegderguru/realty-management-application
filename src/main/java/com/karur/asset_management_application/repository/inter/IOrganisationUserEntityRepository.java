package com.karur.asset_management_application.repository.inter;

import com.karur.asset_management_application.entity.party.OrganisationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrganisationUserEntityRepository extends JpaRepository<OrganisationUserEntity,Long> {
    Optional<OrganisationUserEntity> findByUsername(String username);
    Optional<List<OrganisationUserEntity>> findAllByOrganisationEntityId(Long organisationId);
    Optional<List<OrganisationUserEntity>> findAllByOrganisationEntityNumber(String number);
    Optional<List<OrganisationUserEntity>> findAllByOrganisationEntityName(String name);
}
