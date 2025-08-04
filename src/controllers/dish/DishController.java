package controllers.dish;

import controllers.dish.helpers.ChangeDishStatus;
import controllers.dish.helpers.DishGrid;
import controllers.dish.helpers.DishValidator;
import controllers.dish.helpers.FillComboBoxes;
import controllers.dish.helpers.InputReader;
import controllers.dish.helpers.LoadInformation;
import controllers.dish.helpers.ViewElements;
import controllers.dish.helpers.UploadDishImage;
import controllers.dish.helpers.Pages;
import controllers.dish.helpers.QuantityDishes;
import entities.Dish;
import entities.User;
import java.awt.event.ActionListener;
import models.CategoryModel;
import models.DishModel;
import services.CategoryService;
import services.DishService;
import utils.enums.ModalTypeEnum;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.GenerateReports;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateDish;
import views.warehouse.WarehouseDishes;
import views.warehouse.WarehouseEditDish;
import views.warehouse.WarehouseInfoDish;

public class DishController {
    
    private final User user;
    private final WarehouseDishes view;
    private final DishModel model;
    private final CategoryModel categoryModel;
    private final DishService dishService;
    private final CategoryService categoryService;
    private final WarehouseCreateDish createDishWindow;
    private final WarehouseInfoDish infoDishWindow;
    private final WarehouseEditDish editDishWindow;
    private final FillComboBoxes fillComboBoxes;
    private final UploadDishImage upload;
    private final ViewElements elements;
    private final DishValidator validator;
    private final ChangeDishStatus activateDish;
    private final ChangeDishStatus deactivateDish;
    private final Pages pages;
    private final InputReader inputReader;
    private final DishGrid dishGrid;
    private final QuantityDishes quantity;
    private final LoadInformation loadInfo;
    private final Modal modal = new Modal("Platillos del sistema - PuntoCafé");
    private Dish dishSelected = null;
    private String image = null;
    private SearchCriteriaEnum filterSelected = SearchCriteriaEnum.NONE;
    
    public DishController(
            User user,
            WarehouseDishes view,
            DishModel model,
            CategoryModel categoryModel
    ) { 
        this.user = user;
        this.view = view;
        this.model = model;
        this.categoryModel = categoryModel;
        
        this.dishService = new DishService(this.model);
        this.categoryService = new CategoryService(this.categoryModel);
    
        this.createDishWindow = new WarehouseCreateDish();
        this.infoDishWindow = new WarehouseInfoDish(user);
        this.editDishWindow = new WarehouseEditDish();

        this.inputReader = new InputReader(view, createDishWindow, editDishWindow);
        this.dishGrid = new DishGrid(view, dishService, categoryService);
        this.pages = new Pages(view, dishService);
        this.upload = new UploadDishImage(createDishWindow, editDishWindow, modal);
        this.fillComboBoxes = new FillComboBoxes(view, createDishWindow, editDishWindow);
        this.elements = new ViewElements(view, createDishWindow, editDishWindow);
        this.validator = new DishValidator(modal);
        this.loadInfo = new LoadInformation(infoDishWindow, editDishWindow, categoryService);
        this.quantity = new QuantityDishes(view);
        this.activateDish = new ChangeDishStatus(infoDishWindow, dishService, modal, true);
        this.deactivateDish = new ChangeDishStatus(infoDishWindow, dishService, modal, false);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
        quantity.setQuantity(dishService.getQuantityDishes());
        elements.showButtonUploadImage();
        fillComboBoxes.categoriesFilterBox(categoryService.getDishesCategories());
        fillComboBoxes.categoriesCreateBox(categoryService.getDishesCategories());
        fillComboBoxes.categoriesEditBox(categoryService.getDishesCategories());
    }
    
    private void initListeners() {
        view.btnNewDish.addActionListener(e -> openCreateDishWindow());
        view.dishCategoryCombo.addActionListener(e -> filterDishByCategory());
        view.dishStatusCombo.addActionListener(e -> filterDishesByStatus());
        view.pageComboBox.addActionListener(e -> changePage(filterSelected));
        view.btnSearch.addActionListener(e -> filterDishesByName());
        view.btnExportDishes.addActionListener(e -> generateReport());
        view.btnReload.addActionListener(e -> seeAllDishes());
        
        createDishWindow.btnCancelSaveDish.addActionListener(e -> closeCreateDishWindow());
        createDishWindow.btnSaveDish.addActionListener(e -> saveDish());
        createDishWindow.btnLoadImage.addActionListener(e -> upload.load(false));
        createDishWindow.btnRemoveImage.addActionListener(e -> removeImage());
    
        infoDishWindow.btnEditDish.addActionListener(e -> openEditDishWindow());
        infoDishWindow.btnActivate.addActionListener(e -> activateDish());
        infoDishWindow.btnDeactivate.addActionListener(e -> deactivateDish());
        
        editDishWindow.btnCancelEditDish.addActionListener(e -> closeEditDishWindow());
        editDishWindow.btnLoadImage.addActionListener(e -> upload.load(true));
        editDishWindow.btnRemoveImage.addActionListener(e -> removeImage());
        editDishWindow.btnUpdateDish.addActionListener(e -> editDish());
        
        dishGrid.setOnDishClick( dish -> openInfoDish(dish) );
        
        dishGrid.showAllDishes(1);
    }
    
    private void saveDish() {
        String dishName = inputReader.getNameCreate();
        String categorySelected = inputReader.getCategoryCreate();
        String price = inputReader.getPriceCreate();
        String description = inputReader.getDescriptionCreate();
        
        if ( !validator.isValidForm(dishName, description, price, categorySelected) ) return;
        
        if (!upload.handleUploadForCreate()) {
            image = "no-image.jpg";
            return;
        }
        image = upload.image;
                
        if ( dishService.getDishByName(dishName) != null ) {
            modal.show("El platillo ya existe", ModalTypeEnum.error);
            return;
        }
        
        int categoryId = categoryService.getByName(categorySelected).getCategoryId();
        Dish dish = new Dish( dishName, description, image, Double.valueOf(price), categoryId );
        
        if ( !dishService.saveDish(dish) ) {
            modal.show("El platillo no pudo ser creado", ModalTypeEnum.error);
            return; 
        }
        
        modal.show("El platillo ha sido creado exitosamente", ModalTypeEnum.success); 
        dishGrid.showAllDishes(1);
        safelyRebuildPagination(() -> pages.create());
        quantity.setQuantity(dishService.getQuantityDishes());
        elements.resetCreateForm();
        createDishWindow.dispose();
        upload.removeImage();
    }
    
    private void editDish() {
        String dishName = inputReader.getNameEdition();
        String categorySelected = inputReader.getCategoryEdition();
        String price = inputReader.getPriceEdition();
        String description = inputReader.getDescriptionEdition();
        
        if (!validator.isValidForm(dishName, description, price, categorySelected)) return;
        
        if (!upload.handleUploadForEdit()) {
            image = "no-image.jpg";
            return;
        }
        image = upload.image;
        
        Dish existingDish = dishService.getDishByName(dishName);
        int dishId = dishSelected.getDishID();
        String oldDishName = dishSelected.getDishName();
        
        if ( !dishName.equals(oldDishName) && existingDish != null && existingDish.getDishID() != dishId ) {
            modal.show("El platillo ya existe", ModalTypeEnum.error);
            return;
        }
        
        int categoryId = categoryService.getByName(categorySelected).getCategoryId();
        Dish dish = new Dish(dishName, description, image, Double.valueOf(price), categoryId);
        
        if (!dishService.editDish(dish, dishId)) {
            modal.show("El platillo no pudo ser actualizado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El platillo ha sido actualizado exitosamente", ModalTypeEnum.success);        
        dishGrid.showAllDishes(1);
        safelyRebuildPagination(() -> pages.create());
        elements.resetEditForm();
        infoDishWindow.dispose();
        editDishWindow.dispose();
        upload.removeImage();
    }
    
    private void activateDish() {
        if ( !activateDish.isValidStatus(dishSelected.getIsActive())) return;
        if ( !activateDish.confirmChange() ) return;
        
        int dishId = dishSelected.getDishID();
        activateDish.change(dishId);
        dishGrid.showAllDishes(1);
        infoDishWindow.setVisible(false);
    }
    
    private void deactivateDish() {
        if ( !deactivateDish.isValidStatus(dishSelected.getIsActive())) return;
        if ( !deactivateDish.confirmChange() ) return;
        
        int dishId = dishSelected.getDishID();
        deactivateDish.change(dishId);
        dishGrid.showAllDishes(1);
        infoDishWindow.setVisible(false);
    }
    
    private void changePage(SearchCriteriaEnum criteria) {
        int selectedPage = pages.getSelectedPage();
        
        switch ( criteria ) {
            case SearchCriteriaEnum.NONE -> dishGrid.showAllDishes(selectedPage);
            case SearchCriteriaEnum.NAME -> dishGrid.showDishesByName(inputReader.getDishNameSearched(), selectedPage);
            case SearchCriteriaEnum.DISH_CATEGORY -> {
                int categoryId = categoryService.getByName(inputReader.getCategorySelected()).getCategoryId();
                dishGrid.showDishesByCategory(categoryId, selectedPage);
            }
            case SearchCriteriaEnum.STATUS -> dishGrid.showDishesByStatus(inputReader.getStatusSelected(), selectedPage);
        }
    }
    
    private void filterDishesByName() {
        String dishNameSearched = inputReader.getDishNameSearched();
        
        if ( dishNameSearched == null ) {
            safelyRebuildPagination(() -> pages.create());
            filterSelected = SearchCriteriaEnum.NONE;
            dishGrid.showAllDishes(1);
            return;
        }
        
        safelyRebuildPagination(() -> pages.createByName(dishNameSearched));
        dishGrid.showDishesByName(dishNameSearched, 1);
        filterSelected = SearchCriteriaEnum.NAME;
    }
    
    private void filterDishesByStatus() {
        String statusSelected = inputReader.getStatusSelected();
        if ( statusSelected == null ) return;
        
        safelyRebuildPagination(() -> pages.createByStatus(statusSelected));
        dishGrid.showDishesByStatus(statusSelected, 1);
        filterSelected = SearchCriteriaEnum.STATUS;
    }
    
    private void filterDishByCategory() {
        String categorySelected = inputReader.getCategorySelected();
        if ( categorySelected == null ) return;
        
        int categoryId = categoryService.getByName(categorySelected).getCategoryId();
        safelyRebuildPagination(() -> pages.createByCategories(categoryId));
        dishGrid.showDishesByCategory(categoryId, 1);
        filterSelected = SearchCriteriaEnum.DISH_CATEGORY;
    }
    
    private void seeAllDishes() {
        safelyRebuildPagination(() -> pages.create());
        filterSelected = SearchCriteriaEnum.NONE;
        elements.clearInputSearch();
        dishGrid.showAllDishes(1);
        safelyFillCategoriesFilterBox();
    }
    
    private void removeImage() {
        upload.removeImage();
        elements.showButtonUploadImage();
    }
    
    private void closeEditDishWindow() {
        infoDishWindow.dispose();
        editDishWindow.dispose();
        elements.resetEditForm();
        image = null;
    }
    
    private void openEditDishWindow() {
        editDishWindow.setVisible(true);
        upload.image = dishSelected.getDishImage();
        fillComboBoxes.categoriesEditBox(categoryService.getDishesCategories());
        elements.hideButtonUploadImage();
        loadInfo.loadEditInfo(dishSelected, categoryService.getById(dishSelected.getCategoryId()).getCategoryName());
    }
    
    private void openInfoDish(Dish dish) {
        dishSelected = dish;
        loadInfo.loadDishInfo(dishSelected, categoryService.getById(dishSelected.getCategoryId()).getCategoryName());
        infoDishWindow.setVisible(true);
    }
    
    private void closeCreateDishWindow() {
        elements.resetCreateForm();
        upload.removeImage();
        createDishWindow.dispose();
    }
    
    private void openCreateDishWindow() {
        fillComboBoxes.categoriesCreateBox(categoryService.getDishesCategories());
        elements.showButtonUploadImage();
        createDishWindow.setVisible(true);
    }
    
    private void generateReport() {
        GenerateReports.generateReport("dishes-report", "Reporte de platillos del sistema");
    }
    
    private void safelyRebuildPagination(Runnable rebuildLogic) {
        ActionListener[] listeners = view.pageComboBox.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageComboBox.removeActionListener(l);
        }

        rebuildLogic.run();

        for (ActionListener l : listeners) {
            view.pageComboBox.addActionListener(l);
        }
    }
    
    private void safelyFillCategoriesFilterBox() {
        ActionListener[] listeners = view.dishCategoryCombo.getActionListeners();
        for (ActionListener l : listeners) {
            view.dishCategoryCombo.removeActionListener(l);
        }

        fillComboBoxes.categoriesFilterBox(categoryService.getDishesCategories());

        for (ActionListener l : listeners) {
            view.dishCategoryCombo.addActionListener(l);
        }
    }
    
}
