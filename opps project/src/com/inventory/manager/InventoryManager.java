package com.inventory.manager;

import com.inventory.interfaces.IInventory;
import com.inventory.model.Product;
import java.util.*;

/**
 * InventoryManager class implementing IInventory interface.
 * Demonstrates:
 * - Interface Implementation
 * - Encapsulation (private data structures)
 * - Single Responsibility Principle
 */
public class InventoryManager implements IInventory {
    private Map<String, Product> products;
    private static InventoryManager instance;

    // Private constructor for Singleton pattern
    private InventoryManager() {
        this.products = new HashMap<>();
    }

    // Singleton pattern implementation
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product with ID " + product.getProductId() + " already exists");
        }
        products.put(product.getProductId(), product);
        System.out.println("Product added successfully: " + product.getName());
    }

    @Override
    public void removeProduct(String productId) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Product removed successfully: " + removed.getName());
        } else {
            System.out.println("Product with ID " + productId + " not found");
        }
    }

    @Override
    public Product getProduct(String productId) {
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        return products.get(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (!products.containsKey(product.getProductId())) {
            throw new IllegalArgumentException("Product with ID " + product.getProductId() + " does not exist");
        }
        products.put(product.getProductId(), product);
        System.out.println("Product updated successfully: " + product.getName());
    }

    @Override
    public boolean productExists(String productId) {
        return products.containsKey(productId);
    }

    // Additional utility methods
    public List<Product> searchProductsByName(String name) {
        List<Product> results = new ArrayList<>();
        String searchTerm = name.toLowerCase();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(searchTerm)) {
                results.add(product);
            }
        }
        return results;
    }

    public void clearInventory() {
        products.clear();
        System.out.println("Inventory cleared successfully");
    }

    public int getProductCount() {
        return products.size();
    }
}

