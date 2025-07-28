package controllers.purchase.helpers;

import entities.Product;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.builders.PurchaseProductsTableBuilder;
import views.purchases.PurchasesCreateBuy;

public class PurchaseProductRefresher {
    
    private final PurchasesCreateBuy view;
    
    public PurchaseProductRefresher(PurchasesCreateBuy view) {
        this.view = view;
    }
    
    public void load(List<Product> products) {
        DefaultTableModel tableModel = buildTableModel(products);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }
    
    private DefaultTableModel buildTableModel(List<Product> products) {
        return PurchaseProductsTableBuilder.create(products);
    }
    
    private void setTableModel(DefaultTableModel model) {
        view.productsTable.setModel(model);
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.productsTable.setRowSorter(sorter);
    }
    
}
