package com.karur.asset_management_application.repository.inter;

import com.karur.asset_management_application.entity.asset.realty.StructureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStructureEntityRepository extends JpaRepository<StructureEntity,Long> {
}
