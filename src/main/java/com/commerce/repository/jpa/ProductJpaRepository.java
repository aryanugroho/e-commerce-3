package com.commerce.repository.jpa;

import com.commerce.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
public interface ProductJpaRepository extends MongoRepository<Product, String> {

    //Not Supported
    @Query("{'categories.name': {'$in': ['name']} }")
    List<Product> getByCategoryName(String name);

}
