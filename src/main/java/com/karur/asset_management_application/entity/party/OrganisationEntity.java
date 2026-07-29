package com.karur.asset_management_application.entity.party;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
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
