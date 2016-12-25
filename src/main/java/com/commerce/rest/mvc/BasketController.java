package com.commerce.rest.mvc;

import com.commerce.domain.Basket;
import com.commerce.service.BasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by suat on 12/25/16.
 */

@Controller
@RequestMapping("/rest/basket")
public class BasketController {

    private final Logger logger = LoggerFactory.getLogger(BasketController.class);

    private BasketService basketService;

    @Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Basket> createBasketRequest(@RequestBody Basket sentRequest) {

        Basket basket = basketService.merge(sentRequest);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Basket>(basket, headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Basket> getBasketByName() {

        Basket basket = basketService.findByName(null);
        return new ResponseEntity<Basket>(basket, HttpStatus.OK);

    }

}
