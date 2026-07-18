package com.karur.realty_management_application.entity.party;

import com.karur.realty_management_application.entity.address.AddressEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "party")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partyEntitySequence")
    @SequenceGenerator(name = "partyEntitySequence", sequenceName = "seq_party_d",initialValue = 1,allocationSize = 1)
    private Long id;

    private String name;
    private String description;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "address_id")
    private AddressEntity presentAddressEntity;
}
