package com.karur.realty_management_application.entity.user;

import com.karur.realty_management_application.entity.Party;
import com.karur.realty_management_application.entity.address.AddressEntity;
import com.karur.realty_management_application.entity.organisation.OrganisationEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "access")
public class UserEntity implements Party {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "accessEntitySequence")
    @SequenceGenerator(name = "accessEntitySequence", sequenceName = "seq_access_d",initialValue = 1,allocationSize = 1,schema = "realty")
    private Long id;

    private String username;

    private AddressEntity presentAddressEntity;
    private AddressEntity homeAddressEntity;

    private OrganisationEntity organisationEntity;
}
