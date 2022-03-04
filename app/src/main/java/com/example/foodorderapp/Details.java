package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailsBinding;

public class Details extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image", 0 );
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("description");

        binding.item.setImageResource(image);
        binding.finprice.setText(String.format("%d",price));
        binding.foodname.setText(name);
        binding.detailedDesc.setText(description);

        DBHelper helper = new DBHelper(this);
        binding.ordernow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertOrder(
                        binding.userName.getText().toString(),
                        binding.userPhone.getText().toString(),
                        price,
                        image,
                        Integer.parseInt(binding.quantity.getText().toString()),
                        description,
                        name);
                if(isInserted) {
                    Toast.makeText(Details.this, "Success!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Details.this, "Sorry, Error occurred!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}