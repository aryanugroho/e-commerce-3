package com.commerce.repository.jpa;

import com.commerce.domain.Basket;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by suat on 12/22/16.
 */
public interface BasketJpaRepository extends MongoRepository<Basket, String> {

    Basket findByName(String name);

}
