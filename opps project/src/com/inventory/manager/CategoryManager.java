package com.inventory.manager;

import com.inventory.model.Category;
import java.util.*;

/**
 * CategoryManager class for managing product categories.
 * Demonstrates Encapsulation and Manager pattern.
 */
public class CategoryManager {
    private Map<String, Category> categories;

    public CategoryManager() {
        this.categories = new HashMap<>();
        initializeDefaultCategories();
    }

    private void initializeDefaultCategories() {
        addCategory(new Category("CAT001", "Electronics", "Electronic devices and components"));
        addCategory(new Category("CAT002", "Clothing", "Apparel and fashion items"));
        addCategory(new Category("CAT003", "Food & Beverages", "Food and drink products"));
        addCategory(new Category("CAT004", "Books", "Books and publications"));
        addCategory(new Category("CAT005", "Sports", "Sports and fitness equipment"));
    }

    public void addCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        categories.put(category.getCategoryId(), category);
    }

    public Category getCategory(String categoryId) {
        return categories.get(categoryId);
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public void removeCategory(String categoryId) {
        categories.remove(categoryId);
    }

    public void printAllCategories() {
        System.out.println("\n========== AVAILABLE CATEGORIES ==========");
        for (Category category : categories.values()) {
            System.out.println(category);
        }
        System.out.println("==========================================\n");
    }
}

