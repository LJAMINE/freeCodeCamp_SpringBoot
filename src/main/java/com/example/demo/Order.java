package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

    @JsonProperty("c-name")
    private String customerName;

    @JsonProperty("p-name")
    private String productName;

    @JsonProperty("quentity")
    private  int quentity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", productName='" + productName + '\'' +
                ", quentity=" + quentity +
                '}';
    }
}
