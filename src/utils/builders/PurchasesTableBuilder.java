package utils.builders;

import entities.Purchase;
import entities.PurchaseDetail;
import entities.Supplier;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.ProductService;
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
    
    public static DefaultTableModel createProductDetail( List<PurchaseDetail> detail, ProductService productService ) {
        
        String[] columnsTable = {"Id", "Producto", "Cantidad", "Precio De Compra", "Subtotal"};
        
        DefaultTableModel table = new DefaultTableModel(columnsTable, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] rowTable = new String[5];
        
        for( PurchaseDetail item: detail ) {
            rowTable[0] = String.valueOf(item.getProductId());
            rowTable[1] = productService.getProductById(item.getProductId()).getProductName();
            rowTable[2] = String.valueOf(item.getPurchaseDetailQuantity());
            rowTable[3] = "$" + String.format("%.2f", item.getPurchaseDetailUnitPrice());
            double subtotal = item.getPurchaseDetailUnitPrice() * item.getPurchaseDetailQuantity();
            rowTable[4] = "$" + String.format("%.2f", subtotal);
            table.addRow(rowTable);
        }
        
        return table;
    }
    
}
