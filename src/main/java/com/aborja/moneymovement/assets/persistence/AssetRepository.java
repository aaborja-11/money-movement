package com.aborja.moneymovement.assets.persistence;

import com.aborja.moneymovement.assets.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AssetRepository extends JpaRepository<Asset, UUID> {
}
