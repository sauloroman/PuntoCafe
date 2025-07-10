package controllers.product.helpers;

import views.components.ImageCustom;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;

public class ResetElements {
    
    private final ImageCustom imageGenerator = new ImageCustom();
    private final WarehouseCreateProduct view;
    private final WarehouseEditProduct viewEdit;

    public ResetElements(WarehouseCreateProduct view, WarehouseEditProduct viewEdit) {
        this.view = view;
        this.viewEdit = viewEdit;
    }

    public void hideButtonUploadImage() {
        view.btnLoadImage.setVisible(false);
        viewEdit.btnLoadImage.setVisible(false);
        view.btnRemoveImage.setVisible(true);
        viewEdit.btnRemoveImage.setVisible(true);
    }
    
    public void showButtonUploadImage() {
        view.btnLoadImage.setVisible(true);
        viewEdit.btnLoadImage.setVisible(true);
        view.btnRemoveImage.setVisible(false);
        viewEdit.btnRemoveImage.setVisible(false);
    }
    
    public void resetCreateForm() {
        view.productNameTxt.setText("");
        view.productDescriptionTxt.setText("");
        view.productCategoryCombo.setSelectedIndex(0);
        view.productSupplierCombo.setSelectedIndex(0);
        view.productPriceTxt.setText("");
        view.productStockTxt.setText("");
        view.productStockMinTxt.setText("");
        imageGenerator.addImageProduct(view.productImageLabel, "no-image.jpg", 200, 200);        
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
        imageGenerator.addImageFix(view.productImageLabel, "no-image.jpg", 200, 200);        
        hideButtonUploadImage();
    }
    
}
