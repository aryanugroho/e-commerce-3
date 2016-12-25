package com.commerce.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */

@Document(collection = "basket")
public class Basket extends BaseEntity<String> {

    @Indexed( unique=true )
    private String name;
    private Number quantity;
    private Number price;
    private Number tax;
    private List<ProductInBasket> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public Number getTax() {
        return tax;
    }

    public void setTax(Number tax) {
        this.tax = tax;
    }

    public List<ProductInBasket> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInBasket> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", tax=" + tax +
                ", products=" + products +
                '}';
    }
}
