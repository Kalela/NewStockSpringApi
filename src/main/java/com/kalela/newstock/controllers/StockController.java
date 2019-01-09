package com.kalela.newstock.controllers;

import com.kalela.newstock.models.Stock;
import com.kalela.newstock.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
    String response;
    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List<Stock> allStock() {
        return stockRepository.findAll();
    }
}
