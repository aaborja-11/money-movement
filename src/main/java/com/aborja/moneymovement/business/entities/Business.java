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
//@Data
//@EqualsAndHashCode(callSuper=false)
//@SuperBuilder(toBuilder=true)
//@Builder
public class Business {

    @Column(nullable = false)
    private String name;

    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(SqlTypes.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, updatable = false)
    private String createdBy = System.MONEY_MOVEMENT.getValue();

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;

    @Column(nullable = false)
    private String updatedBy = System.MONEY_MOVEMENT.getValue();

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedTimestamp;

    @Version
    @Column(nullable = false)
    private long version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Instant createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Instant getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Instant updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Business() { }

    public Business(String name, UUID id, String createdBy, Instant createdTimestamp, String updatedBy, Instant updatedTimestamp, long version) {
        this.name = name;
        this.id = id;
        this.createdBy = createdBy;
        this.createdTimestamp = createdTimestamp;
        this.updatedBy = updatedBy;
        this.updatedTimestamp = updatedTimestamp;
        this.version = version;
    }
}
