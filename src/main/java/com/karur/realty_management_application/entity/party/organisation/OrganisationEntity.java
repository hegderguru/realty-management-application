package com.karur.realty_management_application.entity.party.organisation;

import com.karur.realty_management_application.entity.party.Party;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "organisation",schema = "party")
public class OrganisationEntity extends Party {
    private String number;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_organisation_id")
    private OrganisationEntity parentOrganisation;
    
}
