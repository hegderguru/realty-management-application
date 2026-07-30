package com.karur.asset_management_application.entity;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.entity.party.Party;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public abstract class UserEntity extends Party {

    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressEntity homeAddressEntity;

}
