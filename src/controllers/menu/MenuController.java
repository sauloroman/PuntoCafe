package controllers.menu;

import controllers.menu.helpers.ChangeMenuStatus;
import controllers.menu.helpers.Pages;
import controllers.menu.helpers.DishesList;
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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class MenuController {
    
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuCreate menuCreateView;
    private final WarehouseMenuDetail menuDetailView;
    
    private final MenuModel menuModel;
    private final MenuDetailModel menuDetailModel;
    private final CategoryModel categoryModel;
    private final DishModel dishModel;
    
    private final MenuService menuService;
    private final CategoryService categoryService;
    private final DishService dishesService;
    
    private final DateFilterPanel dateFilter;
    private final InputReader inputReader;
    private final MenuValidator menuValidator;
    private final ViewElements elements;
    private final LoadInformation load;
    private final MenuDishesRefresher dishesTableRefresher;
    private final DishesList dishesList;
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
            WarehouseMenus view,
            MenuModel menuModel,
            MenuDetailModel menuDetailModel,
            CategoryModel categoryModel,
            DishModel dishModel
    ) {
        this.view = view;
        this.menuInfoView = new WarehouseMenuInfo();
        this.menuCreateView = new WarehouseMenuCreate();
        this.menuDetailView = new WarehouseMenuDetail();
        
        this.menuModel = menuModel;
        this.menuDetailModel = menuDetailModel;
        this.categoryModel = categoryModel;
        this.dishModel = dishModel;
        
        this.menuService = new MenuService(this.menuModel, this.menuDetailModel);
        this.categoryService = new CategoryService(this.categoryModel);
        this.dishesService = new DishService(this.dishModel);
        
        this.dateFilter = new DateFilterPanel(menuInfoView.startDatePanel, menuInfoView.endDatePanel);
        this.inputReader = new InputReader(view, menuInfoView, menuCreateView, dateFilter);
        this.menuValidator = new MenuValidator(modal);
        this.elements = new ViewElements(view, menuInfoView);
        this.load = new LoadInformation(menuCreateView, menuDetailView);
        this.dishesList = new DishesList(menuCreateView);
        this.dishesTableRefresher = new MenuDishesRefresher(menuCreateView, categoryService);
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
        
        dishesList.setOnDelete(dish -> removeDishOfLIst(dish));
        
        TableRowClickHelper.addRowClickListener(menuCreateView.dishesTable, row -> addDishToList(row));
    }
    
    private void restartView() {
        elements.resetComboBoxes();
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
    }
    
    private void openMenuInfoWindow() {
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
        dishesList.clearList();
        menuInfoView.dispose();
        menuCreateView.dispose();
    }
    
    private void addDishToList( int rowSelected ) {
        int dishId = Integer.parseInt(menuCreateView.dishesTable.getValueAt(rowSelected, 0).toString());
        Dish dishSelected = dishesService.getDishById(dishId);
        
        dishesList.addDish(dishSelected);
    }
    
    private void removeDishOfLIst(Dish dish) {
        int dishId = dish.getDishID();
        dishesList.removeDish(dishId);
    }
    
    private void saveMenu() {
        if ( dishesList.getDishList().isEmpty() ) {
            modal.show("No es posible crear un menú sin platillos. Elige algunos", ModalTypeEnum.error);
            return;
        }
        
        if ( modal.confirm("¿Desea confirma el registro menú?") != 0 ) return;
        
        Menu newMenu = menuService.saveMenu(menu);
        
        if ( newMenu == null ) {
            modal.show("Hubo un problema al crear el menú", ModalTypeEnum.error);
            return;
        }
        
        if ( !saveMenuDetail(newMenu.getMenuId()) ) {
            modal.show("Error al guardar el detalle de menú", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El menú ha sido creado exisitosamente", ModalTypeEnum.success);
        dishesList.clearList();
        menuCreateView.dispose();
        menuInfoView.dispose();
        menuGrid.showMenus(menuService.getAllMenus(1, QUANTITY_ITEMS_GRID));
        safelyRebuildPagination();
    }
    
    private boolean saveMenuDetail(int menuId) {
        List<Dish> dishes = dishesList.getDishList();
        
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
        load.leadMenuDetailName(menuSelected.getMenuName());
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

}
