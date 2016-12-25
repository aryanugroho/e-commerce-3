package com.commerce.rest.mvc;

import com.commerce.domain.Category;
import com.commerce.rest.resources.CategoryListResource;
import com.commerce.rest.resources.CategoryResource;
import com.commerce.rest.resources.asm.CategoryListResourceAsm;
import com.commerce.rest.resources.asm.CategoryResourceAsm;
import com.commerce.service.CategoryService;
import com.commerce.service.util.CategoryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

/**
 * Created by suat on 12/22/16.
 */
@Controller
@RequestMapping("/rest/category")
public class CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CategoryResource> createCategoryRequest(@RequestBody CategoryResource sentRequest) {

        Category createdCategory = categoryService.save(sentRequest.toCategory());
        CategoryResource res = new CategoryResourceAsm().toResource(createdCategory);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(res.getLink("self").getHref()));
        return new ResponseEntity<CategoryResource>(res, headers, HttpStatus.CREATED);

    }

    @RequestMapping( value="/{link}", method = RequestMethod.GET)
    public ResponseEntity<CategoryResource> getCategoryByValue(@PathVariable String link) {
        Category category = categoryService.getCategoryByLink(link);
        if (category != null) {
            CategoryResource res = new CategoryResourceAsm().toResource(category);
            return new ResponseEntity<CategoryResource>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<CategoryResource>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<CategoryListResource> findAll() {
        CategoryList categoryList = categoryService.findAll();
        CategoryListResource categoryListRes = new CategoryListResourceAsm().toResource(categoryList);
        return new ResponseEntity<CategoryListResource>(categoryListRes, HttpStatus.OK);
    }

}
