package com.fikreynurz.microservices.inventory.repository;

import com.fikreynurz.microservices.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

// import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsBySkuCodeAndQuantityGreaterThanEqual(String skuCode, int quantity);
}