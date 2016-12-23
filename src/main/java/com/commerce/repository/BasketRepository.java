package com.commerce.repository;

import com.commerce.domain.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by suat on 12/22/16.
 */
public interface BasketRepository extends MongoRepository<Basket, String> {
}
