@echo off
echo Compiling Inventory Management System...
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Starting Inventory Management System...
    echo.
    java -cp bin com.inventory.InventoryManagementSystem
) else (
    echo Compilation failed! Please check for errors.
    pause
)

