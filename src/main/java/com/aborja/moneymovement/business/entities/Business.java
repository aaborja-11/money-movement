package com.aborja.moneymovement.business.entities;

import com.aborja.moneymovement.shared.constants.System;
import com.aborja.moneymovement.shared.persistence.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder=true)
public class Business extends BaseEntity {

    @Column(nullable = false)
    private String name;

}
