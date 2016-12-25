package com.commerce.domain;

import com.commerce.domain.dto.CategoryDto;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by suat on 12/22/16.
 */

@Document(collection = "product")
public class Product extends BaseEntity<String> {

    private String name;
    private String detail;
    private String color;
    private String size;
    private String price;
    private String fileName;

    private List<CategoryDto> categories;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", fileName='" + fileName + '\'' +
                ", categories=" + categories +
                '}';
    }
}
