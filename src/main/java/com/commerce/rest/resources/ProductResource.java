package com.commerce.rest.resources;

import com.commerce.domain.Product;
import com.commerce.domain.dto.CategoryDto;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */
public class ProductResource extends ResourceSupport {

    private String rid;
    private String name;
    private String detail;
    private String color;
    private String size;
    private String fileName;
    private String price;
    private List<CategoryDto> categories;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Product toProduct(){
        Product product = new Product();
        product.setId(rid);
        product.setName(name);
        product.setDetail(detail);
        product.setColor(color);
        product.setSize(size);
        product.setPrice(price);
        product.setFileName(fileName);
        product.setCategories(categories);
        return product;
    }
}
