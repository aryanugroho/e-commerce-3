package com.commerce.service.util;

import com.commerce.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suat on 12/23/16.
 */
public class ProductList {

    private List<Product> products = new ArrayList<Product>();
    private String productId;

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
