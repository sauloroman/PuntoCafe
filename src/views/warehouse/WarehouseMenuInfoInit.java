package views.warehouse;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class WarehouseMenuInfoInit {

    private final WarehouseMenuInfo view;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();
    private final ImageCustom imageGenerator = new ImageCustom();
    
    public WarehouseMenuInfoInit(WarehouseMenuInfo view) {
        this.view = view;
        
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnCreateMenu, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnCreateMenu, "icon-save", 16);
        buttonGenerator.outlineButton(view.btnCancelCreateMenu, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelCreateMenu, "icon-left-red", 16);
        
        imageGenerator.addImageFix(view.iconRh, "logo-rh", 50, 50);
        imageGenerator.addImageFix(view.iconInputMandatory, "icon-lock", 16, 16);
        imageGenerator.addImageFix(view.iconInputMandatory2, "icon-lock", 16, 16);
        imageGenerator.addImageFix(view.iconInputMandatory3, "icon-lock", 16, 16);
        
        inputGenerator.roundedField(view.menuNameTxt, "#DDDDDD", 10, "Ingresa un nombre");
        inputGenerator.roundedArea(view.menuDescriptionTxt, "#DDDDDD", 10);
    }
    
}
