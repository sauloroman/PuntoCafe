package views.warehouse;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class WarehouseEditDishInit {
    
    private final WarehouseEditDish view;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public WarehouseEditDishInit(WarehouseEditDish view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnUpdateDish, ViewConstants.skyColor, "#ffffff", 11);
        buttonGenerator.addIcon(view.btnUpdateDish, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnCancelEditDish, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelEditDish, "icon-left-red", 20);
        buttonGenerator.outlineButton(view.btnLoadImage, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnLoadImage, "icon-up", 20);
        buttonGenerator.outlineButton(view.btnRemoveImage, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRemoveImage, "icon-down", 20);
        
        inputGenerator.roundedField(view.dishEditNameTxt, INPUT_COLOR, 10, "Ingresa el nombre del platillo");
        inputGenerator.roundedComboBox(view.dishEditCategoryCombo, INPUT_COLOR, 10);
        inputGenerator.roundedArea(view.dishEditDescriptionTxt, INPUT_COLOR, 10);
        
        imageGenerator.addImageFix(view.iconRH, "logo-rh", 50, 50);
        imageGenerator.addImageProduct(view.dishEditImageLabel, "no-image.jpg", 200, 200);       
        imageGenerator.addImage(view.iconMandatory, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory2, "icon-lock", 14);
        imageGenerator.addImage(view.iconMandatory4, "icon-lock", 14);
    }
    
}
