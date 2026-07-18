package com.karur.realty_management_application.entity.asset.realty;

import com.karur.realty_management_application.entity.address.AddressEntity;
import com.karur.realty_management_application.entity.asset.AssetEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "realty_asset")
public abstract class RealtyAssetEntity extends AssetEntity {

    private Integer nELength;
    private Integer eSLength;
    private Integer sWLength;
    private Integer wNLength;

    @OneToOne(fetch = FetchType.LAZY)
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
