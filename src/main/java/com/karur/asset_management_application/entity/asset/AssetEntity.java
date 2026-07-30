package com.karur.asset_management_application.entity.asset;

import com.karur.asset_management_application.entity.party.Party;
import com.karur.asset_management_application.model.price.Price;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "asset")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assetEntitySequence")
    @SequenceGenerator(name = "assetEntitySequence", sequenceName = "seq_asset_id", initialValue = 1, allocationSize = 1)
    private Long id;

    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_id")
    private List<Party> belongsTo;
    private LocalDate registrationDate;

    @Embedded
    private Price price;
}
