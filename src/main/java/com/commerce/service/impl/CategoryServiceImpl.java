package com.commerce.service.impl;

import com.commerce.domain.Category;
import com.commerce.repository.jpa.CategoryJpaRepository;
import com.commerce.repository.jpa.ProductJpaRepository;
import com.commerce.service.CategoryService;
import com.commerce.service.util.CategoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        data.setCreatedDate(new Date());
        return categoryJpaRepository.save(data);
    }

    @Override
    public Category getCategoryByLink(String link) {
        return categoryJpaRepository.getCategoryByLink(link);
    }

    @Override
    public CategoryList findAll() {
        return new CategoryList(categoryJpaRepository.findAll());
    }

}
