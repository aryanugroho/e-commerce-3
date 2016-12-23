package com.commerce.service.impl;

import com.commerce.exception.CategoryNotFoundException;
import com.commerce.domain.Category;
import com.commerce.repository.CategoryRepository;
import com.commerce.repository.ProductRepository;
import com.commerce.service.CategoryService;
import com.commerce.service.util.CategoryList;
import com.commerce.service.util.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suat on 12/24/16.
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Category save(Category data) {
        return categoryRepository.save(data);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    @Override
    public CategoryList findAll() {
        return new CategoryList(categoryRepository.findAll());
    }

    @Override
    public ProductList getAllProductList(String categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        if ( category == null ) {
            throw new CategoryNotFoundException();
        }
        return new ProductList(categoryId, productRepository.getProductByCategoryId(categoryId));
    }
}
