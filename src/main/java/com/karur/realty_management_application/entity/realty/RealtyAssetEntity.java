package com.karur.realty_management_application.entity.realty;

import com.karur.realty_management_application.entity.address.AddressEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "realty_asset",schema = "realty")
public class RealtyAssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "realtyAssetEntitySequence")
    @SequenceGenerator(name = "realtyAssetEntitySequence", sequenceName = "seq_realty_asset_d",initialValue = 1,allocationSize = 1,schema = "realty")
    private Long id;

    private String number;
    private String type;
    private Long latitude;
    private Long longitude;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;
}
