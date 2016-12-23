package com.commerce.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */

@Document(collection = "basket")
public class Basket extends BaseEntity<String> {

    private int quantity;
    private double price;
    private List<Product> products;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "quantity=" + quantity +
                ", price=" + price +
                ", products=" + products +
                '}';
    }
}
