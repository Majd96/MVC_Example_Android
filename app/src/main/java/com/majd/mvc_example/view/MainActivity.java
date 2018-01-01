package com.majd.mvc_example.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.majd.mvc_example.Model.Book;
import com.majd.mvc_example.R;
import com.majd.mvc_example.controller.Controller;
import com.majd.mvc_example.view.SecondActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout lm =  findViewById(R.id.linearMain);
        final Button secondBtn =  findViewById(R.id.second);

        //Get Global Controller Class object (see application tag in AndroidManifest.xml)
        final Controller aController = (Controller) getApplicationContext();

        /******************  Create Dummy Products Data  ***********/

       Book productObject = null;
        for(int i=1;i<=4;i++)
        {
            int price = 10+i;
            // Create product model class object
            productObject = new Book("Book "+i,"Description "+i,price);

            //store product object to arraylist in controller
            aController.setProducts(productObject);

        }

        /******************  Products Data Creation End   ***********/


        /******* Create view elements dynamically and show on activity ******/

        //Product arraylist size
        int ProductsSize = aController.getProductsArraylistSize();

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        /******** Dynamically create view elements - Start **********/

        for(int j=0;j< ProductsSize;j++)
        {
            // Get probuct data from product data arraylist
            String pName = aController.getProducts(j).getTitle();
            double pPrice   = aController.getProducts(j).getPrice();

            // Create LinearLayout to view elemnts
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView product = new TextView(this);
            product.setText(" "+pName+"    ");

            //Add textView to LinearLayout
            ll.addView(product);

            TextView price = new TextView(this);
            price.setText("  $"+pPrice+"     ");

            //Add textView to LinearLayout
            ll.addView(price);

            final Button btn = new Button(this);
            btn.setId(j+1);
            btn.setText("Add To Cart");

            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;

            //Create click listener for dynamically created button
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    //Clicked button index
                    Log.i("TAG", "index :" + index);

                    // Get product instance for index
                    Book tempProductObject = aController.getProducts(index);

                    //Check Product already exist in Cart or Not
                    if(!aController.getCart().checkProductInCart(tempProductObject))
                    {
                        btn.setText("Added");

                        // Product not Exist in cart so add product to
                        // Cart product arraylist
                        aController.getCart().setProducts(tempProductObject);

                        Toast.makeText(getApplicationContext(),
                                "Now Cart size: "+aController.getCart().getCartSize(),
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        // Cart product arraylist contains Product
                        Toast.makeText(getApplicationContext(),
                                "Product "+(index+1)+" already added in cart.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

            //Add button to LinearLayout
            ll.addView(btn);

            //Add LinearLayout to XML layout
            lm.addView(ll);
        }

        /******** Dynamically create view elements - End **********/

        secondBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
