package com.commerce.repository;

import com.commerce.domain.Basket;

/**
 * Created by suat on 12/25/16.
 */
public interface BasketDao {

    Basket findProductsInBasket(String productId);

}
