package com.karur.realty_management_application.entity.organisation;

import com.karur.realty_management_application.entity.Party;
import com.karur.realty_management_application.entity.address.AddressEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "organisation")
public class OrganisationEntity implements Party {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organisationEntitySequence")
    @SequenceGenerator(name = "organisationEntitySequence", sequenceName = "seq_organisation_d",initialValue = 1,allocationSize = 1,schema = "realty")
    private Long id;

    private String number;
    private String name;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_organisation_id")
    private List<OrganisationEntity> parentOrganisation;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "address_id")
    private AddressEntity address;
    
}
