package com.karur.realty_management_application.repository;

import com.karur.realty_management_application.entity.asset.realty.StructureRealtyAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StructureRealtyAssetEntityRepository extends JpaRepository<StructureRealtyAssetEntity,Long> {
}
