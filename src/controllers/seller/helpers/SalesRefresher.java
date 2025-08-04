package controllers.seller.helpers;

import entities.Sale;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.UserService;
import utils.builders.SalesTableBuilder;
import utils.builders.UserRoleBadgeCellRenderer;
import views.sales.SalesSeller;

public class SalesRefresher {
    
    private final SalesSeller view;
    private final UserService userService;

    public SalesRefresher(SalesSeller view, UserService userService) {
        this.view = view;
        this.userService = userService;
    }
    
    public void load( List<Sale> sales) {
        DefaultTableModel tableModel = buildTableModel(sales);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }
    
    private DefaultTableModel buildTableModel(List<Sale> sales) {
        return SalesTableBuilder.create(sales, userService);
    }

    private void setTableModel(DefaultTableModel model) {
        view.salesTable.setModel(model);
        view.salesTable.getColumnModel().getColumn(4).setCellRenderer(new UserRoleBadgeCellRenderer());
    }
    
    private void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.salesTable.setRowSorter(sorter);
    }
}
