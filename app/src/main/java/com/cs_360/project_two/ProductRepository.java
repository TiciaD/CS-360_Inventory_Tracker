package com.cs_360.project_two;

import android.content.Context;

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

    private void addStarterData() {
        // Add a few products
        Product product = new Product(1, "Product 1", "Initial Product Description 1", 5);
        addProduct(product);

        Product product2 = new Product(2, "Product 2", "Initial Product Description 2", 10);
        addProduct(product2);

        Product product3 = new Product(3, "Product 3", "Initial Product Description 3", 15);
        addProduct(product2);
    }

    public void addProduct(Product product) {
        mProductList.add(product);
    }

    public Product getProduct(long productId) {
        for (Product product: mProductList) {
            if (product.getmId() == productId) {
                return product;
            }
        }

        return null;
    }

    public List<Product> getProducts() {
        return mProductList;
    }
}
