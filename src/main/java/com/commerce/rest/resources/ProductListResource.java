package com.commerce.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
public class ProductListResource extends ResourceSupport {

    private List<ProductResource> products;

    public List<ProductResource> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResource> products) {
        this.products = products;
    }
}
