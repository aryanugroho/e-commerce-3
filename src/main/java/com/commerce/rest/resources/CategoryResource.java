package com.commerce.rest.resources;

import com.commerce.domain.Category;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by suat on 12/22/16.
 */
public class CategoryResource extends ResourceSupport {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setName(name);
        return category;

    }
}
