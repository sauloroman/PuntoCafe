package utils.builders;

import entities.Sale;
import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class SalesTableBuilder {

    public static DefaultTableModel create(List<Sale> sales, User user) {

        String[] columnsTable = {"Id", "Código", "Total", "Fecha", "Usuario"};

        DefaultTableModel table = new DefaultTableModel(columnsTable, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0, 2 -> String.class;
                    case 1 -> String.class; 
                    case 3 -> User.class;  
                    default -> Object.class;
                };
            }
        };

        for (Sale sale : sales) {
            Object[] rowTable = new Object[5];
            rowTable[0] = sale.getSaleId();
            rowTable[1] = sale.getSaleCode();
            rowTable[2] = "$" + String.format("%.2f", sale.getTotal());
            rowTable[3] = sale.getSaleDate();
            rowTable[4] = user;

            table.addRow(rowTable);
        }

        return table;
    }

}
