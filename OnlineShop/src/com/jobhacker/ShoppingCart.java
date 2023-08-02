package com.jobhacker;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products = new ArrayList<>();

    public ShoppingCart(){}

    public ArrayList<Product> getProducts(){
        return this.products;
    }

    public void addProduct(Product product){
                this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public double calculateTotalCost(){
        double totalCost = 0.0;
        for(int i = 0; i < this.products.size(); i++){
            totalCost += this.products.get(i).getPrice();
        }
        return totalCost;
    }


}
