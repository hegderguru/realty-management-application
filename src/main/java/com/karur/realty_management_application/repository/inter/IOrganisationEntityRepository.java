package com.karur.realty_management_application.repository.inter;

import com.karur.realty_management_application.entity.party.organisation.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrganisationEntityRepository extends JpaRepository<OrganisationEntity,Long> {
    public Optional<OrganisationEntity> findByNumber(String name);
    public Optional<OrganisationEntity> findByName(String name);

    Optional<List<OrganisationEntity>> findByParentOrganisationId(Long id);
    Optional<List<OrganisationEntity>> findByParentOrganisationNumber(String number);
    Optional<List<OrganisationEntity>> findByParentOrganisationName(String name);
}
