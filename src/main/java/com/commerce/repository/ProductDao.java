package com.commerce.repository;

import com.commerce.domain.Product;

import java.util.List;

/**
 * Created by suat on 12/24/16.
 */
public interface ProductDao {

    List<Product> getByCategoryName (String name);

}
