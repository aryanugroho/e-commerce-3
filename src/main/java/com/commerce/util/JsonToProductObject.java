package com.commerce.util;

import com.commerce.rest.resources.ProductResource;
import com.google.gson.Gson;

/**
 * Created by suat on 12/24/16.
 */
public class JsonToProductObject {

    public ProductResource toProductResource( String detail ) {
        Gson gson = new Gson();
        ProductResource productResource = gson.fromJson(detail, ProductResource.class );
        return productResource;
    }

}
