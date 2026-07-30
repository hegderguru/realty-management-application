package com.karur.asset_management_application.entity;

import com.karur.asset_management_application.entity.address.AddressEntity;
import com.karur.asset_management_application.entity.asset.realty.SiteEntity;
import com.karur.asset_management_application.entity.party.Party;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@Entity
@Table(name = "owner_user")
@DiscriminatorValue("OWNER_USER")
public class OwnerUserEntity extends Party {

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "owner_user_site_id", joinColumns = @JoinColumn(name = "owner_user_id"), inverseJoinColumns = @JoinColumn(name = "site_id"))
    private List<SiteEntity> siteEntities;
}
