package com.inventory.manager;

import com.inventory.interfaces.IReportable;
import com.inventory.model.Product;
import java.util.*;

/**
 * ReportGenerator class implementing IReportable interface.
 * Demonstrates:
 * - Interface Implementation
 * - Composition (uses InventoryManager)
 * - Separation of Concerns
 */
public class ReportGenerator implements IReportable {
    private InventoryManager inventoryManager;

    public ReportGenerator(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    @Override
    public double getTotalInventoryValue() {
        double totalValue = 0.0;
        for (Product product : inventoryManager.getAllProducts()) {
            totalValue += product.getTotalValue();
        }
        return totalValue;
    }

    @Override
    public int getTotalProducts() {
        return inventoryManager.getProductCount();
    }

    @Override
    public Map<String, Integer> getProductsByCategory() {
        Map<String, Integer> categoryCount = new HashMap<>();
        for (Product product : inventoryManager.getAllProducts()) {
            String categoryName = product.getCategory().getName();
            categoryCount.put(categoryName, categoryCount.getOrDefault(categoryName, 0) + 1);
        }
        return categoryCount;
    }

    @Override
    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStockProducts = new ArrayList<>();
        for (Product product : inventoryManager.getAllProducts()) {
            if (product.isLowStock(threshold)) {
                lowStockProducts.add(product);
            }
        }
        return lowStockProducts;
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        List<Product> categoryProducts = new ArrayList<>();
        for (Product product : inventoryManager.getAllProducts()) {
            if (product.getCategory().getCategoryId().equals(categoryId)) {
                categoryProducts.add(product);
            }
        }
        return categoryProducts;
    }

    // Additional reporting methods
    public void printInventoryReport() {
        System.out.println("\n========== INVENTORY REPORT ==========");
        System.out.println("Total Products: " + getTotalProducts());
        System.out.printf("Total Inventory Value: $%.2f%n", getTotalInventoryValue());
        System.out.println("\nProducts by Category:");
        Map<String, Integer> categoryCount = getProductsByCategory();
        for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue() + " products");
        }
        System.out.println("=======================================\n");
    }

    public void printLowStockReport(int threshold) {
        List<Product> lowStockProducts = getLowStockProducts(threshold);
        System.out.println("\n========== LOW STOCK REPORT ==========");
        System.out.println("Threshold: " + threshold);
        if (lowStockProducts.isEmpty()) {
            System.out.println("No products are low on stock.");
        } else {
            System.out.println("Low Stock Products:");
            for (Product product : lowStockProducts) {
                System.out.println("  " + product.getName() + " - Quantity: " + product.getQuantity());
            }
        }
        System.out.println("=======================================\n");
    }

    public void printDetailedInventory() {
        System.out.println("\n========== DETAILED INVENTORY ==========");
        List<Product> products = inventoryManager.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
        System.out.println("==========================================\n");
    }
}

