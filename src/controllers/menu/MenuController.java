package controllers.menu;

import controllers.menu.helpers.DishesList;
import controllers.menu.helpers.InputReader;
import controllers.menu.helpers.LoadInformation;
import controllers.menu.helpers.MenuDishesRefresher;
import controllers.menu.helpers.MenuValidator;
import controllers.menu.helpers.ViewElements;
import entities.Dish;
import entities.Menu;
import models.CategoryModel;
import models.DishModel;
import models.MenuDetailModel;
import models.MenuModel;
import services.CategoryService;
import services.DishService;
import utils.helpers.DateFilterPanel;
import utils.helpers.Modal;
import utils.helpers.TableRowClickHelper;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuInfo;
import views.warehouse.WarehouseMenus;

public class MenuController {
    
    private final WarehouseMenus view;
    private final WarehouseMenuInfo menuInfoView;
    private final WarehouseMenuCreate menuCreateView;
    
    private final MenuModel menuModel;
    private final MenuDetailModel menuDetailModel;
    private final CategoryModel categoryModel;
    private final DishModel dishModel;
    
    private final CategoryService categoryService;
    private final DishService dishesService;
    
    private final DateFilterPanel dateFilter;
    private final InputReader inputReader;
    private final MenuValidator menuValidator;
    private final ViewElements elements;
    private final LoadInformation load;
    private final MenuDishesRefresher dishesTableRefresher;
    private final DishesList dishesList;
    private final Modal modal = new Modal("Menús del sistema - PuntoCafé");
    
    private Menu menu = null;
    
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
        
        this.menuModel = menuModel;
        this.menuDetailModel = menuDetailModel;
        this.categoryModel = categoryModel;
        this.dishModel = dishModel;
        
        this.categoryService = new CategoryService(this.categoryModel);
        this.dishesService = new DishService(this.dishModel);
        
        this.dateFilter = new DateFilterPanel(menuInfoView.startDatePanel, menuInfoView.endDatePanel);
        this.inputReader = new InputReader(menuInfoView, menuCreateView, dateFilter);
        this.menuValidator = new MenuValidator(modal);
        this.elements = new ViewElements(menuInfoView);
        this.load = new LoadInformation(menuCreateView);
        this.dishesList = new DishesList(menuCreateView);
        this.dishesTableRefresher = new MenuDishesRefresher(menuCreateView, categoryService);
        
        initListeners();
    }
    
    private void initListeners() {
        view.btnCreateMenu.addActionListener(e -> openMenuInfoWindow());
        
        menuInfoView.btnCreateMenu.addActionListener(e -> openMenuDetailWindow());
        menuInfoView.btnCancelCreateMenu.addActionListener(e -> closeMenuInfoWindow());
        
        menuCreateView.btnSearch.addActionListener(e -> filterDishesByName());
        menuCreateView.btnCancelSaveMenu.addActionListener(e -> cancelCreateMenu());
        dishesList.setOnDelete(dish -> removeDishOfLIst(dish));
        
        TableRowClickHelper.addRowClickListener(menuCreateView.dishesTable, row -> addDishToList(row));
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
        load.loadCreateMenuInformation(menuName);
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
    
}
