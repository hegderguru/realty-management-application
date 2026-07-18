package com.karur.realty_management_application.entity.realty;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "site_realty_asset")
public class StructureRealtyAssetEntity extends RealtyAssetEntity{
    private Integer floors;
}
