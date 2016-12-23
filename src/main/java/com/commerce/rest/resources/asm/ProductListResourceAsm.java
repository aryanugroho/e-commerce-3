package com.commerce.rest.resources.asm;

import com.commerce.rest.mvc.CategoryController;
import com.commerce.rest.resources.ProductListResource;
import com.commerce.rest.resources.ProductResource;
import com.commerce.service.util.ProductList;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
public class ProductListResourceAsm extends ResourceAssemblerSupport<ProductList, ProductListResource> {

    public ProductListResourceAsm() {
        super(CategoryController.class, ProductListResource.class);
    }

    @Override
    public ProductListResource toResource(ProductList productList) {
        List<ProductResource> resources = new ProductResourceAsm().toResources(productList.getProducts());
        ProductListResource listResource = new ProductListResource();
        listResource.setProducts(resources);
        //listResource.add(linkTo(methodOn(CategoryController.class).findAllBlogEntries(productList.getProductId())).withSelfRel());
        return listResource;
    }
}
