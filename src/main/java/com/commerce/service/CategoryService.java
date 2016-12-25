package com.commerce.service;

import com.commerce.domain.Category;
import com.commerce.service.util.CategoryList;

/**
 * Created by suat on 12/23/16.
 */
public interface CategoryService {

    Category save (Category data);
    Category getCategoryByLink(String link);
    CategoryList findAll();

}
