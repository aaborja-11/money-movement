package com.aborja.moneymovement.items.persistence;

import com.aborja.moneymovement.items.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    @Query("SELECT i FROM Item i WHERE i.assetId = :assetId and i.active is true")
    Page<Item> findActiveItemByAssetId(@Param("assetId") UUID assetId, Pageable pageable);

}
