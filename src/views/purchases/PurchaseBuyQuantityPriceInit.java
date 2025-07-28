package views.purchases;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;

public class PurchaseBuyQuantityPriceInit {
    
    private final PurchaseBuyQuantityPrice view;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();

    public PurchaseBuyQuantityPriceInit(PurchaseBuyQuantityPrice view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnAddToList, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnAddToList, "icon-plus-white", 16);
        
        inputGenerator.roundedField(view.quantityTxt, "#DDDDDD", 10, "");
        inputGenerator.roundedField(view.priceTxt, "#DDDDDD", 10, "");
    }
    
}
