package com.karur.realty_management_application.entity.realty;

import com.karur.realty_management_application.entity.address.AddressEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "realty_asset", schema = "asset")
public abstract class RealtyAssetEntity extends AssetEntity {

    private Long latitude;
    private Long longitude;

    private Integer nELength;
    private Integer eSLength;
    private Integer sWLength;
    private Integer wNLength;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "n_realty_asset_id")
    private RealtyAssetEntity nRealtyAssetEntity;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "e_realty_asset_id")
    private RealtyAssetEntity eRealtyAssetEntity;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "s_realty_asset_id")
    private RealtyAssetEntity sRealtyAssetEntity;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "w_realty_asset_id")
    private RealtyAssetEntity wRealtyAssetEntity;

}
