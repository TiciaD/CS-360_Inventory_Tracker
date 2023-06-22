package com.cs_360.inventorytracker.repo;

import android.content.Context;

import com.cs_360.inventorytracker.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private static ProductRepository mProductRepo;
    private final List<Product> mProductList;

    public static ProductRepository getInstance(Context context) {
        if (mProductRepo == null) {
            mProductRepo = new ProductRepository(context);
        }
        return mProductRepo;
    }

    private ProductRepository(Context context) {

        mProductList = new ArrayList<>();
        addStarterData();
    }

    public void addStarterData() {
        // Add a few subjects and questions
        Product product = new Product("Product 1", "Initial description", 5);
        product.setId(1);
        addProduct(product);

//        product = new Product("Product 2", "Initial description 2", 10);
//        product.setId(2);
//        addProduct(product);
//
//        product = new Product("Product 2", "Initial description 3", 15);
//        product.setId(3);
//        addProduct(product);

    }

    public void addProduct(Product product) {
        mProductList.add(product);
    }

    public Product getProduct(int productId) {
        for (Product product: mProductList) {
            if (product.getId() == productId) {
                return product;
            }
        }

        return null;
    }

    public List<Product> getProducts() {
        return mProductList;
    }

}
