package views.sales;

import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Table;

public class SalesSellerInit {
    
    private final SalesSeller view;
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 800;
    private final Button buttonGenerator = new Button(); 
    
    public SalesSellerInit(SalesSeller view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        Table.tableStyle3(view.salesTable);
        buttonGenerator.solidButton(view.btnNewSale, ViewConstants.skyColor, "#FFFFFF", 14);
        buttonGenerator.addIcon(view.btnNewSale, "icon-plus-white", 20);
    }
    
}
