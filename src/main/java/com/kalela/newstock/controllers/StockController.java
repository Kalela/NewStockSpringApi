package com.kalela.newstock.controllers;

import com.kalela.newstock.models.Stock;
import com.kalela.newstock.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody Stock stock) {
        stockRepository.save(stock);
        return stock.getItemName() + " added to Inventory.";
    }
}
