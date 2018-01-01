package com.majd.mvc_example.Model;

import java.util.ArrayList;

/**
 * Created by majd on 12/31/17.
 */

public class ShoppingCart {
    private ArrayList<Book> cartProducts = new ArrayList<>();


    public Book getProducts(int pPosition) {

        return cartProducts.get(pPosition);
    }

    public void setProducts(Book book) {

        cartProducts.add(book);

    }

    public int getCartSize() {

        return cartProducts.size();

    }

    public boolean checkProductInCart(Book book) {

        return cartProducts.contains(book);

    }

}
