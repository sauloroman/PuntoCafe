package views.inits;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.warehouse.WarehouseInfoProduct;

public class WarehouseInfoProductInit {
    
    private final WarehouseInfoProduct view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public WarehouseInfoProductInit(WarehouseInfoProduct view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        imageGenerator.addImage(view.iconInfoProduct, "icon-info", 24);
        imageGenerator.addImage(view.iconStock, "icon-stock", 20);
        imageGenerator.addImage(view.iconStock1, "icon-stock", 20);
        inputGenerator.areaInfo(view.productDescription);
        
        buttonGenerator.solidButton(view.btnEditProduct, "#000000", "#ffffff");
        buttonGenerator.addIcon(view.btnEditProduct, "icon-edit", 20);
        buttonGenerator.outlineButton(view.btnActivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.outlineButton(view.btnDeactivate, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
    }
}
