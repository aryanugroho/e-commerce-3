package com.commerce.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
public class CategoryListResource extends ResourceSupport {

    List<CategoryResource> categoryList = new ArrayList<CategoryResource>();

    public List<CategoryResource> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategoryResource> categoryList) {
        this.categoryList = categoryList;
    }
}
