package com.commerce.rest.resources.asm;

import com.commerce.rest.mvc.CategoryController;
import com.commerce.rest.resources.CategoryListResource;
import com.commerce.service.util.CategoryList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by suat on 12/22/16.
 */
public class CategoryListResourceAsm extends ResourceAssemblerSupport<CategoryList, CategoryListResource> {

    public CategoryListResourceAsm() {
        super(CategoryController.class, CategoryListResource.class);
    }

    @Override
    public CategoryListResource toResource(CategoryList categoryList) {
        CategoryListResource listResource = new CategoryListResource();
        listResource.setCategoryList(new CategoryResourceAsm().toResources(categoryList.getCategoryList()));
        return listResource;
    }
}
