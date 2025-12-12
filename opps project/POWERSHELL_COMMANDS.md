# PowerShell Commands to Run Inventory Management System

## Quick Start (Copy & Paste These Commands)

### Step 1: Navigate to Project Directory
```powershell
cd "C:\Users\Avi Choudhary\Desktop\opps project"
```

### Step 2: Check Java Installation
```powershell
java -version
javac -version
```
*If these commands don't work, you need to install Java JDK first.*

### Step 3: Create bin Directory (if it doesn't exist)
```powershell
New-Item -ItemType Directory -Path bin -Force
```

### Step 4: Compile the Project
```powershell
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java
```

### Step 5: Run the Application
```powershell
java -cp bin com.inventory.InventoryManagementSystem
```

---

## Method 1: Run PowerShell Script (Easiest)

Simply run this command in PowerShell:
```powershell
cd "C:\Users\Avi Choudhary\Desktop\opps project"
.\run.ps1
```

*Note: If you get an execution policy error, run this first:*
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

---

## Method 2: Manual Step-by-Step Commands

Copy and paste these commands one by one:

```powershell
# Navigate to project folder
cd "C:\Users\Avi Choudhary\Desktop\opps project"

# Create bin directory
New-Item -ItemType Directory -Path bin -Force

# Compile all Java files
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java

# Run the application
java -cp bin com.inventory.InventoryManagementSystem
```

---

## Method 3: One-Line Compile & Run

```powershell
cd "C:\Users\Avi Choudhary\Desktop\opps project"; New-Item -ItemType Directory -Path bin -Force | Out-Null; javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java; if ($?) { java -cp bin com.inventory.InventoryManagementSystem }
```

---

## Troubleshooting

### Error: "javac is not recognized"
**Solution:** Java JDK is not installed or not in PATH
```powershell
# Check if Java is installed
java -version

# If not installed, download from:
# https://www.oracle.com/java/technologies/downloads/
```

### Error: "Execution Policy" when running .ps1 script
**Solution:** Allow script execution
```powershell
Set-ExecutionPolicy -ExecutionPolicy RemoteSigned -Scope CurrentUser
```

### Error: "cannot find symbol"
**Solution:** Make sure you're in the correct directory
```powershell
# Check current directory
Get-Location

# Should show: C:\Users\Avi Choudhary\Desktop\opps project
```

### Error: "No line found"
**Solution:** This is normal - the application needs interactive input. Make sure you're running in PowerShell (not through automated scripts).

---

## What You'll See

After running, you'll see a menu like this:
```
╔════════════════════════════════════════════════════════╗
║     INVENTORY MANAGEMENT SYSTEM - OOP PROJECT         ║
╚════════════════════════════════════════════════════════╝

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
Enter your choice:
```

---

## Quick Test

1. Type `1` and press Enter to add a product
2. Type `6` and press Enter to view categories
3. Type `4` and press Enter to view all products
4. Type `9` and press Enter to exit

---

## Notes

- Keep PowerShell window open while using the application
- Type numbers (1-9) to select menu options
- Press Enter after each input
- All data is stored in memory (lost when you close the application)

