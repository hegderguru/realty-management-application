package com.karur.realty_management_application.entity.address;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addressEntitySequence")
    @SequenceGenerator(name = "addressEntitySequence", sequenceName = "seq_address_asset_d",initialValue = 1,allocationSize = 1)
    private Long id;

    private String number;
    private String name;
    private  String line1;
    private  String line2;
    private  String line13;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String phone;
    private Long latitude;
    private Long longitude;
}
