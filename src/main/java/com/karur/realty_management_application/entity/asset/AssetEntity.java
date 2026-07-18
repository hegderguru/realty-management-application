package com.karur.realty_management_application.entity.asset;

import com.karur.realty_management_application.entity.party.Party;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "asset")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assetEntitySequence")
    @SequenceGenerator(name = "assetEntitySequence", sequenceName = "seq_asset_id", initialValue = 1, allocationSize = 1)
    private Long id;

    private String number;
    private Party belongsTo;
    private LocalDate registrationDate;

    @Embedded
    private Price price;

    @Embeddable
    private static class Price {
        private String priceMeasurementUnit;
        private PricePerUnit pricePerUnit;

        private static class PricePerUnit {
            private String currency;
            private Double amount;
        }
    }
}
