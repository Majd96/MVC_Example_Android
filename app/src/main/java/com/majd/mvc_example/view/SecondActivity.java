package com.majd.mvc_example.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.majd.mvc_example.R;
import com.majd.mvc_example.controller.Controller;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView showCartContent    = (TextView) findViewById(R.id.showCart);


        //Get Global Controller Class object (see application tag in AndroidManifest.xml)
        final Controller aController = (Controller) getApplicationContext();

        // Get Cart Size
        final int cartSize = aController.getCart().getCartSize();



/******** Show Cart Products on screen - Start ********/

        if(cartSize >0)
        {

            for(int i=0;i<cartSize;i++)
            {
                //Get product details
                String pName    = aController.getCart().getProducts(i).getTitle();
                double pPrice      = aController.getCart().getProducts(i).getPrice();
                String pDisc    = aController.getCart().getProducts(i).getBookDesc();

               showCartContent.append("Product Name :"+pName+"   Price : "+pPrice+"   Discription : "+pDisc+"\n");

            }
        }
        else
            showCartContent.setText("Shopping cart is empty.");



    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
