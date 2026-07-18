package com.karur.realty_management_application.entity.asset.realty;

import jakarta.persistence.*;

@Entity
@Table(name = "site_realty_asset",schema = "asset")
public class SiteRealtyAssetEntity extends RealtyAssetEntity {

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "parent_site_realty_asset_id")
    private SiteRealtyAssetEntity parentSiteRealtyAssetEntity;
    private StructureRealtyAssetEntity structureRealtyAssetEntity;
}
