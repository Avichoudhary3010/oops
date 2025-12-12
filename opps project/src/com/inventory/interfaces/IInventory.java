package com.inventory.interfaces;

import com.inventory.model.Product;
import java.util.List;

/**
 * Interface for inventory operations.
 * Demonstrates Abstraction - defines contract without implementation.
 */
public interface IInventory {
    void addProduct(Product product);
    void removeProduct(String productId);
    Product getProduct(String productId);
    List<Product> getAllProducts();
    void updateProduct(Product product);
    boolean productExists(String productId);
}

