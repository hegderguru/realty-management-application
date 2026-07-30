package com.karur.asset_management_application.entity.party;

import com.karur.asset_management_application.entity.UserEntity;
import com.karur.asset_management_application.entity.address.AddressEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "organisation_user")
@DiscriminatorValue("ORGANISATION_USER")
public class OrganisationUserEntity extends UserEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id")
    private OrganisationEntity organisationEntity;
}
