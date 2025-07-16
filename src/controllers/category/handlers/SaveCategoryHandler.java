package controllers.category.handlers;

import services.CategoryService;
import interfaces.HandlerController;
import entities.Category;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import controllers.category.helpers.CategoryValidator;
import views.components.Label;
import views.warehouse.WarehouseCategories;

public class SaveCategoryHandler implements HandlerController {

    private final WarehouseCategories view;
    private final CategoryService categoryService;
    private final Modal modal;
    
    public SaveCategoryHandler( 
            WarehouseCategories view, 
            CategoryService categoryService, 
            Modal modal
    ) {
        this.view = view;
        this.categoryService = categoryService;
        this.modal = modal;
    }
    
    @Override
    public void execute() {
        String name = view.categoryNameTxt.getText();
        String desc = view.categoryDescriptionTxt.getText();
        String type = view.categoryTypeCombo.getSelectedItem().toString();
        
        if (!isValid(name, desc)) return;
    
        if (categoryService.getByName(name) != null) {
            modal.show("La categoría ya existe", ModalTypeEnum.error);
            return;
        } 
        
        Category category = new Category( name, desc, type );
        
        if ( categoryService.saveCategory(category) == false ) {
            modal.show("La categoría no pudo ser guardada", ModalTypeEnum.error);
            return;
        }
        
        modal.show("La categoría " + name + " ha sido guardada", ModalTypeEnum.success);
        resetForm();
    }
    
    private boolean isValid(String name, String desc) {
        if (!CategoryValidator.isValidName(name)) {
            modal.show("Nombre invalido. Debe ser menor a 100 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionField(view.categoryNameTxt, view.categoryRestrictionName);
            return false;
        }
        
        if (!CategoryValidator.isValidDescription(desc)) {
            modal.show("Descripción invalida. Debe ser menor a 220 caracteres", ModalTypeEnum.error);
            Label.styleWrongRestrictionArea(view.categoryDescriptionTxt, view.categoryRestrictionDescription);
            return false;
        }
        
        return true;
    }
    
    private void resetForm() {
        view.categoryNameTxt.setText("");
        view.categoryDescriptionTxt.setText("");
        Label.styleRestriction(view.categoryRestrictionName);
        Label.styleRestriction(view.categoryRestrictionDescription);    }
    
}
