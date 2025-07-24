package utils.builders;

import entities.Sale;
import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.UserService;

public class SalesTableBuilder {
    
    public static DefaultTableModel create(List<Sale> sales, UserService userService) {
        
        String[] columnsTable = {"Código", "Total", "Fecha", "Usuario"};
        DefaultTableModel table = new DefaultTableModel(null, columnsTable){
            @Override
            public boolean isCellEditable( int row, int column ) {
                return false;
            }
        };
        
        String[] rowTable = new String[4];
        
        for( Sale sale: sales ) {
            rowTable[0] = sale.getSaleCode();
            rowTable[1] = "$" + String.format("%.2f", sale.getTotal());
            rowTable[2] = sale.getSaleDate();
            
            User user = userService.getUserById(sale.getUserId());
            rowTable[3] = user.getUserName() + " " + user.getUserLastname();
            table.addRow(rowTable);
        }
        
        return table;
    }
    
}
