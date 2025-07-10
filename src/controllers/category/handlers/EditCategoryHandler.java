package controllers.category.handlers;

import controllers.interfaces.HandlerController;
import entities.Category;
import services.CategoryService;
import utils.enums.ModalTypeEnum;
import views.warehouse.WarehouseCategories;
import utils.helpers.Modal;
import utils.helpers.NavegationTabs;
import utils.validators.CategoryValidator;
import views.components.Label;

public class EditCategoryHandler implements HandlerController {
    
    private final WarehouseCategories view;
    private final CategoryService service;
    private final Modal modal;
    
    public EditCategoryHandler( 
            WarehouseCategories view, 
            CategoryService categoryService, 
            Modal modal    
    ) {
        this.view = view;
        this.service = categoryService;
        this.modal = modal;
    }

    @Override
    public void execute() {
        
        String newName = view.editCategoryNameTxt.getText();
        String newDesc = view.editCategoryDescriptionTxt.getText();
        String newType = view.editCategoryTypeCombo.getSelectedItem().toString();

        if (!isValid(newName, newDesc)) return;
        
        int id = Integer.parseInt(view.categoryIdSelected.getText());
        String currentName = view.categoryNameSelected.getText();
        
        if( !newName.equals(currentName) && service.getByName(newName) != null ) {
            modal.show("La categoría " + newName + " ya existe. Intenta con otro", ModalTypeEnum.error);
            return;
        }
        
        Category category = new Category(newName, newDesc, newType);
        
        if ( !service.updateCategory(category, id) ) {
            modal.show("No se pudo actualizar la categoría. Intente de nuevo más tarde", ModalTypeEnum.error);
            return;
        }
        
        modal.show("Categoría actulizada correctamente", ModalTypeEnum.success );
        resetForm();
    }
    
    private boolean isValid(String name, String desc) {
        if (!CategoryValidator.isValidName(name)) {
            modal.show("Nombre invalido. Debe ser menor a 100 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.editCategoryNameTxt, view.categoryRestrictionEditName);
            return false;
        }
        
        if (!CategoryValidator.isValidDescription(desc)) {
            modal.show("Descripción invalida. Debe ser menor a 220 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionArea(view.editCategoryDescriptionTxt, view.categoryRestrictionEditDescription);
            return false;
        }
        
        return true;
    }
 
    private void resetForm() {
        NavegationTabs.activateTabPane(view.categoriesNavegationPane, 3, 0);
        Label.styleRestriction(view.categoryRestrictionEditName);
        Label.styleRestriction(view.categoryRestrictionEditDescription);
    }
    
}
