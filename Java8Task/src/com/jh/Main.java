package com.jh;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {


    private static void productIterator(List<Product> productList){
        for (Product product : productList){
            System.out.println(product.toString());
        }
    }

    public static void main(String[] args) {

        List<Product> productList = Product.addDummyData(); // add some product to the list
        // Example 1
        List<Product> booksList = obtainBooks(productList);
        productIterator(booksList);
        System.out.println("\n*************************************");
        //////////////////////////////////////////////
        // Example 2
        List<Product> books = filterBooksByPrice(booksList);
        productIterator(books);
        System.out.println("\n*************************************");
        ///////////////////////////////////////////////
        // Example 3
        List<Product> toysListWithDiscount = obtainDiscountedToys(productList);
        productIterator(toysListWithDiscount);
        System.out.println("\n*************************************");
        //////////////////////////////////////////////
        //Example 4
        Optional<Product> cheapestBook = getCheapestBook(booksList);
        System.out.println(cheapestBook.toString());

    }

    //  Obtain a list of products belongs to category “Books”
    private static List<Product> obtainBooks(List<Product> productList){
        return  productList.stream().
                filter(product->"Books".equals(product.getCategory())).
                collect(Collectors.toList());
    }

    //Obtain a list of products belongs to category “Books” with price > 100
    private static List<Product> filterBooksByPrice(List<Product> booksProductList){
        return  booksProductList.stream().
                filter((product) -> product.getPrice()>100).
                collect(Collectors.toList());
    }

    //Obtain a list of product with category = “Toys” and then apply 10% discount
    // withPrice() method make a new product with the discount
    private static List<Product> obtainDiscountedToys(List<Product> productList){
        return  productList.stream().
                filter(product -> "Toys".equals(product.getCategory())).
                map(product -> {
                    // Apply 10% discount
                    double afterDiscount = product.getPrice() * 0.9;
                    return product.withPrice(afterDiscount);}).
                collect(Collectors.toList());
    }

    //Get the cheapest products of “Books” category
    // i use Optional class to deal with NullPointerException
    private static Optional<Product> getCheapestBook(List<Product> booksList) {
        if (booksList == null || booksList.isEmpty()) {
            return Optional.empty();
        }
        return booksList.stream()
                .min(Comparator.comparingDouble(Product::getPrice));
    }
}
