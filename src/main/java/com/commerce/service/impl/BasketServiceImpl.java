package com.commerce.service.impl;

import com.commerce.domain.Basket;
import com.commerce.repository.impl.BasketDaoImpl;
import com.commerce.repository.jpa.BasketJpaRepository;
import com.commerce.service.BasketService;
import com.commerce.util.NumberOperations;
import org.apache.commons.collections.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by suat on 12/25/16.
 */
@Service
public class BasketServiceImpl implements BasketService {

    private final Number taxRate = 18.0;
    private String defaultBasketName = "basket";
    private BasketDaoImpl basketDao;
    private BasketJpaRepository repository;

    @Autowired
    public BasketServiceImpl(BasketDaoImpl basketDao, BasketJpaRepository repository) {
        this.basketDao = basketDao;
        this.repository = repository;
    }

    @Override
    public Basket merge(Basket basket) {

        Basket defaultBasketInMongo = findByName(basket.getName());
        if (defaultBasketInMongo == null) {
            basket.getProducts().get(0).setTotalProductPrice(NumberOperations.multiplyNumber(basket.getProducts().get(0).getProductPrice(), basket.getProducts().get(0).getQuantity()));
            basket.setPrice(basket.getProducts().get(0).getTotalProductPrice());
            basket.setTax(getTotalTax(basket.getPrice()));
            basket.setQuantity(basket.getProducts().get(0).getQuantity());
            basket = repository.save(basket);
        } else {
            Basket foundedBasket = basketDao.findProductsInBasket(basket.getProducts().get(0).getProductId());
            if (foundedBasket != null) {

                foundedBasket.getProducts().get(0).setQuantity(
                        NumberOperations.addNumber(foundedBasket.getProducts().get(0).getQuantity(), basket.getProducts().get(0).getQuantity()));
                foundedBasket.setQuantity(
                        NumberOperations.addNumber(foundedBasket.getQuantity(), basket.getProducts().get(0).getQuantity()));

                foundedBasket.getProducts().get(0).setTotalProductPrice(
                        NumberOperations.multiplyNumber(basket.getProducts().get(0).getProductPrice(), foundedBasket.getProducts().get(0).getQuantity()));

                foundedBasket.setPrice(
                        NumberOperations.addNumber(foundedBasket.getPrice(),
                                NumberOperations.multiplyNumber(basket.getProducts().get(0).getProductPrice(), basket.getProducts().get(0).getQuantity())));

                foundedBasket.setTax(getTotalTax(foundedBasket.getPrice()));

                repository.save(foundedBasket);
            } else {
                defaultBasketInMongo.setProducts(
                        ListUtils.union(basket.getProducts(), defaultBasketInMongo.getProducts()));
                defaultBasketInMongo.setQuantity(
                        NumberOperations.addNumber(defaultBasketInMongo.getQuantity(), basket.getProducts().get(0).getQuantity()));
                defaultBasketInMongo.setPrice(
                        NumberOperations.addNumber(
                                NumberOperations.multiplyNumber(
                                        basket.getProducts().get(0).getProductPrice(), basket.getProducts().get(0).getQuantity()), defaultBasketInMongo.getPrice()));
                defaultBasketInMongo.getProducts().get(0).setTotalProductPrice(
                        NumberOperations.multiplyNumber(basket.getProducts().get(0).getProductPrice(), basket.getProducts().get(0).getQuantity()));

                defaultBasketInMongo.setTax(getTotalTax(defaultBasketInMongo.getPrice()));

                repository.save(defaultBasketInMongo);
            }
        }
        return basket;
    }

    @Override
    public Basket findByName(String name) {
        return repository.findByName(name == null ? defaultBasketName : name);
    }

    private Number getTotalTax(Number price){
        return NumberOperations.divideNumberForDouble(
                    NumberOperations.multiplyNumber(price, taxRate), 100);
    }


}
