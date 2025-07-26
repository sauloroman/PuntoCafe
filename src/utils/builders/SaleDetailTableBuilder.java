package utils.builders;

import entities.SaleDishDetail;
import entities.SaleProductDetail;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.DishService;
import services.ProductService;

public class SaleDetailTableBuilder {
    
    public static DefaultTableModel createProductDetail( List<SaleProductDetail> detail, ProductService productService ) {
        
        String[] columnsTable = {"Id", "Producto", "Cantidad", "Precio Unitario", "Descuento", "Subtotal"};
        
        DefaultTableModel table = new DefaultTableModel(columnsTable, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] rowTable = new String[6];
        
        for( SaleProductDetail item: detail ) {
            rowTable[0] = String.valueOf(item.getProductId());
            rowTable[1] = productService.getProductById(item.getProductId()).getProductName();
            rowTable[2] = String.valueOf(item.getSaleProductDetailQuantity());
            rowTable[3] = "$" + String.format("%.2f", item.getSaleProductDetailUnitPrice());
            rowTable[4] = "$" + String.format("%.2f", item.getSaleProductDetailDiscount());
            double subtotal = (item.getSaleProductDetailUnitPrice() * item.getSaleProductDetailQuantity()) - item.getSaleProductDetailDiscount();
            rowTable[5] = "$" + String.format("%.2f", subtotal);
            table.addRow(rowTable);
        }
        
        return table;
    }
    
    public static DefaultTableModel createDishDetail( List<SaleDishDetail> detail, DishService dishService ) {
        
        String[] columnsTable = {"Id", "Platillo", "Cantidad", "Precio Unitario", "Descuento", "Subtotal"};
        
        DefaultTableModel table = new DefaultTableModel(columnsTable, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] rowTable = new String[6];
        
        for( SaleDishDetail item: detail ) {
            rowTable[0] = String.valueOf(item.getDishId());
            rowTable[1] = dishService.getDishById(item.getDishId()).getDishName();
            rowTable[2] = String.valueOf(item.getSaleDishDetailQuantity());
            rowTable[3] = "$" + String.format("%.2f", item.getSaleDishDetailUnitPrice());
            rowTable[4] = "$" + String.format("%.2f", item.getSaleDishDetailDiscount());
            double subtotal = (item.getSaleDishDetailUnitPrice() * item.getSaleDishDetailQuantity()) - item.getSaleDishDetailDiscount();
            rowTable[5] = "$" + String.format("%.2f", subtotal);
            table.addRow(rowTable);
        }
        
        return table;
    }
    
}
