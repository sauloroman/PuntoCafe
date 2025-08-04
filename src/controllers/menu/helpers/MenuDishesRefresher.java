package controllers.menu.helpers;

import entities.Dish;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.CategoryService;
import utils.builders.DishesMenuTableBuilder;
import views.warehouse.WarehouseMenuCreate;
import views.warehouse.WarehouseMenuEdit;

public class MenuDishesRefresher {
    
    private final WarehouseMenuCreate createMenuView;
    private final WarehouseMenuEdit editMenuView;
    private final CategoryService categoryService;

    public MenuDishesRefresher(
            WarehouseMenuCreate createMenuView,
            WarehouseMenuEdit editMenuView,
            CategoryService categoryService
    ) {
        this.createMenuView = createMenuView;
        this.editMenuView = editMenuView;
        this.categoryService = categoryService;
    }
    
    public void load(List<Dish> dishes) {
        DefaultTableModel table = buildTableModel(dishes);
        setTableModel(table);
        setRowSorter(new TableRowSorter<>(table));
    }
    
    public void loadInEditWindow(List<Dish> dishes) {
        DefaultTableModel table = buildTableModel(dishes);
        setTableModelEdit(table);
        setRowSorterEdit(new TableRowSorter<>(table));
    }
    
    private DefaultTableModel buildTableModel(List<Dish> dishes) {
        return DishesMenuTableBuilder.create(dishes, categoryService);
    }
    
    private void setTableModel(DefaultTableModel model) {
        createMenuView.dishesTable.setModel(model);
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        createMenuView.dishesTable.setRowSorter(sorter);
    }
    
    private void setTableModelEdit(DefaultTableModel model) {
        editMenuView.dishesTable.setModel(model);
    }
    
    private void setRowSorterEdit(TableRowSorter<DefaultTableModel> sorter) {
        editMenuView.dishesTable.setRowSorter(sorter);
    }
    
}
