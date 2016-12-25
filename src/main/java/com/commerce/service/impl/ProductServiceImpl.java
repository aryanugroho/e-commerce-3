package com.commerce.service.impl;

import com.commerce.domain.Product;
import com.commerce.repository.impl.ProductDaoImpl;
import com.commerce.repository.jpa.ProductJpaRepository;
import com.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by suat on 12/24/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    ProductJpaRepository productJpaRepository;
    ProductDaoImpl repository;

    @Autowired
    public ProductServiceImpl(ProductJpaRepository productJpaRepository, ProductDaoImpl repository) {
        this.productJpaRepository = productJpaRepository;
        this.repository = repository;
    }

    @Override
    public Product save(Product data) {
        return productJpaRepository.save(data);
    }

    @Override
    public Product getProductDetail(String id) {
        return productJpaRepository.findOne(id);
    }

    @Override
    public List<Product> getByCategoryName(String name) {
        return repository.getByCategoryName(name);
    }


}
