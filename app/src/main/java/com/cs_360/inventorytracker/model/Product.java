package com.cs_360.inventorytracker.model;

import java.util.ArrayList;

public class Product {
    public static ArrayList<Product> productArrayList = new ArrayList<>();

    private int id;
    private String name;
    private String description;
    private int quantity;

    public Product(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public static Product getProductById(int productId) {
        for (Product product: productArrayList) {
            if (product.getId() == productId) {
                return product;
            }
        }

        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
