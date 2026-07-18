package com.karur.realty_management_application.repository.inter;

import com.karur.realty_management_application.entity.party.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserEntityRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<List<UserEntity>> findByOrganisationEntityId(Long organisationId);
    Optional<List<UserEntity>> findByOrganisationEntityNumber(String number);
    Optional<List<UserEntity>> findByOrganisationEntityName(String name);
}
