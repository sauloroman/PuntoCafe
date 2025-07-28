package controllers.purchase.helpers;

import entities.Purchase;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.SupplierService;
import utils.builders.PurchasesTableBuilder;
import utils.builders.UserRoleBadgeCellRenderer;
import views.purchases.PurchasesBuy;

public class PurchasesRefresher {
    
    private final PurchasesBuy view;
    private final SupplierService supplierService;

    public PurchasesRefresher(PurchasesBuy view, SupplierService supplierService) {
        this.view = view;
        this.supplierService = supplierService;
    }
    
    public void load(List<Purchase> purchases) {
        DefaultTableModel tableModel = buildTableModel(purchases);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }
    
    private DefaultTableModel buildTableModel(List<Purchase> purchases) {
        return PurchasesTableBuilder.create(purchases, supplierService);
    }
    
    private void setTableModel(DefaultTableModel model) {
        view.purchasesTable.setModel(model);
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.purchasesTable.setRowSorter(sorter);
    }
    
}
