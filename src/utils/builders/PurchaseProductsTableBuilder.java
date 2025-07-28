package utils.builders;

import entities.Product;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PurchaseProductsTableBuilder {
    
    public static DefaultTableModel create(List<Product> products) {
        
        String[] columnsTable = {"Producto", "Precio de venta", "Stock", "Stock Min"};
        DefaultTableModel table = new DefaultTableModel(null, columnsTable){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
         String[] rowTable = new String[4];
        
        for(Product product: products) {
            rowTable[0] = product.getProductName();
            rowTable[1] = "$" + String.format("%.2f", product.getProductSellingPrice());
            rowTable[2] = String.valueOf(product.getProductStock());
            rowTable[3] = String.valueOf(product.getProductStockMin());
            
            table.addRow(rowTable);
        }
        
        return table;
        
    }
    
}
