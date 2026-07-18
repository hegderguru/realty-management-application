package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.address.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRepository extends JpaRepository<AddressEntity,Long> {
}
