package controllers.dish.helpers;

import views.components.ImageCustom;
import views.warehouse.WarehouseCreateDish;
import views.warehouse.WarehouseEditDish;

public class ResetElements {
    
    private final ImageCustom imageGenerator = new ImageCustom();
    private final WarehouseCreateDish createView;
    private final WarehouseEditDish editView;

    public ResetElements(WarehouseCreateDish createView, WarehouseEditDish editView) {
        this.createView = createView;
        this.editView = editView;
    }
    
    public void hideButtonUploadImage() {
        createView.btnLoadImage.setVisible(false);
        createView.btnRemoveImage.setVisible(true);
        editView.btnLoadImage.setVisible(false);
        editView.btnRemoveImage.setVisible(true);
    }
    
    public void showButtonUploadImage() {
        createView.btnLoadImage.setVisible(true);
        createView.btnRemoveImage.setVisible(false);
        editView.btnLoadImage.setVisible(true);
        editView.btnRemoveImage.setVisible(false);
    }
    
    public void resetCreateForm() {
        createView.dishNameTxt.setText("");
        createView.dishDescriptionTxt.setText("");
        createView.dishPriceTxt.setText("");
        createView.dishCategoryCombo.setSelectedIndex(0);
        imageGenerator.addImageDish(createView.dishImageLabel, "no-image.jpg", 200, 200);
        hideButtonUploadImage();
    }
    
    public void resetEditForm() {
        editView.dishEditNameTxt.setText("");
        editView.dishEditDescriptionTxt.setText("");
        editView.dishEditPriceTxt.setText("");
        editView.dishEditCategoryCombo.setSelectedIndex(0);
        imageGenerator.addImageDish(editView.dishEditImageLabel, "no-image.jpg", 200, 200);
        hideButtonUploadImage();
    }
    
}


