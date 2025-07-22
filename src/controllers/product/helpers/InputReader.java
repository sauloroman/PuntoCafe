package controllers.product.helpers;

import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;
import views.warehouse.WarehouseProducts;

public class InputReader {
    
    private final WarehouseProducts view;
    private final WarehouseCreateProduct createView;
    private final WarehouseEditProduct editView;

    public InputReader(WarehouseProducts view, WarehouseCreateProduct createView, WarehouseEditProduct editView) {
        this.view = view;
        this.createView = createView;
        this.editView = editView;
    }
    
    public String getProductNameSearched() {
        String productNameSearched = view.productSearchByNameTxt.getText().trim();
        if ( productNameSearched.isEmpty() ) return null;
        return productNameSearched;
    }
    
    public String getCategorySelected() {
        String categorySelected = view.productCategoryCombo.getSelectedItem().toString();
        if ( categorySelected.equals("Categorías") ) return null;
        return categorySelected;
    }
    
    public String getSupplierCompanyName() {
        String supplierSelected = view.productSupplierCombo.getSelectedItem().toString();
        if ( supplierSelected.equals("Proveedores") ) return null;
        return supplierSelected;
    }
    
    public String getStatusSelected() {
        String statusSelected = view.productStatusCombo.getSelectedItem().toString().trim();
        if ( statusSelected.equals("Estado") ) return null; 
        return statusSelected;
    }
    
    public String getNameCreate() {
        String name = createView.productNameTxt.getText().trim();
        if ( name == null || name.equals("Ingrese el nombre del producto")) return null;
        return name;
    }
    
    public String getCategorySelectedCreate() {
        String category = createView.productCategoryCombo.getSelectedItem().toString().trim();
        if ( category == null || category.equals("Seleccione una categoría")) return null;
        return category;
    }
    
    public String getSupplierSelectedCreate() {
        String supplier = createView.productSupplierCombo.getSelectedItem().toString().trim();
        if ( supplier == null || supplier.equals("Seleccione un proveedor")) return null;
        return supplier;
    }
    
    public String getPriceCreate() {
        String price = createView.productPriceTxt.getText().trim();
        return price;
    }
    
    public String getStockCreate() {
        String stock = createView.productStockTxt.getText().trim();
        return stock;
    }
    
    public String getStockMinCreate() {
        String stockMin = createView.productStockMinTxt.getText().trim();
        return stockMin;
    }
    
    public String getDescriptionCreate() {
        String description = createView.productDescriptionTxt.getText().trim();
        return description;
    }
    
    public String getNameEdition() {
        String name = editView.productEditNameTxt.getText().trim();
        if ( name == null || name.equals("Ingrese el nombre del producto")) return null;
        return name;
    }
    
    public String getCategorySelectedEdition() {
        String category = editView.productEditCategoryCombo.getSelectedItem().toString().trim();
        if ( category == null || category.equals("Seleccione una categoría")) return null;
        return category;
    }
    
    public String getSupplierSelectedEdition() {
        String supplier = editView.productEditSupplierCombo.getSelectedItem().toString().trim();
        if ( supplier == null || supplier.equals("Seleccione un proveedor")) return null;
        return supplier;
    }
    
    public String getPriceEdition() {
        String price = editView.productEditPriceTxt.getText().trim();
        return price;
    }
    
    public String getStockEdition() {
        String stock = editView.productEditStockTxt.getText().trim();
        return stock;
    }
    
    public String getStockMinEdition() {
        String stockMin = editView.productEditStockMinTxt.getText().trim();
        return stockMin;
    }
    
    public String getDescriptionEdition() {
        String description = editView.productEditDescriptionTxt.getText().trim();
        return description;
    }
    
}
