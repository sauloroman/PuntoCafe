package controllers.purchase.helpers;

import entities.Purchase;
import entities.PurchaseDetail;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.ProductService;
import services.SupplierService;
import utils.builders.PurchasesTableBuilder;
import views.purchases.PurchasesBuy;
import views.purchases.PurchasesDetail;

public class PurchasesRefresher {
    
    private final PurchasesBuy view;
    private final PurchasesDetail detailView;
    private final SupplierService supplierService;
    private final ProductService productService;

    public PurchasesRefresher(PurchasesBuy view, PurchasesDetail detailView, SupplierService supplierService, ProductService productService) {
        this.view = view;
        this.detailView = detailView;
        this.supplierService = supplierService;
        this.productService = productService;
    }
    
    public void load(List<Purchase> purchases) {
        DefaultTableModel tableModel = buildTableModel(purchases);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }
    
    public void loadProductDetailTable(List<PurchaseDetail> detail) {
        DefaultTableModel tableModel = buildProductPurchaseTableModel(detail);
        setPurchaseDetailTableModel(tableModel);
        setPurchaseDetailRowSorter(new TableRowSorter<>(tableModel));
    }
    
    private DefaultTableModel buildTableModel(List<Purchase> purchases) {
        return PurchasesTableBuilder.create(purchases, supplierService);
    }
    
    private DefaultTableModel buildProductPurchaseTableModel(List<PurchaseDetail> detail) {
        return PurchasesTableBuilder.createProductDetail(detail, productService);
    }
    
    private void setTableModel(DefaultTableModel model) {
        view.purchasesTable.setModel(model);
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.purchasesTable.setRowSorter(sorter);
    }
    
    private void setPurchaseDetailTableModel(DefaultTableModel model) {
        detailView.productsTable.setModel(model);
    }
    
    private void setPurchaseDetailRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        detailView.productsTable.setRowSorter(sorter);
    }
}
