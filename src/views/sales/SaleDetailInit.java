package views.sales;

import entities.User;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Table;

public class SaleDetailInit {
    
    private final User user;
    private final SaleDetail view;
    private final Button buttonGenerator = new Button();

    public SaleDetailInit(SaleDetail view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        Table.tableStripedStyle(view.productsTable);
        Table.tableStripedStyle(view.dishesTable);
        
        buttonGenerator.outlineButton(view.btnExport, "#DDDDDD", ViewConstants.blackColor);
        buttonGenerator.addIcon(view.btnExport, "icon-print", 20);
        
        view.setResizable(false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        hideElementsDependingRole();
    }
    
    private void hideElementsDependingRole() {
        if ( user.getRoleId() == 3 ) {
            view.btnExport.setVisible(false);
            view.btnExport.setSize(0, 0);
        }
    }
    
}
