package com.aborja.moneymovement.shared.persistence;

import com.aborja.moneymovement.shared.constants.System;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.UUID;

@SuperBuilder(toBuilder=true)
@MappedSuperclass
@Data
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Builder.Default
    @Column(nullable = false, updatable = false)
    private String createdBy = System.MONEY_MOVEMENT.getValue();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;

    @Builder.Default
    @Column(nullable = false)
    private String updatedBy = System.MONEY_MOVEMENT.getValue();

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedTimestamp;

    @Version
    @Column(nullable = false)
    private long version;

}
