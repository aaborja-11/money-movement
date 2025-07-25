package com.aborja.moneymovement.assets.entities;

import com.aborja.moneymovement.assets.valueobjects.AssetLabel;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "assets")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Asset extends BaseEntity {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(nullable = false, name = "name"))
    })
    private AssetLabel assetLabel;

}
