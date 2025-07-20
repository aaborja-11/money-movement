package com.aborja.moneymovement.sales.perisistence;

import com.aborja.moneymovement.sales.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalesRepository extends JpaRepository<Sales, UUID> {
}
