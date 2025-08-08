package controllers.menu;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import controllers.menu.helpers.ChangeMenuStatus;
import controllers.menu.helpers.Pages;
import controllers.menu.helpers.DishesListCreate;
import controllers.menu.helpers.DishesListEdit;
import controllers.menu.helpers.InputReader;
import controllers.menu.helpers.LoadInformation;
import controllers.menu.helpers.MenuDetailGrid;
import controllers.menu.helpers.MenuDishesRefresher;
import controllers.menu.helpers.MenuGrid;
import controllers.menu.helpers.MenuValidator;
import controllers.menu.helpers.ViewElements;

import entities.Dish;
import entities.Menu;
import entities.MenuDetail;
import entities.User;

import models.CategoryModel;
import models.DishModel;
import models.MenuDetailModel;
import models.MenuModel;

import services.CategoryService;
import services.DishService;
import services.MenuService;

import utils.enums.ModalTypeEnum;
import utils.helpers.DateFilterPanel;
import utils.helpers.Modal;
import utils.helpers.TableRowClickHelper;

import views.components.Card;
import views.components.Grid;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuDetail;
import views.warehouse.WarehouseMenuEdit;
import views.warehouse.WarehouseMenuEditInfo;
import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class MenuController {
    
    private final User user;
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuCreate menuCreateView;
    private final WarehouseMenuEdit menuEditView;
    private final WarehouseMenuDetail menuDetailView;
    private final WarehouseMenuEditInfo menuEditInfoView;
    
    private final MenuModel menuModel;
    private final MenuDetailModel menuDetailModel;
    private final CategoryModel categoryModel;
    private final DishModel dishModel;
    
    private final MenuService menuService;
    private final CategoryService categoryService;
    private final DishService dishesService;
    
    private final DateFilterPanel dateFilterCreate;
    private final DateFilterPanel dateFilterEdit;
    
    private final InputReader inputReader;
    private final MenuValidator menuValidator;
    private final ViewElements elements;
    private final LoadInformation load;
    private final MenuDishesRefresher dishesTableRefresher;
    private final DishesListCreate dishesListCreate;
    private final DishesListEdit dishesListEdit;
    private final MenuGrid menuGrid;
    private final MenuDetailGrid menuDetailGrid;
    private final Pages pages;
    private final ChangeMenuStatus activate;
    private final ChangeMenuStatus deactivate;
    
    private final Modal modal = new Modal("Menús del sistema - PuntoCafé");
    private final Card card = new Card();
    
    private Menu menu = null;
    private final int QUANTITY_ITEMS_GRID = 16;
    
    public MenuController(
            User user,
            WarehouseMenus view,
            MenuModel menuModel,
            MenuDetailModel menuDetailModel,
            CategoryModel categoryModel,
            DishModel dishModel
    ) {
        this.user = user;
        this.view = view;
        this.menuInfoView = new WarehouseMenuInfo();
        this.menuCreateView = new WarehouseMenuCreate();
        this.menuDetailView = new WarehouseMenuDetail(user);
        this.menuEditView = new WarehouseMenuEdit();
        this.menuEditInfoView = new WarehouseMenuEditInfo();
        
        this.menuModel = menuModel;
        this.menuDetailModel = menuDetailModel;
        this.categoryModel = categoryModel;
        this.dishModel = dishModel;
        
        this.menuService = new MenuService(this.menuModel, this.menuDetailModel);
        this.categoryService = new CategoryService(this.categoryModel);
        this.dishesService = new DishService(this.dishModel);
        
        this.dateFilterCreate = new DateFilterPanel(menuInfoView.startDatePanel, menuInfoView.endDatePanel);
        this.dateFilterEdit = new DateFilterPanel(menuEditInfoView.startDatePanel, menuEditInfoView.endDatePanel);
        
        this.inputReader = new InputReader(
                view, 
                menuInfoView, 
                menuEditInfoView, 
                menuCreateView, 
                dateFilterCreate, 
                dateFilterEdit
        );
        this.menuValidator = new MenuValidator(modal);
        this.elements = new ViewElements(view, menuInfoView, menuEditInfoView);
        this.load = new LoadInformation(menuCreateView, menuDetailView, menuEditView, menuEditInfoView);
        this.dishesListCreate = new DishesListCreate(menuCreateView);
        this.dishesListEdit = new DishesListEdit(menuEditView);
        this.dishesTableRefresher = new MenuDishesRefresher(menuCreateView, menuEditView, categoryService);
        this.menuGrid = new MenuGrid(view, card);
        this.menuDetailGrid = new MenuDetailGrid(menuDetailView, card);
        this.pages = new Pages(view);
        this.activate = new ChangeMenuStatus(menuService, true);
        this.deactivate = new ChangeMenuStatus(menuService, false);
        
        init();
        initListeners();
    }
    
    private void init() {  
        int quantityMenus = menuService.getQuantityMenus();
        pages.create(quantityMenus, QUANTITY_ITEMS_GRID);
        Grid.create(view.menuGrid, 4, 15);
        menuGrid.setOnSeeMoreInformation(menuPushed -> showMenuDetailWindow(menuPushed));
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
    }
    
    private void initListeners() {
        view.btnCreateMenu.addActionListener(e -> openMenuInfoWindow());
        view.pageComboBox.addActionListener(e -> loadMenusByPage());
        view.btnSearch.addActionListener(e -> filterMenusByName());
        view.filterStatus.addActionListener(e -> filterMenusByStatus());
        view.btnRestore.addActionListener(e -> restartView());
        
        menuInfoView.btnCreateMenu.addActionListener(e -> openMenuDetailWindow());
        menuInfoView.btnCancelCreateMenu.addActionListener(e -> closeMenuInfoWindow());
        
        menuCreateView.btnSearch.addActionListener(e -> filterDishesByName());
        menuCreateView.btnCancelSaveMenu.addActionListener(e -> cancelCreateMenu());
        menuCreateView.btnSaveMenu.addActionListener(e -> saveMenu());
        
        menuDetailView.btnActivate.addActionListener(e -> activateMenu());
        menuDetailView.btnDeactivate.addActionListener(e -> deactivateMenu());
        menuDetailView.btnChangeDishes.addActionListener(e -> changeDishesWindow());
        menuDetailView.btnEditMenu.addActionListener(e -> changeMenuInfo());
        
        menuEditView.btnCancelSaveMenu.addActionListener(e -> closeEditMenu());
        menuEditView.btnChangeDishes.addActionListener(e -> editDishes());
        
        menuEditInfoView.btnEditInfoMenu.addActionListener(e -> editMenuInfo());
        menuEditInfoView.btnCancelEditMenu.addActionListener(e -> closeEditMenuInfo());
        
        dishesListCreate.setOnDelete(dish -> removeDishOfList(dish));
        dishesListEdit.setOnDelete(dish -> removeDishOfListEdit(dish));
        
        TableRowClickHelper.addRowClickListener(menuCreateView.dishesTable, row -> addDishToList(row));
        TableRowClickHelper.addRowClickListener(menuEditView.dishesTable, row -> addDishToListEdit(row));
    }
    
    private void restartView() {
        elements.resetComboBoxes();
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
    }
    
    private void openMenuInfoWindow() {
        menu = null;
        menuInfoView.setVisible(true);
    }
    
    private void openMenuDetailWindow() {
        String menuName = inputReader.getMenuName();
        String menuDesc = inputReader.getMenuDescription();
        String startDate = inputReader.getStartDate();
        String endDate = inputReader.getEndDate();
        
        if (!menuValidator.isValidForm(menuName, menuDesc, startDate, endDate)) return;
        
        menu = new Menu(menuName, menuDesc, startDate, endDate);
        load.loadCreateMenuInformation(menuName, startDate, endDate);
        dishesTableRefresher.load(dishesService.getAllDishes(1, 100));
        menuCreateView.setVisible(true);
    }
    
    private void filterDishesByName() {
        String dishSearched = inputReader.getDishSearched();
        if ( dishSearched == null ) {
            dishesTableRefresher.load(dishesService.getAllDishes(1, 100));
            return;
        }
        dishesTableRefresher.load(dishesService.getDishesByName(dishSearched, 1, 100));
    }
    
    private void closeMenuInfoWindow() {
        elements.clearCreateMenuForm();
        menuInfoView.dispose();
    }
    
    private void cancelCreateMenu() {
        if ( modal.confirm("¿Está seguro de cancelar la creación del menú?") != 0 ) return;
        menu = null;
        elements.clearCreateMenuForm();
        dishesListCreate.clearList();
        menuInfoView.dispose();
        menuCreateView.dispose();
    }
    
    private void addDishToList(int rowSelected) {
        int dishId = Integer.parseInt(menuCreateView.dishesTable.getValueAt(rowSelected, 0).toString());
        Dish dishSelected = dishesService.getDishById(dishId);
        dishesListCreate.addDish(dishSelected);
    }
    
    private void addDishToListEdit(int rowSelected) {
        int dishId = Integer.parseInt(menuEditView.dishesTable.getValueAt(rowSelected, 0).toString());
        Dish dishSelected = dishesService.getDishById(dishId);
        dishesListEdit.addDish(dishSelected);
    }
    
    private void removeDishOfList(Dish dish) {
        int dishId = dish.getDishID();
        dishesListCreate.removeDish(dishId);
    }
    
    private void removeDishOfListEdit(Dish dish) {
        int dishId = dish.getDishID();
        dishesListEdit.removeDish(dishId);
    }
    
    private void saveMenu() {
        if ( dishesListCreate.getDishList().isEmpty() ) {
            modal.show("No es posible crear un menú sin platillos. Elige algunos", ModalTypeEnum.error);
            return;
        }
        
        if ( modal.confirm("¿Desea confirma el registro menú?") != 0 ) return;
        
        Menu newMenu = menuService.saveMenu(menu);
        
        if ( newMenu == null ) {
            modal.show("Hubo un problema al crear el menú", ModalTypeEnum.error);
            return;
        }
        
        List<Dish> dishes = dishesListCreate.getDishList();
        if ( !saveMenuDetail(dishes, newMenu.getMenuId()) ) {
            modal.show("Error al guardar el detalle de menú", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El menú ha sido creado exitosamente", ModalTypeEnum.success);
        dishesListCreate.clearList();
        menuCreateView.dispose();
        menuInfoView.dispose();
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
        safelyRebuildPagination();
    }
    
    private boolean saveMenuDetail(List<Dish> dishes, int menuId) {        
        for( Dish dish: dishes ) {
            int dishId = dish.getDishID();
            MenuDetail menuDetail = new MenuDetail(dishId, menuId);
            if ( !menuService.saveMenuDetail(menuDetail) ) {
                return false;
            }
        }
        
        return true;
    }
    
    private void showMenuDetailWindow(Menu menuSelected) { 
        menu = menuSelected;
        load.loadMenuDetailName(menuSelected.getMenuName());
        Grid.createFlowLayout(menuDetailView.menuDetailGrid, 10, 10);
        menuDetailGrid.showMenuDishes(getDishesFromMenuDetail(menuSelected.getMenuId()));
        menuDetailView.setVisible(true);  
    }
    
    private List<Dish> getDishesFromMenuDetail( int menuId ) {        
        List<MenuDetail> menuDetail = menuService.getMenuDetail(menuId);

        List<Dish> dishes = new ArrayList<>();
        for( MenuDetail detail: menuDetail ) {
            Dish dish = dishesService.getDishById(detail.getDishId());
            dishes.add(dish);
        }
        
        return dishes;
    }
    
    private void filterMenusByName() {
        String menuSearched = inputReader.getMenuSearched();
        if ( menuSearched == null ) return;
        menuGrid.showMenus(menuService.getMenusByName(menuSearched));
    }
    
    private void filterMenusByStatus() {
        String statusSelected = inputReader.getStatusSelected();
        if ( statusSelected == null ) return;
        menuGrid.showMenus(menuService.getMenusByStatus(statusSelected));
    }
    
    private void loadMenusByPage() {
        int page = pages.getPageSelected();
        menuGrid.showMenus(menuService.getAllMenus(page, QUANTITY_ITEMS_GRID));
    }
    
    private void activateMenu() {
        if ( !activate.isStatusValid( menu.getIsActive() ? "Activo" : "Inactivo" ) ) {
            modal.show("El menú ya está activo", ModalTypeEnum.warning);
            return;
        }
        
        if ( modal.confirm("¿Está seguro de cambiar el estado del menú?") != 0 ) return;
    
        boolean wasStatusChangedSuccessfully = activate.change(menu.getMenuId());
        
        if (!wasStatusChangedSuccessfully) {
            modal.show("El menú no pudo cambiar de estado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El menú " + menu.getMenuName() + " ha sido activado", ModalTypeEnum.success);
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
        menuDetailView.dispose();
    }
    
    private void deactivateMenu() {
        if ( !deactivate.isStatusValid( menu.getIsActive() ? "Activo" : "Inactivo" ) ) {
            modal.show("El menú ya está inactivo", ModalTypeEnum.warning);
            return;
        }
        
        if ( modal.confirm("¿Está seguro de cambiar el estado del menú?") != 0 ) return;
    
        boolean wasStatusChangedSuccessfully = deactivate.change(menu.getMenuId());
        
        if (!wasStatusChangedSuccessfully) {
            modal.show("El menú no pudo cambiar de estado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El menú " + menu.getMenuName() + " ha sido deactivado", ModalTypeEnum.success);
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
        menuDetailView.dispose();
    }
    
    private void safelyRebuildPagination() {
        ActionListener[] listeners = view.pageComboBox.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageComboBox.removeActionListener(l);
        }

        for (ActionListener l : listeners) {
            view.pageComboBox.addActionListener(l);
        }
    }
    
    private void changeDishesWindow() {
        load.loadEditMenuInformation(menu.getMenuName(), menu.getMenuStartDate(), menu.getMenuEndDate());
        int menuId = menu.getMenuId();
        List<Dish> dishes = getDishesFromMenuDetail(menuId);
        dishesListEdit.setDishesList(dishes);
        dishesListEdit.render();
        dishesTableRefresher.loadInEditWindow(dishesService.getAllDishes(1, 100));
        menuEditView.setVisible(true);
    }
    
    private void closeEditMenu() {
        menuEditView.dispose();
        dishesListEdit.clearList();
    }
    
    private void editDishes() {
        if ( dishesListEdit.getDishList().isEmpty() ) {
            modal.show("No es posible eliminar todos los platillos del menú. Elige algunos", ModalTypeEnum.error);
            return;
        }
        
        boolean wasDishesDeleted = menuService.deleteDishesFromMenu(menu.getMenuId());
        
        if ( !wasDishesDeleted ) {
            modal.show("Error al actualizar el menú", ModalTypeEnum.error);
            return;
        }
        
        List<Dish> dishes = dishesListEdit.getDishList();
        
        if ( !saveMenuDetail(dishes, menu.getMenuId()) ) {
            modal.show("Error al actualizar el menú", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El menú ha sido creado exitosamente", ModalTypeEnum.success);
        dishesListEdit.clearList();
        menuEditView.dispose();
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));  
        menuDetailGrid.showMenuDishes(getDishesFromMenuDetail(menu.getMenuId()));
    }
    
    private void changeMenuInfo() {
        menuEditInfoView.setVisible(true);
        load.loadEditMenuInfo(menu, dateFilterEdit);
    }
    
    private void editMenuInfo() {
        String menuName = inputReader.getMenuNameEdit();
        String menuDesc = inputReader.getMenuDescriptionEdit();
        String menuStartDate = inputReader.getStartDateEdit();
        String menuEndDate = inputReader.getEndDateEdit();
        
        if ( !menuValidator.isValidForm(menuName, menuDesc, menuStartDate, menuEndDate)) return;
        
        if ( 
            !menuName.equals(menu.getMenuName()) && 
            menuService.getMenuByName(menuName) != null 
        ) {
            modal.show("El menú " + menuName + " ya existe. Intente con otro nombre", ModalTypeEnum.error);
            return;
        }
        
        Menu newMenu = new Menu(menuName, menuDesc, menuStartDate, menuEndDate);
        if ( !menuService.updateMenu(menu.getMenuId(), newMenu) ) {
            modal.show("El menú no pudo ser actualizado.", ModalTypeEnum.error);
            return;
        }
        
        menu = new Menu(menuName, menuDesc, menuStartDate, menuEndDate);
        modal.show("Menú actualizado correctamente", ModalTypeEnum.success);
        load.loadEditMenuInformation(menuName, menuStartDate, menuEndDate);
        load.loadEditMenuInfo(menu, dateFilterEdit);
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));  
        menuEditInfoView.dispose();
    }
    
    private void closeEditMenuInfo() {
        menuEditInfoView.dispose();
        elements.clearEditMenuForm();
    }

}
