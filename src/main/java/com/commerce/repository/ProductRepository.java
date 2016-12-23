package com.commerce.repository;

import com.commerce.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'categoryId' : { '$regex' : ?0, '$options' : ''}}")
    List<Product> getProductByCategoryId(String categoryId);

}
