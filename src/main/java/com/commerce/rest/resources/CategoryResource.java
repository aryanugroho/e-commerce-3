package com.commerce.rest.resources;

import com.commerce.domain.Category;
import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by suat on 12/22/16.
 */
public class CategoryResource extends ResourceSupport {

    String name;
    String link;
    Date createdDate;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category toCategory() {
        Category category = new Category();
        category.setName(name);
        category.setLink(link);
        category.setCreatedDate(createdDate);
        return category;

    }
}
