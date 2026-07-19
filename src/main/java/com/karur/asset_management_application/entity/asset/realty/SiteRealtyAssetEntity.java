package com.karur.asset_management_application.entity.asset.realty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "site_realty_asset")
public class SiteRealtyAssetEntity extends RealtyAssetEntity {

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "parent_site_realty_asset_id")
    private SiteRealtyAssetEntity parentSiteRealtyAssetEntity;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "parent_structure_realty_asset_id")
    private StructureRealtyAssetEntity structureRealtyAssetEntity;
}
