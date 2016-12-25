package com.commerce;

import com.commerce.domain.Basket;
import com.commerce.domain.Category;
import com.commerce.domain.Product;
import com.commerce.domain.ProductInBasket;
import com.commerce.domain.dto.CategoryDto;
import com.commerce.repository.jpa.BasketJpaRepository;
import com.commerce.repository.jpa.CategoryJpaRepository;
import com.commerce.repository.jpa.ProductJpaRepository;
import com.commerce.service.BasketService;
import com.commerce.util.NumberOperations;
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

import static org.junit.Assert.assertEquals;

/**
 * Created by suat on 12/25/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BasketRepositoryTests {

    @Autowired
    BasketService service;

    @Autowired
    BasketJpaRepository basketJpaRepository;

    @Autowired
    ProductJpaRepository productJpaRepository;

    @Autowired
    CategoryJpaRepository categoryJpaRepository;

    private String permanentLink = "category";
    private String productId;

    @Before
    public void setUp() throws Exception {

        Category category = new Category();
        category.setName("Category 1");
        category.setCreatedDate(new Date());
        category.setLink(permanentLink);
        categoryJpaRepository.save(category);

        Product product = new Product();
        product.setName("Product Name");
        product.setPrice(String.valueOf(12));
        product.setColor("Red");
        product.setSize("Large");

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        List<CategoryDto> cats = new ArrayList<>();
        cats.add(categoryDto);
        product.setCategories(cats);

        productJpaRepository.save(product);
        Product productInMongoDb = productJpaRepository.findOne(product.getId());
        productId = productInMongoDb.getId();

    }

    @Test
    public void name() throws Exception {
        Basket basket = new Basket();
        basket.setName("test-basket");
        Product product = productJpaRepository.findOne(productId);
        ProductInBasket productInBasket = new ProductInBasket();
        productInBasket.setProductName(product.getName());
        productInBasket.setProductPrice(Integer.valueOf(product.getPrice()));
        productInBasket.setQuantity(10);
        List<ProductInBasket> productInBaskets = new ArrayList<>();
        productInBaskets.add(productInBasket);
        basket.setProducts(productInBaskets);

        service.merge(basket);

        assertEquals(NumberOperations.multiplyNumber(productInBasket.getQuantity(), Integer.valueOf(product.getPrice())), service.findByName("test-basket").getPrice());

        basketJpaRepository.delete(basket);

    }

    @After
    public void tearDown() throws Exception {
        Category category = categoryJpaRepository.getCategoryByLink(permanentLink);
        categoryJpaRepository.delete(category);

        Product product = productJpaRepository.findOne(productId);
        productJpaRepository.delete(product);

    }
}
