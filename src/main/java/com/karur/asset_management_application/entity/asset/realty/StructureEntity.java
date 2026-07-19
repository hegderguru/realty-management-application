package com.karur.asset_management_application.entity.asset.realty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "structure")
public class StructureEntity extends RealtyEntity {

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "parent_structure_id")
    private StructureEntity parentStructureEntity;
}
