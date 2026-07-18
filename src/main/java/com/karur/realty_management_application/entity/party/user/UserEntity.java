package com.karur.realty_management_application.entity.party.user;

import com.karur.realty_management_application.entity.party.Party;
import com.karur.realty_management_application.entity.address.AddressEntity;
import com.karur.realty_management_application.entity.party.organisation.OrganisationEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity extends Party {

    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
    private AddressEntity homeAddressEntity;
    private OrganisationEntity organisationEntity;
}
