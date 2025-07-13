package controllers.dish;

import controllers.dish.handlers.EditDishHandler;
import controllers.dish.handlers.SaveDishHandler;
import controllers.dish.helpers.DishGrid;
import controllers.dish.helpers.DishValidator;
import controllers.dish.helpers.FillComboBoxes;
import controllers.dish.helpers.LoadEditInformation;
import controllers.dish.helpers.LoadInformationDish;
import controllers.dish.helpers.ResetElements;
import controllers.dish.helpers.UploadDishImage;
import controllers.dish.helpers.Pages;
import controllers.interfaces.HandlerController;
import entities.Dish;
import java.awt.event.ActionListener;
import models.CategoryModel;
import models.DishModel;
import services.CategoryService;
import services.DishService;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateDish;
import views.warehouse.WarehouseDishes;
import views.warehouse.WarehouseEditDish;
import views.warehouse.WarehouseInfoDish;

public class DishController {
    
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
    private final ResetElements resetElements;
    private final DishValidator dishValidator;
    private final HandlerController saveDishHandler; 
    private final HandlerController editDishHandler;
    private final Pages pages;
    private final DishGrid dishGrid;
    private final LoadInformationDish loadInfo;
    private final LoadEditInformation loadEdit;
    private final Modal modal = new Modal("Platillos del sistema - PuntoCafé");
    private Dish dishSelected = null;
    
    public DishController(
            WarehouseDishes view,
            DishModel model,
            CategoryModel categoryModel
    ) { 
        this.view = view;
        this.model = model;
        this.categoryModel = categoryModel;
        
        this.dishService = new DishService(model);
        this.categoryService = new CategoryService(categoryModel);
    
        this.createDishWindow = new WarehouseCreateDish();
        this.infoDishWindow = new WarehouseInfoDish();
        this.editDishWindow = new WarehouseEditDish();
        
        this.dishGrid = new DishGrid(view, dishService, categoryService);
        this.pages = new Pages(view, dishService);
        this.upload = new UploadDishImage(createDishWindow, editDishWindow, modal);
        this.fillComboBoxes = new FillComboBoxes(view, createDishWindow, editDishWindow);
        this.resetElements = new ResetElements(createDishWindow, editDishWindow);
        this.dishValidator = new DishValidator(createDishWindow, editDishWindow, modal);
        this.loadInfo = new LoadInformationDish(infoDishWindow, categoryService);
        this.loadEdit = new LoadEditInformation(editDishWindow, categoryService);
        
        this.saveDishHandler = new SaveDishHandler(createDishWindow, categoryService, dishService, modal);
        this.editDishHandler = new EditDishHandler(editDishWindow, categoryService, dishService, modal);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
        resetElements.showButtonUploadImage();
        fillComboBoxes.categoriesFilterBox(categoryService.getDishesCategories());
        fillComboBoxes.categoriesCreateBox(categoryService.getDishesCategories());
    }
    
    private void initListeners() {
        
        view.btnNewDish.addActionListener(e -> openCreateDishWindow());
        
        createDishWindow.btnCancelSaveDish.addActionListener(e -> closeCreateDishWindow());
        createDishWindow.btnSaveDish.addActionListener(e -> createDish());
        createDishWindow.btnLoadImage.addActionListener(e -> upload.load(false));
        createDishWindow.btnRemoveImage.addActionListener(e -> removeImage());
    
        infoDishWindow.btnEditDish.addActionListener(e -> openEditDishWindow());
        
        editDishWindow.btnCancelEditDish.addActionListener(e -> closeEditDishWindow());
        editDishWindow.btnLoadImage.addActionListener(e -> upload.load(true));
        editDishWindow.btnRemoveImage.addActionListener(e -> removeImage());
        editDishWindow.btnUpdateDish.addActionListener(e -> editDish());
        
        dishGrid.setOnDishClick( dish -> openInfoDish(dish) );
        
        dishGrid.showAllDishes(1);
    }
    
    private void editDish() {
        if (!dishValidator.isValidEdition()) return;
        
        if (!upload.handleUploadForEdit()) {
            ((EditDishHandler) editDishHandler).setDishImage("no-image.jpg");
            return;
        }
        
        ((EditDishHandler) editDishHandler).setDishImage(upload.image);
        ((EditDishHandler) editDishHandler).setDishId(dishSelected.getDishID());
        editDishHandler.execute();
        dishGrid.showAllDishes(1);
        safelyRebuildPagination(() -> pages.create());
        resetElements.resetEditForm();
        infoDishWindow.setVisible(false);
        editDishWindow.setVisible(false);
        upload.removeImage();
    }
    
    private void removeImage() {
        upload.removeImage();
        resetElements.showButtonUploadImage();
    }
    
    private void closeEditDishWindow() {
        infoDishWindow.setVisible(false);
        editDishWindow.setVisible(false);
        resetElements.resetEditForm();
        ((EditDishHandler) editDishHandler).setDishOldName(null);
        ((EditDishHandler) editDishHandler).setDishId(0);
        ((EditDishHandler) editDishHandler).setDishImage(null);
    }
    
    private void openEditDishWindow() {
        editDishWindow.setVisible(true);
        
        if ( dishSelected != null ) {
            ((EditDishHandler) editDishHandler).setDishOldName(dishSelected.getDishName());
            upload.image = dishSelected.getDishImage();
            fillComboBoxes.categoriesEditBox(categoryService.getDishesCategories());
            resetElements.hideButtonUploadImage();
            loadEdit.load(dishSelected);
        }
    }
    
    private void openInfoDish(Dish dish) {
        dishSelected = dish;
        loadInfo.load(dish);
        infoDishWindow.setVisible(true);
    }
    
    private void closeCreateDishWindow() {
        resetElements.resetCreateForm();
        upload.removeImage();
        createDishWindow.setVisible(false);
    }
    
    private void createDish() {
        if ( !dishValidator.isValidCreation() ) return; 
        
        if (!upload.handleUploadForCreate()) {
            ((SaveDishHandler) saveDishHandler).setDishImage("no-image.jpg");
            return;
        }
        
        ((SaveDishHandler) saveDishHandler).setDishImage(upload.image);
        saveDishHandler.execute();
        dishGrid.showAllDishes(1);
        safelyRebuildPagination(() -> pages.create());
        resetElements.resetCreateForm();
        createDishWindow.setVisible(false);
        upload.removeImage();
    }
    
    private void openCreateDishWindow() {
        fillComboBoxes.categoriesCreateBox(categoryService.getDishesCategories());
        resetElements.showButtonUploadImage();
        createDishWindow.setVisible(true);
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
    
}
