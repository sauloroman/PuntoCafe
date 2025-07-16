package views.inits;

import java.awt.Color;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;
import views.warehouse.WarehouseDishes;

public class WarehouseDishesInit {
    
    private final WarehouseDishes view;
    private final int PANEL_WIDTH = 1230;
    private final int PANEL_HEIGHT = 800;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final Input inputGenerator = new Input();

    public WarehouseDishesInit(WarehouseDishes view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        view.dishesGrid.setBackground(Color.decode("#F4F6F6"));
        
        buttonGenerator.solidButton(view.btnNewDish, "#000000", "#FFFFFF");
        buttonGenerator.addIcon(view.btnNewDish, "icon-plus-white", 20);
        buttonGenerator.outlineButton(view.btnExportProducts, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnExportProducts, "icon-print", 20);
        buttonGenerator.solidButton(view.btnSearch, "#000000", "#FFFFFF");
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        
        inputGenerator.roundedComboBox(view.dishStatusCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.dishCategoryCombo, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.dishSearchByNameTxt, INPUT_COLOR, 10, "Busca platillos por nombre");
        inputGenerator.roundedComboBox(view.pageComboBox, INPUT_COLOR, 10);
    }
    
}
