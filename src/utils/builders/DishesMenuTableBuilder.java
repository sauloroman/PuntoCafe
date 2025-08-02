package utils.builders;

import entities.Dish;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.CategoryService;

public class DishesMenuTableBuilder {
    
    public static DefaultTableModel create( List<Dish> dishes, CategoryService categoryService ) {
        String[] columnsTable = {"Id", "Platillo", "Categoría", "Fecha de creación"};
        DefaultTableModel table = new DefaultTableModel(null, columnsTable){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] rowTable = new String[4];
        
        for(Dish dish: dishes) {
            rowTable[0] = String.valueOf(dish.getDishID());
            rowTable[1] = dish.getDishName();
            rowTable[2] = categoryService.getById(dish.getCategoryId()).getCategoryName();
            rowTable[3] = String.valueOf(dish.getDishCreatedAt());
            
            table.addRow(rowTable);
        }
        
        return table;
    }
    
}
