package com.inventory.interfaces;

import com.inventory.model.Product;
import java.util.List;
import java.util.Map;

/**
 * Interface for reporting functionality.
 * Demonstrates Interface Segregation Principle.
 */
public interface IReportable {
    double getTotalInventoryValue();
    int getTotalProducts();
    Map<String, Integer> getProductsByCategory();
    List<Product> getLowStockProducts(int threshold);
    List<Product> getProductsByCategory(String categoryId);
}

