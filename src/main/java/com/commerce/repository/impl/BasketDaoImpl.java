package com.commerce.repository.impl;

import com.commerce.domain.Basket;
import com.commerce.repository.BasketDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by suat on 12/25/16.
 */
@Repository
public class BasketDaoImpl implements BasketDao {

    private final Logger logger = LoggerFactory.getLogger(BasketDaoImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Basket findProductsInBasket(String productId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("products.productId").is(productId));
        logger.info("Query "+ query);
        return mongoTemplate.findOne(query, Basket.class);
    }
}
