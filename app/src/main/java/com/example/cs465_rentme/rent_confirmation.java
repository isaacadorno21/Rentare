package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class rent_confirmation extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_confirmation);

        Button rent_home_button = findViewById(R.id.rent_home_button);
        Button rent_other_items_button = findViewById(R.id.rent_other_items_button);
        rent_home_button.setOnClickListener(this);
        rent_other_items_button.setOnClickListener(this);

        TextView tv1 = findViewById(R.id.price_total);
        Intent intent = getIntent();
        String price = intent.getStringExtra("total_price");
        String it_price = intent.getStringExtra("item_price");
        TextView tv2 = findViewById(R.id.per_day);
        tv2.setText("Price: " + it_price);
        tv1.setText(price + ".00");
    }

    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.rent_home_button) intent = new Intent(rent_confirmation.this, HomeScreen.class);
        else if (v.getId() == R.id.rent_other_items_button) intent = new Intent(rent_confirmation.this, rent_list.class);
        startActivity(intent);
    }
}