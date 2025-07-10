package utils.builders;

import entities.Category;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.helpers.Formatter;

public class CategoryTableBuilder {
    
    public static DefaultTableModel create( List<Category> categories ) {
        String[] columnsTable = {"Id", "Nombre", "Descripción", "Tipo", "Fecha de creación", "Última actualización", "Estado"};
        DefaultTableModel table = new DefaultTableModel(null, columnsTable);
        
        String[] rowTable = new String[7];
        
        for(Category category: categories) {
            String categoryStatus = category.getIsActive() ? "Activo" : "Inactivo";
            rowTable[0] = String.valueOf(category.getCategoryId());
            rowTable[1] = category.getCategoryName();
            rowTable[2] = category.getCategoryDescription();
            rowTable[3] = category.getCategoryType();
            Date categoryCreatedAt = category.getCategoryCreatedAt();
            rowTable[4] = Formatter.formatDate(categoryCreatedAt);
            Date categoryUpdatedAt = category.getCategoryUpdatedAt();
            rowTable[5] = Formatter.formatDate(categoryUpdatedAt);
            rowTable[6] = categoryStatus;
            table.addRow(rowTable);
        }
        
        return table;
    }
    
}
