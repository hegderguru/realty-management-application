package com.karur.asset_management_application.entity.party;

import com.karur.asset_management_application.entity.address.AddressEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "party")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "party_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyEntitySequence")
    @SequenceGenerator(name = "partyEntitySequence", sequenceName = "seq_party_d",initialValue = 1,allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private AddressEntity presentAddressEntity;
}
