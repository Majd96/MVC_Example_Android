package com.majd.mvc_example.controller;

import android.app.Application;

import com.majd.mvc_example.Model.Book;
import com.majd.mvc_example.Model.ShoppingCart;

import java.util.ArrayList;

/**
 * Created by majd on 12/31/17.
 */

public class Controller extends Application {


    private ArrayList<Book> myProducts = new ArrayList<>();
    private ShoppingCart myCart = new ShoppingCart();


    public Book getProducts(int pPosition) {

        return myProducts.get(pPosition);
    }

    public void setProducts(Book Products) {

        myProducts.add(Products);

    }

    public ShoppingCart getCart() {

        return myCart;

    }

    public int getProductsArraylistSize() {

        return myProducts.size();
    }




}
