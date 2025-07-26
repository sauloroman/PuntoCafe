package views.sales;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Table;

public class SaleDetailInit {
    
    private final SaleDetail view;
    private final Button buttonGenerator = new Button();

    public SaleDetailInit(SaleDetail view) {
        this.view = view;
    }
    
    public void init() {
        Table.tableStripedStyle(view.productsTable);
        Table.tableStripedStyle(view.dishesTable);
        
        buttonGenerator.outlineButton(view.btnExport, "#DDDDDD", ViewConstants.blackColor);
        buttonGenerator.addIcon(view.btnExport, "icon-print", 20);
        
        view.setResizable(false);
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    
}
