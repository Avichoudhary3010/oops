# PowerShell script to compile and run Inventory Management System

Write-Host "Compiling Inventory Management System..." -ForegroundColor Cyan

# Create bin directory if it doesn't exist
if (-not (Test-Path "bin")) {
    New-Item -ItemType Directory -Path "bin" | Out-Null
    Write-Host "Created bin directory" -ForegroundColor Green
}

# Compile all Java files
javac -d bin -sourcepath src src/com/inventory/InventoryManagementSystem.java src/com/inventory/model/*.java src/com/inventory/interfaces/*.java src/com/inventory/manager/*.java

if ($LASTEXITCODE -eq 0) {
    Write-Host "Compilation successful!" -ForegroundColor Green
    Write-Host ""
    Write-Host "Starting Inventory Management System..." -ForegroundColor Cyan
    Write-Host ""
    java -cp bin com.inventory.InventoryManagementSystem
} else {
    Write-Host "Compilation failed! Please check for errors." -ForegroundColor Red
    Read-Host "Press Enter to exit"
}

