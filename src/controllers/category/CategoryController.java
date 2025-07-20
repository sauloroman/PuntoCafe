package controllers.category;

import entities.Category;
import models.CategoryModel;
import services.CategoryService;

import views.warehouse.WarehouseCategories;
import views.warehouse.WarehouseCreateCategory;
import views.warehouse.WarehouseEditCategory;
import views.warehouse.WarehouseInfoCategory;

import controllers.category.helpers.ChangeCategoryStatus;
import controllers.category.helpers.CategoryPagination;
import controllers.category.helpers.ViewElements;
import controllers.category.helpers.LoadInformation;
import controllers.category.helpers.CategoryFromTable;
import controllers.category.helpers.QuantityCategory;
import controllers.category.helpers.CategoryTableRefresher;
import controllers.category.helpers.CategoryValidator;
import controllers.category.helpers.FillBoxes;
import controllers.category.helpers.InputReader;

import utils.enums.SearchCriteriaEnum;
import utils.helpers.Modal;
import utils.enums.ModalTypeEnum;
import controllers.category.helpers.SelectedRowTable;

import java.awt.event.ActionListener;

public class CategoryController {

    private static final String TYPE_PRODUCT = "producto";
    private static final String TYPE_DISH = "platillo";
    private final CategoryModel model;
    private final WarehouseCategories view;
    private final WarehouseCreateCategory createView;
    private final WarehouseInfoCategory infoView;
    private final WarehouseEditCategory editView;
    private final ViewElements elements;
    private final CategoryService categoryService;
    private final FillBoxes fillBoxes;
    private final CategoryPagination paginateHandler;
    private final QuantityCategory quantityCategory;
    private final CategoryTableRefresher refresher;
    private final LoadInformation loadInfo;
    private final CategoryFromTable fromTable;
    private final CategoryValidator validator;
    private final InputReader inputReader;
    private final SelectedRowTable selectedRow;
    private final ChangeCategoryStatus activate;
    private final ChangeCategoryStatus deactivate;
    private final Modal modal = new Modal("Categorías del sistema - PuntoCafé");
    private Category categorySelected = null;

    public CategoryController(WarehouseCategories view, CategoryModel model) {
        this.model = model;
        
        this.view = view;
        this.infoView = new WarehouseInfoCategory();
        this.createView = new WarehouseCreateCategory();
        this.editView = new WarehouseEditCategory();
        
        this.categoryService = new CategoryService(this.model);
        
        this.inputReader = new InputReader(view, createView, editView);
        this.validator = new CategoryValidator(modal);
        this.elements = new ViewElements(view, createView, editView, infoView);
        this.fromTable = new CategoryFromTable(view, categoryService);
        this.fillBoxes = new FillBoxes(view);
        this.paginateHandler = new CategoryPagination(view, categoryService);
        this.quantityCategory = new QuantityCategory(view);
        this.refresher = new CategoryTableRefresher(paginateHandler);
        this.loadInfo = new LoadInformation(infoView, editView);
        this.selectedRow = new SelectedRowTable(view.categoriesTable);
        this.activate = new ChangeCategoryStatus(view, categoryService, true);
        this.deactivate = new ChangeCategoryStatus(view, categoryService, false);
       
        init();
        initListeners();
    }
    
    private void init() {
        paginateHandler.execute();
        quantityCategory.setQuantities(categoryService.getTotal());
        fillBoxes.fill(TYPE_PRODUCT, TYPE_DISH);
    }

    private void initListeners() {  
          view.btnSeeCategory.addActionListener(e -> openInfoCategoryWindow());
          view.btnNew.addActionListener( e -> openCreateCategoryWindow());
          view.btnSearch.addActionListener(e -> filterCategoriesByName());
          view.btnRestore.addActionListener(e -> resetCategories());
          view.pageCombo.addActionListener(e -> paginateHandler.executeLoadSelectedPage(SearchCriteriaEnum.NAME));
          view.itemsPerPageComboBox.addActionListener(e -> safelyRebuildPagination(SearchCriteriaEnum.NAME));
          view.categoryTypeCombo.addActionListener(e -> filterCategoriesByType());
          
          createView.btnCancelSaveCategory.addActionListener( e -> closeCreateCategoryWindow());
          createView.btnSaveCategory.addActionListener(e -> saveCategory());
          
          infoView.btnEdit.addActionListener(e -> openEditCategoryWindow());
          infoView.btnActivate.addActionListener( e -> activateCategory());
          infoView.btnDeactivate.addActionListener( e -> deactivateCategory());
          
          editView.btnCancelEditCategory.addActionListener( e -> closeEditCategoryWindow());
          editView.btnEditCategory.addActionListener( e -> editCategory());
    }

    private void saveCategory() {
        String categoryName = inputReader.getNameCreation();
        String categoryDesc = inputReader.getDescCreation();
        String categoryType = inputReader.getTypeCreation();
        
        if ( !validator.isValidForm( categoryName, categoryDesc, categoryType ) ) return; 
        
        if ( categoryService.getByName(categoryName) != null ) {        
            modal.show("La categoría " + categoryName + " ya existe", ModalTypeEnum.error);
            return;
        }
        
        Category newCategory = new Category(categoryName, categoryDesc, categoryType);
        boolean categoryWasSaved = categoryService.saveCategory(newCategory);
        
        if ( !categoryWasSaved ) {
            modal.show("La categoría no pudo ser creada", ModalTypeEnum.error);
            return;
        } 
        
        modal.show("La categoría ha sido creada existosamente", ModalTypeEnum.success);
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        elements.clearFormCreateCategory();
        quantityCategory.setQuantities(categoryService.getTotal());
        createView.dispose();
    }
    
    private void editCategory() {
        String newCategoryName = inputReader.getNameEdition();
        String newCategoryDesc = inputReader.getDescEdition();
        String newCategoryType = inputReader.getTypeEdition();
        
        if ( !validator.isValidForm( newCategoryName, newCategoryDesc, newCategoryType ) ) return; 
        
        if ( 
            !newCategoryName.equals(categorySelected.getCategoryName()) && 
            categoryService.getByName(newCategoryName) != null 
        ) {
            modal.show("La categoría " + newCategoryName + " ya existe", ModalTypeEnum.error);
            return;
        }
        
        Category category = new Category(newCategoryName, newCategoryDesc, newCategoryType);
        boolean wasCategoryUpdated = categoryService.updateCategory(category, categorySelected.getCategoryId());
        
        if (!wasCategoryUpdated) {
            modal.show("La categoría no pudo ser editada", ModalTypeEnum.error);
            return;
        }
        
        modal.show("La categoría ha sido editada existosamente", ModalTypeEnum.success);
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        elements.clearFormEditCategory();
        editView.dispose();
        infoView.dispose();
    }
    
    private void filterCategoriesByName() {
        String nameSearched = inputReader.getNameSearched();
        if ( nameSearched == null ) return;
        
        refresher.refresh(SearchCriteriaEnum.NAME, nameSearched); 
        elements.hidePagination();
    }
    
    private void filterCategoriesByType() {
        String typeSelected = inputReader.getTypeSelected();
        if ( typeSelected == null ) return;
        
        refresher.refresh(SearchCriteriaEnum.CATEGORY_TYPE, typeSelected);
        elements.hidePagination();
    }
    
    private void resetCategories() {
        elements.showPagination();
        elements.clearInputSearch();
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
    }
    
    private void activateCategory() {
        int id = selectedRow.getId();
        String status = selectedRow.getStatus();
        String name = selectedRow.getName();
        
        if ( !activate.isStatusValid(status) ) {
            modal.show("La categoría ya está activa", ModalTypeEnum.warning);
            return;
        }
        
        if ( modal.confirm("¿Está seguro de cambiar el estado de la categoría?") != 0 ) return;
        
        boolean wasStatusChangedSuccessfully = activate.change(id);
        
        if ( !wasStatusChangedSuccessfully ) {
            modal.show("La categoría no pudo cambiar de estado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("La categoría " + name + " se ha activado", ModalTypeEnum.success);
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        infoView.dispose();
    }
    
    private void deactivateCategory() {        
        int id = selectedRow.getId();
        String status = selectedRow.getStatus();
        String name = selectedRow.getName();
        
        if ( !deactivate.isStatusValid(status) ) {
            modal.show("La categoría ya está inactiva", ModalTypeEnum.warning);
            return;
        }
        
        if ( modal.confirm("¿Está seguro de cambiar el estado de la categoría?") != 0 ) return;
        
        boolean wasStatusChangedSuccessfully = deactivate.change(id);
        
        if ( !wasStatusChangedSuccessfully ) {
            modal.show("La categoría no pudo cambiar de estado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("La categoría " + name + " se ha desactivado", ModalTypeEnum.success);
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        infoView.dispose();
    }
    
    private void openInfoCategoryWindow() {
        if ( !selectedRow.validate() ) {
            modal.show("Seleccione una categoría", ModalTypeEnum.error);
            return;
        }
        
        Category category = fromTable.categorySelectedInTable(selectedRow.getSelectedRow());
        categorySelected = category;
        loadInfo.load(category);
        infoView.setVisible(true);
    }
    
    private void openEditCategoryWindow() {
        loadInfo.loadEdit( categorySelected );
        editView.setVisible(true);
    }
    
    private void openCreateCategoryWindow() {
        createView.setVisible(true);
    }
    
    private void closeCreateCategoryWindow() {
        createView.dispose();
        elements.clearFormCreateCategory();
    }
    
    private void closeEditCategoryWindow() {
        editView.dispose();
        elements.clearFormEditCategory();
    }
    
    private void safelyRebuildPagination(SearchCriteriaEnum criteria) {
        ActionListener[] listeners = view.pageCombo.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageCombo.removeActionListener(l);
        }

        paginateHandler.executeRebuildPagination(criteria);

        for (ActionListener l : listeners) {
            view.pageCombo.addActionListener(l);
        }
    }
}
