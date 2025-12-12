# Quick Start Guide

## Compilation Instructions

### Windows (PowerShell):
```powershell
# Create bin directory if it doesn't exist
New-Item -ItemType Directory -Path bin -Force

# Compile all Java files
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java
```

### Windows (Command Prompt):
```cmd
mkdir bin
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java
```

### Linux/Mac:
```bash
mkdir -p bin
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java
```

## Running the Application

After compilation, run:
```bash
java -cp bin com.inventory.InventoryManagementSystem
```

## Sample Test Data

You can test the system with the following sample data:

1. **Add Product:**
   - Product ID: P001
   - Name: Laptop
   - Description: High-performance laptop
   - Price: 999.99
   - Quantity: 10
   - Category ID: CAT001 (Electronics)
   - Supplier: TechCorp

2. **Add Another Product:**
   - Product ID: P002
   - Name: T-Shirt
   - Description: Cotton t-shirt
   - Price: 19.99
   - Quantity: 50
   - Category ID: CAT002 (Clothing)
   - Supplier: FashionStore

3. **Generate Reports** to see inventory statistics

4. **Test Stock Management** by adding/removing stock

## Troubleshooting

- **"cannot find symbol" errors**: Make sure all files are in the correct directory structure
- **"class not found" errors**: Ensure you're running from the project root directory
- **Compilation errors**: Check that you have JDK 8 or higher installed (`javac -version`)

