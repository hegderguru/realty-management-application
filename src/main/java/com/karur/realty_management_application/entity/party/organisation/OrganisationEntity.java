package com.karur.realty_management_application.entity.party.organisation;

import com.karur.realty_management_application.entity.party.Party;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "organisation")
@DiscriminatorValue("ORGANISATION")
public class OrganisationEntity extends Party {
    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_organisation_id")
    private OrganisationEntity parentOrganisation;
    
}
