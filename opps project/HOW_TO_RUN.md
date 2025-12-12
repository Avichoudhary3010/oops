# 🚀 How to Run Inventory Management System on Your Laptop

## Prerequisites Check

First, make sure you have Java installed on your laptop:

1. **Open Command Prompt or PowerShell:**
   - Press `Windows Key + R`
   - Type `cmd` and press Enter
   - OR type `powershell` and press Enter

2. **Check Java Installation:**
   ```bash
   java -version
   javac -version
   ```

   If you see version numbers (like `java version 1.8.0` or higher), you're good to go!
   
   **If Java is NOT installed:**
   - Download JDK from: https://www.oracle.com/java/technologies/downloads/
   - Install it and restart your computer
   - Then check again with `java -version`

---

## ✅ Method 1: Easiest Way (Double-Click)

1. **Navigate to your project folder:**
   - Open File Explorer
   - Go to: `C:\Users\Avi Choudhary\Desktop\saocjosakn`

2. **Double-click `run.bat`**
   - The application will automatically compile and run
   - A black window (Command Prompt) will open
   - Follow the menu prompts!

---

## ✅ Method 2: Using Command Prompt/PowerShell

### Step-by-Step:

1. **Open Command Prompt or PowerShell**
   - Press `Windows Key + R`
   - Type `cmd` and press Enter

2. **Navigate to your project folder:**
   ```bash
   cd "C:\Users\Avi Choudhary\Desktop\saocjosakn"
   ```

3. **Compile the project:**
   ```bash
   javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java
   ```

4. **Run the application:**
   ```bash
   java -cp bin com.inventory.InventoryManagementSystem
   ```

---

## ✅ Method 3: Using an IDE (IntelliJ IDEA / Eclipse / VS Code)

### IntelliJ IDEA:
1. Open IntelliJ IDEA
2. Click `File` → `Open`
3. Select your project folder: `C:\Users\Avi Choudhary\Desktop\saocjosakn`
4. Right-click on `InventoryManagementSystem.java`
5. Click `Run 'InventoryManagementSystem.main()'`

### Eclipse:
1. Open Eclipse
2. Click `File` → `Import` → `Existing Projects into Workspace`
3. Select your project folder
4. Right-click on `InventoryManagementSystem.java`
5. Click `Run As` → `Java Application`

### VS Code:
1. Open VS Code
2. Open folder: `C:\Users\Avi Choudhary\Desktop\saocjosakn`
3. Install Java Extension Pack if prompted
4. Open `src/com/inventory/InventoryManagementSystem.java`
5. Click the "Run" button above the `main` method

---

## 📋 What You'll See When Running

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

## 🧪 Quick Test Example

Try these steps to test the system:

1. **Enter `1`** - Add a new product
   - Product ID: `P001`
   - Name: `Laptop`
   - Description: `High-performance laptop`
   - Price: `999.99`
   - Quantity: `10`
   - Category ID: `CAT001` (you'll see categories when you enter `6`)
   - Supplier: `TechCorp`

2. **Enter `6`** - View all available categories

3. **Enter `4`** - View all products you've added

4. **Enter `7`** - Generate reports
   - Then enter `1` for inventory summary

5. **Enter `8`** - Stock Management
   - Enter Product ID: `P001`
   - Choose to add or remove stock

6. **Enter `9`** - Exit the application

---

## ❌ Troubleshooting

### Problem: "javac is not recognized"
**Solution:** Java is not installed or not in PATH
- Install JDK from Oracle website
- Make sure to add Java to system PATH during installation

### Problem: "cannot find symbol" errors
**Solution:** Make sure you're in the project root directory
- Check you're in: `C:\Users\Avi Choudhary\Desktop\saocjosakn`
- Verify all files exist in `src/com/inventory/` folder

### Problem: "No line found" error
**Solution:** This happens when running in non-interactive mode
- Make sure you're running in Command Prompt/PowerShell (not through automated scripts)
- The application needs interactive input

### Problem: Batch file doesn't work
**Solution:** 
- Right-click `run.bat` → Properties
- Make sure "Run as administrator" is not required
- Try running Command Prompt as administrator if needed

---

## 📁 Project Structure (for reference)

```
saocjosakn/
├── src/
│   └── com/
│       └── inventory/
│           ├── model/
│           ├── interfaces/
│           ├── manager/
│           └── InventoryManagementSystem.java
├── bin/                    (created after compilation)
├── run.bat                 (double-click to run)
├── README.md
└── HOW_TO_RUN.md          (this file)
```

---

## 💡 Tips

- **Keep the Command Prompt window open** while using the application
- **Type numbers** (1-9) to select menu options
- **Press Enter** after each input
- **Use `9`** to exit safely
- All data is stored in memory (lost when you close the application)

---

## 🎓 For Your Resume

This project demonstrates:
- ✅ Java OOP concepts (Encapsulation, Abstraction, Polymorphism)
- ✅ Design Patterns (Singleton, Manager Pattern)
- ✅ Interface implementation
- ✅ Console-based application development
- ✅ Software design principles (SOLID)

Good luck with your project! 🚀

