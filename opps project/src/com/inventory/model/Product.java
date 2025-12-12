package com.inventory.model;

import java.time.LocalDate;

/**
 * Product class representing an item in the inventory.
 * Demonstrates Encapsulation - all fields are private with getters/setters.
 */
public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private Category category;
    private LocalDate dateAdded;
    private String supplier;

    // Constructor
    public Product(String productId, String name, String description, double price, 
                   int quantity, Category category, String supplier) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.supplier = supplier;
        this.dateAdded = LocalDate.now();
    }

    // Getters and Setters (Encapsulation)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    // Business logic methods
    public double getTotalValue() {
        return price * quantity;
    }

    public boolean isLowStock(int threshold) {
        return quantity <= threshold;
    }

    public void addStock(int amount) {
        if (amount > 0) {
            this.quantity += amount;
        } else {
            throw new IllegalArgumentException("Amount must be positive");
        }
    }

    public void removeStock(int amount) {
        if (amount > 0 && amount <= quantity) {
            this.quantity -= amount;
        } else {
            throw new IllegalArgumentException("Invalid amount or insufficient stock");
        }
    }

    @Override
    public String toString() {
        return String.format("Product{ID: %s, Name: %s, Price: $%.2f, Quantity: %d, Category: %s, Supplier: %s}",
                productId, name, price, quantity, category.getName(), supplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId != null && productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return productId != null ? productId.hashCode() : 0;
    }
}

