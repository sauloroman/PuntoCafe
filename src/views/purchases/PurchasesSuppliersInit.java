package views.purchases;

import entities.User;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Input;
import views.components.Table;

public class PurchasesSuppliersInit {
    
    private final User user;
    private final PurchasesSuppliers view;
    private final String INPUT_COLOR = "#DDDDDD";
    private final String NEW_BTN_COLOR = "#121615";
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 1000;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();

    public PurchasesSuppliersInit(PurchasesSuppliers view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        Table.tableStyle3(view.suppliersTable);

        inputGenerator.roundedField(view.searchSuppliersTxt, INPUT_COLOR, 10, "Buscar proveedores por nombre");
        inputGenerator.roundedComboBox(view.suppliersCompanyCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.suppliersStatusCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.pageComboBox, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.itemsPerPageComboBox, INPUT_COLOR, 10);
        
        buttonGenerator.solidButton(view.btnNewSupplier, ViewConstants.skyColor, "#ffffff", 12);
        buttonGenerator.addIcon(view.btnNewSupplier, "icon-plus-white", 20);
        buttonGenerator.outlineButton(view.btnSeeSupplier, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnSeeSupplier, "icon-eye", 20);
        buttonGenerator.outlineButton(view.btnExportSuppliers, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnExportSuppliers, "icon-print", 20);
        buttonGenerator.solidButton(view.btnSearch, NEW_BTN_COLOR, "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnRestore, "#DDDDDD", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnRestore, "icon-reload", 16);
    
        hideElementsByRole();
    }
    
    private void hideElementsByRole() {
        if ( user.getRoleId() == 2 ) {
            view.btnNewSupplier.setVisible(false);
            view.btnNewSupplier.setSize(0, 0);
        }
    }
    
}
