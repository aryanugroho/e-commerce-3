package com.commerce.domain;

/**
 * Created by suat on 12/25/16.
 */
public class ProductInBasket {

    private String productId;
    private String productName;
    private String fileName;
    private Number productPrice;
    private Number totalProductPrice;
    private Number quantity;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Number getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Number productPrice) {
        this.productPrice = productPrice;
    }

    public Number getTotalProductPrice() {
        return totalProductPrice;
    }

    public void setTotalProductPrice(Number totalProductPrice) {
        this.totalProductPrice = totalProductPrice;
    }

    public Number getQuantity() {
        return quantity;
    }

    public void setQuantity(Number quantity) {
        this.quantity = quantity;
    }
}
