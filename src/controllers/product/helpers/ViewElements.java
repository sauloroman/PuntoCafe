package controllers.product.helpers;

import views.components.ImageCustom;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;
import views.warehouse.WarehouseProducts;

public class ViewElements {
    
    private final ImageCustom imageGenerator = new ImageCustom();
    private final WarehouseProducts view;
    private final WarehouseCreateProduct viewCreate;
    private final WarehouseEditProduct viewEdit;

    public ViewElements(  WarehouseProducts view, WarehouseCreateProduct viewCreate, WarehouseEditProduct viewEdit) {
        this.view = view;
        this.viewCreate = viewCreate;
        this.viewEdit = viewEdit;
    }

    public void hideButtonUploadImage() {
        viewCreate.btnLoadImage.setVisible(false);
        viewEdit.btnLoadImage.setVisible(false);
        viewCreate.btnRemoveImage.setVisible(true);
        viewEdit.btnRemoveImage.setVisible(true);
    }
    
    public void showButtonUploadImage() {
        viewCreate.btnLoadImage.setVisible(true);
        viewEdit.btnLoadImage.setVisible(true);
        viewCreate.btnRemoveImage.setVisible(false);
        viewEdit.btnRemoveImage.setVisible(false);
    }
    
    public void resetCreateForm() {
        viewCreate.productNameTxt.setText("");
        viewCreate.productDescriptionTxt.setText("");
        viewCreate.productCategoryCombo.setSelectedIndex(0);
        viewCreate.productSupplierCombo.setSelectedIndex(0);
        viewCreate.productPriceTxt.setText("");
        viewCreate.productStockTxt.setText("");
        viewCreate.productStockMinTxt.setText("");
        imageGenerator.addImageProduct(viewCreate.productImageLabel, "no-image.jpg", 200, 200);        
        hideButtonUploadImage();
    }
    
    public void resetEditForm() {
        viewEdit.productEditNameTxt.setText("");
        viewEdit.productEditDescriptionTxt.setText("");
        viewEdit.productEditCategoryCombo.setSelectedIndex(0);
        viewEdit.productEditSupplierCombo.setSelectedIndex(0);
        viewEdit.productEditPriceTxt.setText("");
        viewEdit.productEditStockTxt.setText("");
        viewEdit.productEditStockMinTxt.setText("");
        imageGenerator.addImageProduct(viewCreate.productImageLabel, "no-image.jpg", 200, 200);        
        hideButtonUploadImage();
    }
    
    public void clearSearchProduct() {
        view.productSearchByNameTxt.setText("");
    }
    
}
