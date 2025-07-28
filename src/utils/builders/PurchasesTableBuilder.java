package utils.builders;

import entities.Purchase;
import entities.Supplier;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.SupplierService;

public class PurchasesTableBuilder {
    
    public static DefaultTableModel create(List<Purchase> purchases, SupplierService supplierService) {

        String[] columnsTable = {"Id", "Código", "Total", "Fecha", "Proveedor"};

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
                    case 3 -> String.class;  
                    default -> Object.class;
                };
            }
        };

        for (Purchase purchase : purchases) {
            Object[] rowTable = new Object[5];
            rowTable[0] = purchase.getPurchaseId();
            rowTable[1] = purchase.getPurchaseCode();
            rowTable[2] = "$" + String.format("%.2f", purchase.getPurchaseTotal());
            rowTable[3] = purchase.getPurchaseDate();
            Supplier supplier = supplierService.getById(purchase.getSupplierId());
            rowTable[4] = supplier.getSupplierName() + " " + supplier.getSupplierLastname();

            table.addRow(rowTable);
        }

        return table;
    }
    
}
