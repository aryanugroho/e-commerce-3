package com.commerce.repository.impl;

import com.commerce.domain.Product;
import com.commerce.repository.ProductDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by suat on 12/24/16.
 */

@Repository
public class ProductDaoImpl implements ProductDao{

    static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> getByCategoryName (String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("categories.name").is(name));
        logger.info("Query "+ query);
        return mongoTemplate.find(query, Product.class);
    }

}
