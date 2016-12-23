package com.commerce.service;

import com.commerce.domain.Category;
import com.commerce.service.util.CategoryList;
import com.commerce.service.util.ProductList;

/**
 * Created by suat on 12/23/16.
 */
public interface CategoryService {

    Category save (Category data);
    Category getCategoryByName(String name);
    CategoryList findAll();
    ProductList getAllProductList(String id);

}