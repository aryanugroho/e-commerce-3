package com.commerce;

import com.commerce.domain.Category;
import com.commerce.repository.jpa.CategoryJpaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * Created by suat on 12/24/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryRepositoryTests {


    @Autowired
    CategoryJpaRepository repository;

    @Autowired
    MongoOperations operations;

    private String permanentLink = "category";

    @Before
    public void init(){

    }

    public CategoryRepositoryTests() {
    }

    @Test
    public void testSave() {
        Category category = new Category();
        category.setName("Test Category Name");
        category.setLink(permanentLink);
        category.setCreatedDate(new Date());
        repository.save(category);

        assertNotNull(category.getLink(), repository.getCategoryByLink(permanentLink));

    }

    @After
    public void deleteDocument(){
        Category category = repository.getCategoryByLink(permanentLink);
        repository.delete(category);
    }


}
