package views.warehouse;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class WarehouseEditProductInit {
    
    private final WarehouseEditProduct view;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public WarehouseEditProductInit(WarehouseEditProduct view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnUpdateProduct, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnUpdateProduct, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnCancelEditProduct, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelEditProduct, "icon-left-red", 20);
        buttonGenerator.outlineButton(view.btnLoadImage, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnLoadImage, "icon-up", 20);
        buttonGenerator.outlineButton(view.btnRemoveImage, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRemoveImage, "icon-down", 20);
        
        inputGenerator.roundedField(view.productEditNameTxt, INPUT_COLOR, 10, "Ingrese el nombre del producto");
        inputGenerator.roundedField(view.productEditStockTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.productEditStockMinTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedComboBox(view.productEditCategoryCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.productEditSupplierCombo, INPUT_COLOR, 10);
        inputGenerator.roundedArea(view.productEditDescriptionTxt, INPUT_COLOR, 10);
        
        imageGenerator.addImageProduct(view.productEditImageLabel, "no-image.jpg", 200, 200);        
        imageGenerator.addImage(view.iconMandatory, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory2, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory3, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory4, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory5, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory6, "icon-lock", 14);
    }
    
}
