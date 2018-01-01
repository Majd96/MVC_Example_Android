package com.majd.mvc_example.Model;

/**
 * Created by majd on 12/31/17.
 */

public class Book
{
    private int BookId;
    private String title;
    private String bookAuthor;
    private String bookDesc;
    private String PublishedDate;
    private String CategoryName;
    private double price;
    private int edittion;
    private String coverImageURL;
    private double rate;
    public ShoppingCart theShoppingCart;



    public Book(String title,String bookDesk,double price)
    { this.title  = title;
        this.bookDesc  = bookDesk;
        this.price = price;

    }


    public void viewBookDetail()
    {

    }


    public void getRate()
    {

    }


    public void getReviews()
    {

    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getBookDesc() {
        return bookDesc;
    }
}
