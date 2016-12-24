package com.commerce.repository;

import com.commerce.domain.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by suat on 12/22/16.
 */
public interface CategoryJpaRepository extends MongoRepository<Category, String> {

    @Query("{ 'name' : ?0 }")
    public Category getCategoryByName(String name);

}
