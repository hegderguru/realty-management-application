package com.karur.realty_management_application.entity.party.user;

import com.karur.realty_management_application.entity.party.Party;
import com.karur.realty_management_application.entity.address.AddressEntity;
import com.karur.realty_management_application.entity.party.organisation.OrganisationEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
@DiscriminatorValue("USER")
public class UserEntity extends Party {

    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity homeAddressEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private OrganisationEntity organisationEntity;
}
