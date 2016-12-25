package com.commerce.rest.resources.asm;

import com.commerce.domain.Product;
import com.commerce.rest.mvc.ProductController;
import com.commerce.rest.resources.ProductResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by suat on 12/22/16.
 */
public class ProductResourceAsm extends ResourceAssemblerSupport<Product, ProductResource> {

    public ProductResourceAsm() {
        super(ProductController.class, ProductResource.class);
    }

    @Override
    public ProductResource toResource(Product product) {
        ProductResource productResource = new ProductResource();
        productResource.setRid(product.getId());
        productResource.setName(product.getName());
        productResource.setDetail(product.getDetail());
        productResource.setColor(product.getColor());
        productResource.setSize(product.getSize());
        productResource.setFileName(product.getFileName());
        productResource.setCategories(product.getCategories());
        productResource.setPrice(product.getPrice());
        Link self = linkTo(ProductController.class).slash(product.getId()).withSelfRel();
        productResource.add(self);
        if(product.getCategories() != null)
        {
            productResource.add((linkTo(ProductController.class).slash(product.getCategories()).withRel("categories")));
        }
        return productResource;
    }
}
