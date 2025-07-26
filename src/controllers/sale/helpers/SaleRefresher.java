package controllers.sale.helpers;

import entities.Dish;
import entities.Product;
import entities.Sale;
import entities.SaleDishDetail;
import entities.SaleProductDetail;
import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.DishService;
import services.ProductService;
import utils.builders.SaleDetailTableBuilder;
import utils.builders.SalesTableBuilder;
import utils.builders.UserRoleBadgeCellRenderer;
import views.sales.SaleDetail;
import views.sales.Sales;

public class SaleRefresher {
    
    private final User user;
    private final Sales view;
    private final SaleDetail detailView;
    private final ProductService productService;
    private final DishService dishService;

    public SaleRefresher(
            User user,
            Sales view, 
            SaleDetail detailView,
            ProductService productService,
            DishService dishService
    ) {
        this.user = user;
        this.view = view;
        this.detailView = detailView;
        this.productService = productService;
        this.dishService = dishService;
    }
    
    public void load( List<Sale> sales) {
        DefaultTableModel tableModel = buildTableModel(sales, user);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }
    
    public void loadProductDetailTable(List<SaleProductDetail> detail) {
        DefaultTableModel tableModel = buildProductSaleDetail(detail);
        setSaleProductDetailTableModel( tableModel );
        setSaleProductDetailRowSorter(new TableRowSorter<>(tableModel));
    }
    
     public void loadDishDetailTable(List<SaleDishDetail> detail) {
        DefaultTableModel tableModel = buildDishSaleDetail(detail);
        setSaleDishDetailTableModel( tableModel );
        setSaleDishDetailRowSorter(new TableRowSorter<>(tableModel));
    }
    
    private DefaultTableModel buildTableModel(List<Sale> sales, User user) {
        return SalesTableBuilder.create(sales, user);
    }
    
    private DefaultTableModel buildProductSaleDetail(List<SaleProductDetail> detail) {
        return SaleDetailTableBuilder.createProductDetail(detail, productService);
    }
    
    private DefaultTableModel buildDishSaleDetail(List<SaleDishDetail> detail) {
        return SaleDetailTableBuilder.createDishDetail(detail, dishService);
    }
    
    private void setTableModel(DefaultTableModel model) {
        view.salesTable.setModel(model);
        view.salesTable.getColumnModel().getColumn(4).setCellRenderer(new UserRoleBadgeCellRenderer());
    }
    
    private void setSaleProductDetailTableModel(DefaultTableModel model) {
        detailView.productsTable.setModel(model);
    }
    
    private void setSaleDishDetailTableModel(DefaultTableModel model) {
        detailView.dishesTable.setModel(model);
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.salesTable.setRowSorter(sorter);
    }
    
    private void setSaleProductDetailRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        detailView.productsTable.setRowSorter(sorter);
    }
    
    private void setSaleDishDetailRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        detailView.dishesTable.setRowSorter(sorter);
    }
}
