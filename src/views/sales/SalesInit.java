package views.sales;

import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class SalesInit {
    
    private final Sales view;
    private final int WIDTH_PANEL = 1320;
    private final int HEIGHT_PANEL = 900;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public SalesInit(Sales view) {
        this.view = view;
    }
    
    public void init() {
        view.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        
        buttonGenerator.solidButton(view.btnNewSale, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNewSale, "icon-plus-white", 20);
    }
    
}
