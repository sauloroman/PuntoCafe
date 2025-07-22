package views.warehouse;

import java.awt.Color;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;

public class WarehouseProductsInit {
    
    private final WarehouseProducts view;
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 900;
    private final String INPUT_COLOR = "#DDDDDD";
    private final Button buttonGenerator = new Button(); 
    private final Input inputGenerator = new Input();

    public WarehouseProductsInit(WarehouseProducts view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        view.productsGrid.setBackground(Color.decode("#F4F6F6"));
        
        buttonGenerator.solidButton(view.btnNewProduct, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNewProduct, "icon-plus-white", 20);
        buttonGenerator.outlineButton(view.btnExportProducts, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnExportProducts, "icon-print", 20);
        buttonGenerator.solidButton(view.btnSearch, "#000000", "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnReload, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnReload, "icon-reload", 20);
        
        inputGenerator.roundedComboBox(view.productStatusCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.productCategoryCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.productSupplierCombo, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.productSearchByNameTxt, INPUT_COLOR, 10, "Busca productos por nombre");
        inputGenerator.roundedComboBox(view.pageComboBox, INPUT_COLOR, 10);
    }
    
}
