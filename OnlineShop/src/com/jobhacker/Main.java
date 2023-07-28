package com.jobhacker;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args){

        // we make products samples
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        Product p5 = new Product();

        p1.setName("p1");
        p1.setPrice(100);
        p2.setName("p2");
        p2.setPrice(200);
        p3.setName("p3");
        p3.setPrice(300);


        /*
        p4.setName(""); // it will print our exception
        p4.setPrice(100);
        p5.setName("p3");
        p5.setPrice(0);// it will print our exception
        */

        // make a cart obj
        ShoppingCart cart = new ShoppingCart();

        // add some product to the cart
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        // print the total cost
        System.out.println("the total cost is: " + cart.calculateTotalCost() + "$\n*********");

        // make an order obj
        OrderProcessing order = new OrderProcessing();
        order.placeHolder(cart);

    }
}
