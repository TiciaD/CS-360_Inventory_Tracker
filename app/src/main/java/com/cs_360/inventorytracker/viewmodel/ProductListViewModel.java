package com.cs_360.inventorytracker.viewmodel;

import android.app.Application;

import com.cs_360.inventorytracker.model.Product;
import com.cs_360.inventorytracker.repo.ProductRepository;

import java.util.List;

public class ProductListViewModel {
    private ProductRepository productRepo;

    public ProductListViewModel(Application application) {
        productRepo = ProductRepository.getInstance(application.getApplicationContext());
    }

    public List<Product> getProducts() {
        return productRepo.getProducts();
    }

    public void addProduct(Product subject) {
        productRepo.addProduct(subject);
    }
}
