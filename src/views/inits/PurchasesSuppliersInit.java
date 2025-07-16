package views.inits;

import utils.constants.ViewConstants;
import utils.helpers.NavegationTabs;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.components.TabPane;
import views.components.Table;
import views.purchases.PurchasesSuppliers;

public class PurchasesSuppliersInit {
    
    private final PurchasesSuppliers view;
    private final String INPUT_COLOR = "#DDDDDD";
    private final String NEW_BTN_COLOR = "#121615";
    private final int PANEL_WIDTH = 1200;
    private final int PANEL_HEIGHT = 900;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();
    private final ImageCustom imageGenerator = new ImageCustom();

    public PurchasesSuppliersInit(PurchasesSuppliers view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        Table.tableStyle3(view.suppliersTable);
        TabPane.styleGeneralTab(view.suppliersNavegationTab);
        
        NavegationTabs.activateTabPane(view.suppliersNavegationTab, 3, 0);
        
        inputGenerator.roundedField(view.searchSuppliersTxt, INPUT_COLOR, 10, "Buscar proveedores por nombre");
        inputGenerator.roundedComboBox(view.suppliersCompanyCombo, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.suppliersStatusCombo, INPUT_COLOR, 10);
        
        inputGenerator.roundedField(view.supplierNameTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierLastnameTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierEmailTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierAddressTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierNewCompanyTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierPhoneTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedComboBox(view.supplierCompanyTxt, INPUT_COLOR, 10);
        
        inputGenerator.roundedField(view.supplierEditNameTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierEditLastnameTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierEditPhoneTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierEditEmailTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierEditAddressTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedField(view.supplierEditNewCompanyTxt, INPUT_COLOR, 10, "");
        inputGenerator.roundedComboBox(view.supplierEditCompanyTxt, INPUT_COLOR, 10);
        
        inputGenerator.roundedComboBox(view.pageComboBox, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.itemsPerPageComboBox, INPUT_COLOR, 10);
        
        buttonGenerator.solidButton(view.btnNewSupplier, NEW_BTN_COLOR, "#ffffff");
        buttonGenerator.addIcon(view.btnNewSupplier, "icon-plus-white", 20);
        buttonGenerator.outlineButton(view.btnEditSupplier, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnEditSupplier, "icon-pencil", 20);
        buttonGenerator.outlineButton(view.btnPrintSuppliers, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnPrintSuppliers, "icon-print", 20);
        buttonGenerator.solidButton(view.btnSearchSuppliers, NEW_BTN_COLOR, "#FFFFFF");
        buttonGenerator.addIcon(view.btnSearchSuppliers, "icon-search", 20);
        buttonGenerator.solidButton(view.btnSaveSupplier, NEW_BTN_COLOR, "#ffffff");
        buttonGenerator.addIcon(view.btnSaveSupplier, "icon-save", 20);
        buttonGenerator.solidButton(view.btnActivateSupplier, "#fff3bf", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivateSupplier, "icon-check", 20);
        buttonGenerator.solidButton(view.btnDeactivateSupplier, "#ffe3e3", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivateSupplier, "icon-trash", 20);
        buttonGenerator.outlineButton(view.btnCancelSaveSupplier, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveSupplier, "icon-left-red", 24);
        buttonGenerator.outlineButton(view.btnCreateCompany,  INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnEditCreateCompany, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnCancelEditSupplier, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelEditSupplier, "icon-left-red", 24);
        buttonGenerator.solidButton(view.btnUpdateSupplier, NEW_BTN_COLOR, "#FFFFFF");
        buttonGenerator.addIcon(view.btnUpdateSupplier, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnEditCreateCompany, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnSeeAllSuppliers, INPUT_COLOR, ViewConstants.textBtn);
        
        imageGenerator.addImage(view.iconInputMandatory, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory2, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory3, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory4, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory5, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory6, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory7, "icon-lock", 15);
        imageGenerator.addImage(view.iconInputMandatory8, "icon-lock", 15);
        imageGenerator.addImage(view.iconCreateSupplier, "icon-folder", 20);
        imageGenerator.addImage(view.iconEditSupplier, "icon-edit", 20);
        imageGenerator.addImage(view.iconInfo, "icon-info", 16);
    }
    
}
