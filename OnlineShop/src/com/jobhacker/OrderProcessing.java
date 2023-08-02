package com.jobhacker;

import java.util.ArrayList;

public class OrderProcessing {
    private ArrayList<Product> products = new ArrayList<>();

    public OrderProcessing(){}


    public void placeHolder(ShoppingCart cart){
        int counter = 1;
        this.products = cart.getProducts();
        for (Product product : products){
            System.out.println(counter +" - " + product.getName() + " : " + product.getPrice() + " $");
            counter++;
        }
        System.out.println("the total cost is: " + cart.calculateTotalCost() + " $");
    }

}
