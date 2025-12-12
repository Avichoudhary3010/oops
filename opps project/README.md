# Inventory Management System

A comprehensive Inventory Management System built using Java Object-Oriented Programming (OOP) concepts. This project demonstrates various OOP principles and design patterns suitable for a college project and resume portfolio.

## 🎯 Project Overview

This system allows users to manage inventory items, track stock levels, generate reports, and perform various inventory operations through a console-based interface.

## 📚 OOP Concepts Demonstrated

### 1. **Encapsulation**
- All class fields are private with public getters and setters
- Data validation in setters (e.g., preventing negative prices/quantities)
- Examples: `Product`, `Category`, `InventoryManager` classes

### 2. **Abstraction**
- Interfaces (`IInventory`, `IReportable`) define contracts without implementation
- Hides complex implementation details from users
- Allows for flexible and extensible design

### 3. **Inheritance**
- Base classes can be extended for specialized functionality
- `Category` class demonstrates inheritance-ready structure

### 4. **Polymorphism**
- Interface implementations allow different classes to be used interchangeably
- Method overriding in toString(), equals(), hashCode()

### 5. **Design Patterns**
- **Singleton Pattern**: `InventoryManager` ensures single instance
- **Manager Pattern**: Separate manager classes for different responsibilities
- **Composition**: `ReportGenerator` uses `InventoryManager` through composition

### 6. **SOLID Principles**
- **Single Responsibility**: Each class has one clear purpose
- **Open/Closed**: Open for extension via interfaces
- **Interface Segregation**: Separate interfaces for different concerns
- **Dependency Inversion**: Depend on abstractions (interfaces)

## 📁 Project Structure

```
src/
├── com/
│   └── inventory/
│       ├── model/
│       │   ├── Product.java          # Product entity class
│       │   └── Category.java         # Category entity class
│       ├── interfaces/
│       │   ├── IInventory.java       # Inventory operations interface
│       │   └── IReportable.java      # Reporting interface
│       ├── manager/
│       │   ├── InventoryManager.java # Manages product operations
│       │   ├── ReportGenerator.java  # Generates various reports
│       │   └── CategoryManager.java  # Manages categories
│       └── InventoryManagementSystem.java  # Main application class
└── README.md
```

## 🚀 Features

1. **Product Management**
   - Add new products
   - Remove products
   - Update product details
   - Search products by name
   - View all products

2. **Category Management**
   - Pre-defined categories
   - View all categories
   - Category-based product filtering

3. **Stock Management**
   - Add stock to existing products
   - Remove stock from products
   - Low stock alerts

4. **Reporting System**
   - Inventory summary report
   - Low stock report
   - Products by category report
   - Total inventory value calculation

5. **Data Validation**
   - Input validation for prices and quantities
   - Duplicate product ID prevention
   - Error handling for invalid operations

## 🛠️ Technologies Used

- **Java** (JDK 8 or higher)
- **OOP Concepts**: Classes, Objects, Interfaces, Encapsulation, Abstraction
- **Design Patterns**: Singleton, Manager Pattern, Composition

## 📋 Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

## 🔧 How to Compile and Run

### Using Command Line:

1. **Compile the project:**
   ```bash
   javac -d bin src/com/inventory/**/*.java
   ```

2. **Run the application:**
   ```bash
   java -cp bin com.inventory.InventoryManagementSystem
   ```

### Using IDE:

1. Import the project into your IDE
2. Set `src` as the source folder
3. Run `InventoryManagementSystem.java`

## 💡 Usage Example

```
========== MAIN MENU ==========
1. Add Product
2. Remove Product
3. Update Product
4. View All Products
5. Search Product
6. View Categories
7. Generate Reports
8. Stock Management
9. Exit
===============================
Enter your choice: 1

========== ADD PRODUCT ==========
Enter Product ID: P001
Enter Product Name: Laptop
Enter Description: High-performance laptop
Enter Price: $999.99
Enter Quantity: 10
...
```

## 📊 Key Classes and Their Responsibilities

### `Product`
- Represents a single inventory item
- Encapsulates product data and business logic
- Methods: `addStock()`, `removeStock()`, `getTotalValue()`, `isLowStock()`

### `Category`
- Represents product categories
- Used for organizing products

### `InventoryManager`
- Implements `IInventory` interface
- Manages CRUD operations for products
- Uses Singleton pattern for single instance

### `ReportGenerator`
- Implements `IReportable` interface
- Generates various inventory reports
- Uses composition to access inventory data

### `CategoryManager`
- Manages product categories
- Initializes default categories

## 🎓 Learning Outcomes

This project demonstrates:
- Understanding of core OOP principles
- Ability to design and implement software systems
- Code organization and structure
- Interface design and implementation
- Design pattern application
- Error handling and validation
- User interface design (console-based)

## 📝 Future Enhancements

- Database integration (JDBC/MySQL)
- File-based persistence (JSON/CSV)
- GUI implementation (Java Swing/JavaFX)
- User authentication system
- Transaction history
- Export reports to files
- Multi-user support

## 👨‍💻 Author

Developed as a college project demonstrating Java OOP concepts.

## 📄 License

This project is created for educational purposes.

---

**Note**: This project is designed to showcase OOP concepts and can be used in your resume to demonstrate your Java programming skills and understanding of software design principles.

