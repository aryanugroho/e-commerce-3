package com.commerce.service;

import com.commerce.domain.Product;

/**
 * Created by suat on 12/23/16.
 */
public interface ProductService {

    Product save(Product data);
    Product getById(String id);


}
