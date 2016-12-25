package com.commerce.rest.resources.asm;

import com.commerce.domain.Category;
import com.commerce.rest.mvc.CategoryController;
import com.commerce.rest.resources.CategoryResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by suat on 12/22/16.
 */
public class CategoryResourceAsm extends ResourceAssemblerSupport<Category, CategoryResource> {

    public CategoryResourceAsm() {
        super(CategoryController.class, CategoryResource.class);
    }

    @Override
    public CategoryResource toResource(Category category) {
        CategoryResource resources = new CategoryResource();
        resources.setName(category.getName());
        resources.setLink(category.getLink());
        resources.setCreatedDate(category.getCreatedDate());
        resources.add(linkTo(methodOn(CategoryController.class).getCategoryByValue(category.getId())).withSelfRel());
        return resources;
    }
}
