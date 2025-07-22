package views.sales;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class CreateSaleProductQuantityInit {
    
    private final CreateSaleProductQuantity view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();


    public CreateSaleProductQuantityInit(CreateSaleProductQuantity view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        buttonGenerator.solidButton(view.btnAddToList, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnAddToList, "icon-plus-white", 20);
        imageGenerator.addImageFix(view.iconRH, "logo-rh", 50, 50);
        inputGenerator.roundedField(view.disscountQuantityTxt, "#DDDDDD", 10, "");
    }
    
}
