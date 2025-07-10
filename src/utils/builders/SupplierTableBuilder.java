package utils.builders;

import entities.Supplier;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import utils.helpers.Formatter;

public class SupplierTableBuilder {
    
     public static DefaultTableModel create(List<Supplier> suppliers) {
        String[] columnsTable = {"Id", "Nombre", "Apellido", "Compañia", "Teléfono", "Email", "Dirección", "Fecha de creación", "Fecha de actualización", "Estatus"};
        DefaultTableModel table = new DefaultTableModel(null, columnsTable);
        String[] rowTable = new String[10];
        
        for( Supplier supplier: suppliers ) {  
            String supplierStatus = supplier.getSupplierIsActive() ? "Activo" : "Inactivo";
            rowTable[0] = String.valueOf(supplier.getSupplierId());
            rowTable[1] = supplier.getSupplierName();
            rowTable[2] = supplier.getSupplierLastname();
            rowTable[3] = supplier.getSupplierCompany();
            rowTable[4] = supplier.getSupplierPhone();
            rowTable[5] = supplier.getSupplierEmail();
            rowTable[6] = supplier.getSupplierAddress();
            Date supplierCreatedAt = supplier.getSupplierCreatedAt();
            rowTable[7] = Formatter.formatDate(supplierCreatedAt);
            Date supplierUpdatedAt = supplier.getSupplierUpdatedAt();
            rowTable[8] = Formatter.formatDate(supplierUpdatedAt);
            rowTable[9] = supplierStatus;
            table.addRow(rowTable);
        }
        
        return table;
    }
    
}
