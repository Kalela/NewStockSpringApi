package com.kalela.newstock.repositories;

import com.kalela.newstock.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
