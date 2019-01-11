package com.kalela.newstock.controllers;

import com.kalela.newstock.models.Stock;
import com.kalela.newstock.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String addUser(@Valid @RequestBody Stock stock) {
        stockRepository.save(stock);
        return stock.getItemName() + " added to Inventory.";
    }

    @PutMapping("/{id}")
    public String updateStock(@PathVariable Long id, @RequestBody Stock updatedStock) {
        String responseString;
        Stock storedStockDetails = stockRepository.getOne(id);

        if (updatedStock.getPrice() != null) {
            storedStockDetails.setPrice(updatedStock.getPrice());
        }
        if (updatedStock.getItemName() != null) {
            storedStockDetails.setItemName(updatedStock.getItemName());
        }
        if (updatedStock.getStockAmount() != null) {
            storedStockDetails.setStockAmount(updatedStock.getStockAmount());
        }

        if (storedStockDetails.getStockAmount() == 0 && !storedStockDetails.getItemName().contains("Out of stock")) {
            storedStockDetails.setItemName(storedStockDetails.getItemName());
            responseString = storedStockDetails.getItemName() + " Out of stock ";
        } else {
            responseString = storedStockDetails.getItemName() +
                    " updated to: " +
                    " | Stock left - " +
                    storedStockDetails.getStockAmount() +
                    " | Name - " +
                    storedStockDetails.getItemName() +
                    " | Price - " +
                    storedStockDetails.getPrice() + " | ";
        }

        stockRepository.save(storedStockDetails);
        return responseString;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id) {
        Stock storedStockDetails = stockRepository.getOne(id);
        stockRepository.delete(storedStockDetails);
        return storedStockDetails.getItemName() + " deleted successfully";
    }
}
