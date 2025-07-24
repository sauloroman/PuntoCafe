package controllers.sale.helpers;

import entities.Sale;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.SaleService;
import services.UserService;
import utils.builders.SalesTableBuilder;
import views.sales.Sales;

public class SaleRefresher {
    
    private final Sales view;
    private final SaleService saleService;
    private final UserService userService;

    public SaleRefresher(Sales view, SaleService saleService, UserService userService) {
        this.view = view;
        this.saleService = saleService;
        this.userService = userService;
    }
    
    public void loadPage( int userId, String startDate, String endDate ) {
        List<Sale> sales = saleService.getSales(userId, startDate, endDate);
        DefaultTableModel tableModel = buildTableModel(sales);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }
    
    private DefaultTableModel buildTableModel(List<Sale> sales) {
        return SalesTableBuilder.create(sales, userService);
    }
    
    private void setTableModel(DefaultTableModel model) {
        view.salesTable.setModel(model);
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.salesTable.setRowSorter(sorter);
    }
}
