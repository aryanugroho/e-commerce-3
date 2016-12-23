package com.commerce.service.util;

import com.commerce.domain.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suat on 12/23/16.
 */
public class CategoryList {

    private List<Category> categoryList = new ArrayList<Category>();

    public CategoryList(List resultList) {
        this.categoryList = resultList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
