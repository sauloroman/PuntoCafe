package views.inits;

import javax.swing.SwingUtilities;
import utils.constants.ViewConstants;
import utils.helpers.NavegationTabs;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.components.Label;
import views.components.TabPane;
import views.components.Table;
import views.warehouse.WarehouseCategories;

public class WarehouseCategoriesInit {
    
    private final WarehouseCategories view;
    private final String NEW_BTN_COLOR = "#121615";
    private final String INPUT_COLOR = "#DDDDDD";
    private final int PANEL_WIDTH = 1200;
    private final int PANEL_HEIGHT = 900;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public WarehouseCategoriesInit(WarehouseCategories view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        TabPane.styleGeneralTab(view.categoriesNavegationPane);
        Table.tableStyle3(view.categoriesTable);
        
        NavegationTabs.activateTabPane(view.categoriesNavegationPane, 3, 0);
        
        inputGenerator.roundedField(view.searchTxt, INPUT_COLOR, 8);
        inputGenerator.roundedField(view.categoryNameTxt, INPUT_COLOR, 8);
        inputGenerator.roundedArea(view.categoryDescriptionTxt, INPUT_COLOR, 8);
        inputGenerator.roundedComboBox(view.categoryTypeCombo, INPUT_COLOR, 10);
        inputGenerator.roundedField(view.editCategoryNameTxt, INPUT_COLOR, 8);
        inputGenerator.roundedArea(view.editCategoryDescriptionTxt, INPUT_COLOR, 8);
        inputGenerator.roundedComboBox(view.pageComboBox, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.itemsPerPageComboBox, INPUT_COLOR, 10);
        inputGenerator.roundedComboBox(view.editCategoryTypeCombo, INPUT_COLOR, 10);
        
        buttonGenerator.outlineButton(view.btnEdit, INPUT_COLOR, ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnEdit, "icon-pencil", 20);
        buttonGenerator.solidButton(view.btnActivate, "#fff3bf", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnActivate, "icon-check", 20);
        buttonGenerator.solidButton(view.btnDeactivate, "#ffe3e3", ViewConstants.textBtn);
        buttonGenerator.addIcon(view.btnDeactivate, "icon-trash", 20);
        buttonGenerator.solidButton(view.btnNew, NEW_BTN_COLOR, "#FFFFFF");
        buttonGenerator.addIcon(view.btnNew, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnSearch, NEW_BTN_COLOR, "#FFFFFF");
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 20);
        buttonGenerator.outlineButton(view.btnCancelSaveCategory, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveCategory, "icon-left-red", 20);
        buttonGenerator.solidButton(view.btnSaveCategory, NEW_BTN_COLOR, "#FFFFFF");
        buttonGenerator.addIcon(view.btnSaveCategory, "icon-save", 20);
        buttonGenerator.solidButton(view.btnEditCategory, NEW_BTN_COLOR, "#FFFFFF");
        buttonGenerator.addIcon(view.btnEditCategory, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnCancelEditCategory, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelEditCategory, "icon-left-red", 20);
        
        imageGenerator.addImageFix(view.logoCreateCategory, "logo-rh", 50, 50);
        imageGenerator.addImageFix(view.logoCreateCategory1, "logo-rh", 50, 50);
        imageGenerator.addImage(view.iconInputMandatory, "icon-lock", 16);
        imageGenerator.addImage(view.iconInputMandatory1, "icon-lock", 16);
        imageGenerator.addImage(view.iconInputMandatory2, "icon-lock", 16);
        imageGenerator.addImage(view.iconInputMandatory3, "icon-lock", 16);
        imageGenerator.addImage(view.iconInfo, "icon-info", 16);
        imageGenerator.addImage(view.iconPanel, "icon-folder", 30);
        imageGenerator.addImage(view.iconPanel2, "icon-check-3d", 30);
        imageGenerator.addImage(view.iconPanel3, "icon-wrong-3d", 30);
        
        Label.styleRestriction(view.categoryRestrictionName);
        Label.styleRestriction(view.categoryRestrictionDescription );
        
        SwingUtilities.updateComponentTreeUI(view); 
    }
    
}
