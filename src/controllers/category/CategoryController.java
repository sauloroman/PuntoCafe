package controllers.category;

import controllers.category.helpers.LoadEditCategory;
import models.CategoryModel;
import services.CategoryService;
import controllers.category.handlers.*;
import controllers.category.helpers.QuantityCategory;
import controllers.category.helpers.SearchCategory;
import controllers.category.helpers.CategoryTableRefresher;
import controllers.category.helpers.FillBoxes;
import controllers.interfaces.ChangeStatusInterface;
import controllers.interfaces.HandlerController;
import views.warehouse.WarehouseCategories;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.NavegationTabs;
import utils.helpers.Modal;

import java.awt.event.ActionListener;
import utils.helpers.SelectedRowTable;

public class CategoryController {

    private static final String TYPE_PRODUCT = "producto";
    private static final String TYPE_DISH = "platillo";
    private final int QUANTITY_TABS = 3;
    private final CategoryModel model;
    private final WarehouseCategories view;
    private final CategoryService categoryService;
    private final FillBoxes fillBoxes;
    private final CategoryPaginationHandler paginateHandler;
    private final QuantityCategory quantityCategory;
    private final CategoryTableRefresher refresher;
    private final SearchCategory searchHandler;
    private final LoadEditCategory loadEditHandler;
    private final SelectedRowTable selectedRow;
    private final HandlerController saveHandler;
    private final HandlerController editHandler;
    private final ChangeStatusInterface activateHandler;
    private final ChangeStatusInterface deactivateHandler;
    private final Modal modal = new Modal("Categorías del sistema - PuntoCafé");

    public CategoryController(WarehouseCategories view, CategoryModel model) {
        this.model = model;
        this.view = view;
        
        this.categoryService = new CategoryService(model);

        this.fillBoxes = new FillBoxes(view);
        this.paginateHandler = new CategoryPaginationHandler(view, categoryService);
        this.quantityCategory = new QuantityCategory(view, categoryService);
        this.refresher = new CategoryTableRefresher(paginateHandler);
        this.searchHandler = new SearchCategory(view);
        this.loadEditHandler = new LoadEditCategory(view, modal);
        this.selectedRow = new SelectedRowTable(modal, view.categoriesTable);
        this.saveHandler = new SaveCategoryHandler(view, categoryService, modal);
        this.editHandler = new EditCategoryHandler(view, categoryService, modal);
        this.activateHandler = new ChangeCategoryStatusHandler(view, categoryService, modal, true);
        this.deactivateHandler = new ChangeCategoryStatusHandler(view, categoryService, modal, false);
       
        init();
        initListeners();
    }
    
    private void init() {
        paginateHandler.execute();
        quantityCategory.setQuantities();
        fillBoxes.fill(TYPE_PRODUCT, TYPE_DISH);
    }

    private void initListeners() {        
        view.btnSaveCategory.addActionListener(e -> saveCategory());
        view.btnEditCategory.addActionListener(e -> editCategory());
        view.btnSearch.addActionListener(e -> searchCategory());
        view.btnEdit.addActionListener(e -> loadInformationToEdit());
        view.btnActivate.addActionListener(e -> activateCategory());
        view.btnDeactivate.addActionListener(e -> deactivateCategory());

        view.btnNew.addActionListener(e -> NavegationTabs.activateTabPane(view.categoriesNavegationPane, QUANTITY_TABS, 1));
        view.btnCancelEditCategory.addActionListener(e -> NavegationTabs.activateTabPane(view.categoriesNavegationPane, QUANTITY_TABS, 0));
        view.btnCancelSaveCategory.addActionListener(e -> NavegationTabs.activateTabPane(view.categoriesNavegationPane, QUANTITY_TABS, 0));
        view.pageComboBox.addActionListener(e -> paginateHandler.executeLoadSelectedPage(SearchCriteriaEnum.NAME));
        view.itemsPerPageComboBox.addActionListener(e -> safelyRebuildPagination(SearchCriteriaEnum.NAME));
    }

    private void saveCategory() {
        saveHandler.execute();
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        quantityCategory.setQuantities();
        NavegationTabs.activateTabPane(view.categoriesNavegationPane, QUANTITY_TABS, 0);
    }
    
    private void editCategory() {
        editHandler.execute();
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
    }
    
    private void searchCategory() {
       String input = searchHandler.getSearchCriteria();
       refresher.refresh(SearchCriteriaEnum.NAME, input); 
    }
    
    private void loadInformationToEdit() {
        if ( !selectedRow.validate("Seleccione una categoría") ) return;
        loadEditHandler.load();
        NavegationTabs.activateTabPane(view.categoriesNavegationPane, QUANTITY_TABS, 2);
    }
    
    private void activateCategory() {
        if ( !selectedRow.validate("Seleccione una categoría") ) return;
        int row = selectedRow.getSelectedRow();
        if ( !activateHandler.isStatusValid(row) ) return;
        if ( !activateHandler.confirmChange(row) ) return;
        activateHandler.change(row);    
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        quantityCategory.setQuantities();
    }
    
    private void deactivateCategory() {
        if ( !selectedRow.validate("Seleccione una categoría") ) return;
        int row = selectedRow.getSelectedRow();
        if ( !deactivateHandler.isStatusValid(row) ) return;
        if ( !deactivateHandler.confirmChange(row) ) return;
        deactivateHandler.change(row);    
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
        quantityCategory.setQuantities();
    }
    
    private void safelyRebuildPagination(SearchCriteriaEnum criteria) {
        ActionListener[] listeners = view.pageComboBox.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageComboBox.removeActionListener(l);
        }

        paginateHandler.executeRebuildPagination(criteria);

        for (ActionListener l : listeners) {
            view.pageComboBox.addActionListener(l);
        }
    }
}
