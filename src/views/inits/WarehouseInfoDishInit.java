package views.inits;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.warehouse.WarehouseInfoDish;

public class WarehouseInfoDishInit {
    
    private final WarehouseInfoDish view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();
    
    public WarehouseInfoDishInit(WarehouseInfoDish view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        imageGenerator.addImage(view.iconInfoDish, "icon-info", 24);
        inputGenerator.areaInfo(view.dishDescription);
        
        buttonGenerator.solidButton(view.btnEditDish, "#000000", "#ffffff");
        buttonGenerator.addIcon(view.btnEditDish, "icon-edit", 20);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
    }
    
}
