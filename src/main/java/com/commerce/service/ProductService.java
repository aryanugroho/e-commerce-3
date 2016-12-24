package com.commerce.service;

import com.commerce.domain.Product;

import java.util.List;

/**
 * Created by suat on 12/23/16.
 */
public interface ProductService {

    Product save(Product data);
    List<Product> getByCategoryName (String name);

}
