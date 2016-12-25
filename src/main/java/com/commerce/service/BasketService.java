package com.commerce.service;

import com.commerce.domain.Basket;

/**
 * Created by suat on 12/25/16.
 */
public interface BasketService {

    Basket merge(Basket basket);
    Basket findByName(String name);
}
