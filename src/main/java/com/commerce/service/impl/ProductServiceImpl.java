package com.commerce.service.impl;

import com.commerce.domain.Product;
import com.commerce.repository.ProductRepository;
import com.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suat on 12/24/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product data) {
        return productRepository.save(data);
    }

    @Override
    public Product getById(String productId) {
        return productRepository.findOne(productId);
    }
}
