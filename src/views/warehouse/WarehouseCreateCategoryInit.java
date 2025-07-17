package views.warehouse;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class WarehouseCreateCategoryInit {
    
    private final WarehouseCreateCategory view;
    private final Button buttonGenerator = new Button();
    private final Input input = new Input();
    private final ImageCustom image = new ImageCustom();

    public WarehouseCreateCategoryInit(WarehouseCreateCategory view) {
        this.view = view;
    }
    
    public void init() {
       
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnSaveCategory, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnSaveCategory, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnCancelSaveCategory, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveCategory, "icon-left-red", 20);
        
        input.roundedField(view.categoryNameTxt, "#DDDDDD", 10, "Ingresa un nombre de categoría");
        input.roundedComboBox(view.categoryTypeCombo, "#DDDDDD", 10);
        input.roundedArea(view.categoryDescTxt, "#DDDDDD", 10);
        
        image.addImage(view.iconInputMandatory, "icon-lock", 16);
        image.addImage(view.iconInputMandatory2, "icon-lock", 16);
        image.addImageFix(view.iconRH, "logo-rh", 40, 40);
        
    }
    
}
