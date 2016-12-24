package com.commerce.service.impl;

import com.commerce.domain.Category;
import com.commerce.repository.CategoryJpaRepository;
import com.commerce.repository.ProductJpaRepository;
import com.commerce.service.CategoryService;
import com.commerce.service.util.CategoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suat on 12/24/16.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    @Autowired
    ProductJpaRepository productRepository;

    @Override
    public Category save(Category data) {
        return categoryJpaRepository.save(data);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryJpaRepository.getCategoryByName(name);
    }

    @Override
    public CategoryList findAll() {
        return new CategoryList(categoryJpaRepository.findAll());
    }

}
