package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger, "Burger", "100", "Veggie Burgers"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "200", "BBQ Chicken Pizza"));
        list.add(new MainModel(R.drawable.frenchfries, "French Fries", "0", "This offer is up to 15 September 2021"));
        list.add(new MainModel(R.drawable.hotdog, "HotDog", "150", "Chicago-style hot dog"));
        list.add(new MainModel(R.drawable.pastry, "Pastry", "109", "Chocolate Pastry"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }
}