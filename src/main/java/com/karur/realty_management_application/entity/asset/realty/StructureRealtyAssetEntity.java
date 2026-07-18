package com.karur.realty_management_application.entity.asset.realty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "structure_realty_asset")
public class StructureRealtyAssetEntity extends RealtyAssetEntity {

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "parent_structure_realty_asset_id")
    private StructureRealtyAssetEntity parentStructureRealtyAssetEntity;
}
