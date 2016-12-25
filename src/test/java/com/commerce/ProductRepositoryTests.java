package com.commerce;

import com.commerce.domain.Category;
import com.commerce.domain.Product;
import com.commerce.domain.dto.CategoryDto;
import com.commerce.repository.ProductDao;
import com.commerce.repository.jpa.CategoryJpaRepository;
import com.commerce.repository.jpa.ProductJpaRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by suat on 12/24/16.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductRepositoryTests {

    @Autowired
    ProductJpaRepository productJpaRepository;

    @Autowired
    ProductDao productDao;

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    private String permanentLink = "category";

    @Before
    public void setUp() throws Exception {
        Category category = new Category();
        category.setName("Category 1");
        category.setCreatedDate(new Date());
        category.setLink(permanentLink);
        categoryJpaRepository.save(category);

    }

    @Test
    public void productOperationTest() throws Exception {
        Product product = new Product();
        product.setName("Product Name");
        product.setPrice(String.valueOf(12));
        product.setColor("Red");
        product.setSize("Large");

        Category category = categoryJpaRepository.getCategoryByLink(permanentLink);
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        List<CategoryDto> cats = new ArrayList<>();
        cats.add(categoryDto);
        product.setCategories(cats);

        productJpaRepository.save(product);

        assertNotNull(product.getName(), productJpaRepository.findOne(product.getId()));

        productJpaRepository.delete(product);
    }

    @After
    public void tearDown() throws Exception {
        Category category = categoryJpaRepository.getCategoryByLink(permanentLink);
        categoryJpaRepository.delete(category);
    }


}
