package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.party.organisation.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationEntityRepository extends JpaRepository<OrganisationEntity,Long> {
}
