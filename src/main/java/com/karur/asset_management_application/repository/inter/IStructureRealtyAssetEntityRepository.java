package com.karur.asset_management_application.repository.inter;

import com.karur.asset_management_application.entity.asset.realty.StructureRealtyAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStructureRealtyAssetEntityRepository extends JpaRepository<StructureRealtyAssetEntity,Long> {
}
