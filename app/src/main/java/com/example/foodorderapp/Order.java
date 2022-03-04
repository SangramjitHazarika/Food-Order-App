package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.foodorderapp.Adapters.OrdersAdapter;
import com.example.foodorderapp.Models.Orders;
import com.example.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class Order extends AppCompatActivity {

    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Orders> list = new ArrayList<>();
        list.add(new Orders(R.drawable.burger, "Veggie Burgers", "100", "1342123434"));
        list.add(new Orders(R.drawable.burger, "Veggie Burgers", "100", "1342123434"));
        list.add(new Orders(R.drawable.burger, "Veggie Burgers", "100", "1342123434"));
        list.add(new Orders(R.drawable.burger, "Veggie Burgers", "100", "1342123434"));
        list.add(new Orders(R.drawable.burger, "Veggie Burgers", "100", "1342123434"));
        list.add(new Orders(R.drawable.burger, "Veggie Burgers", "100", "1342123434"));

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}