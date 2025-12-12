package com.inventory;

import com.inventory.manager.*;
import com.inventory.model.Category;
import com.inventory.model.Product;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class for Inventory Management System.
 * Demonstrates:
 * - Main entry point
 * - User interaction
 * - Integration of all components
 */
public class InventoryManagementSystem {
    private static InventoryManager inventoryManager;
    private static ReportGenerator reportGenerator;
    private static CategoryManager categoryManager;
    private static Scanner scanner;

    public static void main(String[] args) {
        initializeSystem();
        displayWelcomeMessage();
        runApplication();
    }

    private static void initializeSystem() {
        inventoryManager = InventoryManager.getInstance();
        reportGenerator = new ReportGenerator(inventoryManager);
        categoryManager = new CategoryManager();
        scanner = new Scanner(System.in);
    }

    private static void displayWelcomeMessage() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║     INVENTORY MANAGEMENT SYSTEM - OOP PROJECT         ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
    }

    private static void runApplication() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getChoice();
            running = processChoice(choice);
        }
        scanner.close();
        System.out.println("\nThank you for using Inventory Management System!");
    }

    private static void displayMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. Update Product");
        System.out.println("4. View All Products");
        System.out.println("5. Search Product");
        System.out.println("6. View Categories");
        System.out.println("7. Generate Reports");
        System.out.println("8. Stock Management");
        System.out.println("9. Exit");
        System.out.println("===============================");
        System.out.print("Enter your choice: ");
    }

    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                removeProduct();
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                viewAllProducts();
                break;
            case 5:
                searchProduct();
                break;
            case 6:
                viewCategories();
                break;
            case 7:
                generateReports();
                break;
            case 8:
                stockManagement();
                break;
            case 9:
                return false;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
        return true;
    }

    private static void addProduct() {
        System.out.println("\n========== ADD PRODUCT ==========");
        try {
            System.out.print("Enter Product ID: ");
            String productId = scanner.nextLine().trim();
            
            if (inventoryManager.productExists(productId)) {
                System.out.println("Product with this ID already exists!");
                return;
            }

            System.out.print("Enter Product Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Description: ");
            String description = scanner.nextLine().trim();

            System.out.print("Enter Price: $");
            double price = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter Quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());

            categoryManager.printAllCategories();
            System.out.print("Enter Category ID: ");
            String categoryId = scanner.nextLine().trim();
            Category category = categoryManager.getCategory(categoryId);
            
            if (category == null) {
                System.out.println("Invalid category ID!");
                return;
            }

            System.out.print("Enter Supplier: ");
            String supplier = scanner.nextLine().trim();

            Product product = new Product(productId, name, description, price, quantity, category, supplier);
            inventoryManager.addProduct(product);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void removeProduct() {
        System.out.println("\n========== REMOVE PRODUCT ==========");
        System.out.print("Enter Product ID to remove: ");
        String productId = scanner.nextLine().trim();
        inventoryManager.removeProduct(productId);
    }

    private static void updateProduct() {
        System.out.println("\n========== UPDATE PRODUCT ==========");
        System.out.print("Enter Product ID to update: ");
        String productId = scanner.nextLine().trim();
        
        Product product = inventoryManager.getProduct(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        try {
            System.out.println("Current Product Details:");
            System.out.println(product);
            System.out.println("\nEnter new details (press Enter to keep current value):");

            System.out.print("Enter Product Name [" + product.getName() + "]: ");
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                product.setName(name);
            }

            System.out.print("Enter Description [" + product.getDescription() + "]: ");
            String description = scanner.nextLine().trim();
            if (!description.isEmpty()) {
                product.setDescription(description);
            }

            System.out.print("Enter Price [$" + product.getPrice() + "]: ");
            String priceStr = scanner.nextLine().trim();
            if (!priceStr.isEmpty()) {
                product.setPrice(Double.parseDouble(priceStr));
            }

            System.out.print("Enter Quantity [" + product.getQuantity() + "]: ");
            String quantityStr = scanner.nextLine().trim();
            if (!quantityStr.isEmpty()) {
                product.setQuantity(Integer.parseInt(quantityStr));
            }

            System.out.print("Enter Supplier [" + product.getSupplier() + "]: ");
            String supplier = scanner.nextLine().trim();
            if (!supplier.isEmpty()) {
                product.setSupplier(supplier);
            }

            inventoryManager.updateProduct(product);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewAllProducts() {
        reportGenerator.printDetailedInventory();
    }

    private static void searchProduct() {
        System.out.println("\n========== SEARCH PRODUCT ==========");
        System.out.print("Enter product name to search: ");
        String searchTerm = scanner.nextLine().trim();
        List<Product> results = inventoryManager.searchProductsByName(searchTerm);
        
        if (results.isEmpty()) {
            System.out.println("No products found matching: " + searchTerm);
        } else {
            System.out.println("\nSearch Results:");
            for (Product product : results) {
                System.out.println(product);
            }
        }
    }

    private static void viewCategories() {
        categoryManager.printAllCategories();
    }

    private static void generateReports() {
        boolean reporting = true;
        while (reporting) {
            System.out.println("\n========== REPORTS MENU ==========");
            System.out.println("1. Inventory Summary Report");
            System.out.println("2. Low Stock Report");
            System.out.println("3. Products by Category");
            System.out.println("4. Back to Main Menu");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");
            
            int choice = getChoice();
            switch (choice) {
                case 1:
                    reportGenerator.printInventoryReport();
                    break;
                case 2:
                    System.out.print("Enter low stock threshold: ");
                    try {
                        int threshold = Integer.parseInt(scanner.nextLine().trim());
                        reportGenerator.printLowStockReport(threshold);
                    } catch (Exception e) {
                        System.out.println("Invalid threshold!");
                    }
                    break;
                case 3:
                    System.out.println("\nProducts by Category:");
                    reportGenerator.getProductsByCategory().forEach((category, count) ->
                        System.out.println("  " + category + ": " + count + " products"));
                    break;
                case 4:
                    reporting = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void stockManagement() {
        System.out.println("\n========== STOCK MANAGEMENT ==========");
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine().trim();
        
        Product product = inventoryManager.getProduct(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        System.out.println("Current Stock: " + product.getQuantity());
        System.out.println("1. Add Stock");
        System.out.println("2. Remove Stock");
        System.out.print("Enter your choice: ");
        
        int choice = getChoice();
        try {
            if (choice == 1) {
                System.out.print("Enter quantity to add: ");
                int amount = Integer.parseInt(scanner.nextLine().trim());
                product.addStock(amount);
                System.out.println("Stock added successfully. New quantity: " + product.getQuantity());
            } else if (choice == 2) {
                System.out.print("Enter quantity to remove: ");
                int amount = Integer.parseInt(scanner.nextLine().trim());
                product.removeStock(amount);
                System.out.println("Stock removed successfully. New quantity: " + product.getQuantity());
            } else {
                System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

