package com.karur.realty_management_application.repository.inter;

import com.karur.realty_management_application.entity.party.OrganisationUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserEntityRepository extends JpaRepository<OrganisationUserEntity,Long> {
    Optional<OrganisationUserEntity> findByUsername(String username);
    Optional<List<OrganisationUserEntity>> findByOrganisationEntityId(Long organisationId);
    Optional<List<OrganisationUserEntity>> findByOrganisationEntityNumber(String number);
    Optional<List<OrganisationUserEntity>> findByOrganisationEntityName(String name);
}
