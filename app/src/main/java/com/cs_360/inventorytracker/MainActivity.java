package com.cs_360.inventorytracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cs_360.inventorytracker.model.Product;
import com.cs_360.inventorytracker.repo.ProductRepository;
import com.cs_360.inventorytracker.viewmodel.ProductListViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProductRepository productRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProductListViewModel mProductListViewModel = new ProductListViewModel(getApplication());

        RecyclerView recyclerView = findViewById(R.id.grid_recycler_view);

        setUpInitialProducts();

        ProductAdapter adapter =  new ProductAdapter(this, mProductListViewModel.getProducts());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpInitialProducts() {
        productRepo.addStarterData();
    }
}