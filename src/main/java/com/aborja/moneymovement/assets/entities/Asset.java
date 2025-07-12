package com.aborja.moneymovement.assets.entities;

import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "assets")
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Asset extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
