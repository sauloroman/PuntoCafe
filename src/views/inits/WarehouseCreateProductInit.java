package views.inits;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.warehouse.WarehouseCreateProduct;

public class WarehouseCreateProductInit {
    
    private final WarehouseCreateProduct view;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public WarehouseCreateProductInit(WarehouseCreateProduct view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnSaveProduct, "#000000", "#ffffff");
        buttonGenerator.addIcon(view.btnSaveProduct, "icon-plus-white", 20);
        buttonGenerator.outlineButton(view.btnCancelSaveProduct, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveProduct, "icon-left-red", 20);
        buttonGenerator.outlineButton(view.btnLoadImage, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnLoadImage, "icon-up", 20);
        buttonGenerator.outlineButton(view.btnRemoveImage, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRemoveImage, "icon-down", 20);
        
        inputGenerator.roundedField(view.productNameTxt, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.productStockTxt, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.productStockMinTxt, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.productCategoryCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.productSupplierCombo, INPUT_COLOR, 10);
        inputGenerator.roundedArea(view.productDescriptionTxt, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.productPriceTxt, INPUT_COLOR, 10);
        
        imageGenerator.addImage(view.iconCreateProduct, "icon-create-product", 20);
        imageGenerator.addImageProduct(view.productImageLabel, "no-image.jpg", 200, 200);
        
        imageGenerator.addImage(view.iconMandatory, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory2, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory3, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory4, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory5, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory6, "icon-lock", 14);
    }
    
}
