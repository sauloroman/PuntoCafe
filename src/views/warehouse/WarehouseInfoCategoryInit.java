package views.warehouse;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;

public class WarehouseInfoCategoryInit {
    
    private final Button buttonGenerator = new Button();
    private final Input input = new Input();
    private final WarehouseInfoCategory view;

    public WarehouseInfoCategoryInit(WarehouseInfoCategory view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        input.areaInfo(view.categoryInfoDesc); 
        view.scrollDescription.setBorder(BorderFactory.createLineBorder(Color.decode("#DDDDDD")));
        
        buttonGenerator.solidButton(view.btnEdit, ViewConstants.blackColor, ViewConstants.whiteColor, 11);
        buttonGenerator.addIcon(view.btnEdit, "icon-edit", 20);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
        
    }
    
}
