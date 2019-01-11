package com.kalela.newstock.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;
    private Integer stockAmount;
    private Float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(Integer stockAmount) {
        this.stockAmount = stockAmount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
