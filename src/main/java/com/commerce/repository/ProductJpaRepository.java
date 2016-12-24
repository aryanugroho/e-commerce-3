package com.commerce.repository;

import com.commerce.domain.Product;
import com.commerce.service.util.ProductList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by suat on 12/22/16.
 */
public interface ProductJpaRepository extends MongoRepository<Product, String> {

    @Query("{'name': {'$in': ['categories.name']} }")
    ProductList getByCategoryName(String name);

}
