package controllers.menu.helpers;

import entities.Dish;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.CategoryService;
import utils.builders.DishesMenuTableBuilder;
import views.warehouse.WarehouseMenuCreate;

public class MenuDishesRefresher {
    
    private final WarehouseMenuCreate createMenuView;
    private final CategoryService categoryService;

    public MenuDishesRefresher(
            WarehouseMenuCreate createMenuView,
            CategoryService categoryService
    ) {
        this.createMenuView = createMenuView;
        this.categoryService = categoryService;
    }
    
    public void load(List<Dish> dishes) {
        DefaultTableModel table = buildTableModel(dishes);
        setTableModel(table);
        setRowSorter(new TableRowSorter<>(table));
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
}
