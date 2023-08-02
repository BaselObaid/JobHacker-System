package com.jobhacker;

import java.util.InputMismatchException;

public class Product {

    private String name;
    private double price;

    public Product(){}


    public void setName(String name) {
        if (!ValidationUtils.isNotNullOrEmpty(name)) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0.");
        }
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

}
