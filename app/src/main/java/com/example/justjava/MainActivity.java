package com.example.justjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    int quantity=1;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {

        quantity=quantity+1;
        display(quantity);
    }
    public void decrement(View view) {

        quantity=quantity-1;
        display (quantity);
    }
    public void submitOrder(View view) {
        CheckBox addBis = (CheckBox) findViewById(R.id.addBis);
        boolean bis = addBis.isChecked();
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, bis);
        displayMessage(priceMessage);
    }

    private int calculatePrice() {
        return quantity * 5;
    }
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public String createOrderSummary(int price, boolean wannaHaveBiscuits){
        String priceMessage = "Name : XXXX";
        priceMessage += "\nWanna have biscuits ?" + wannaHaveBiscuits;
        priceMessage  +=  "\nTotal: $ " + price + "\nThank you!";
        return priceMessage;
    }
}