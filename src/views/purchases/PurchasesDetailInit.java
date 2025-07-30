package views.purchases;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.Table;

public class PurchasesDetailInit {
    
    private final PurchasesDetail view;
    private final Button buttonGenerator = new Button(); 
    
    public PurchasesDetailInit(PurchasesDetail view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        Table.tableStripedStyle(view.productsTable);

        buttonGenerator.outlineButton(view.btnExport, "#DDDDDD", ViewConstants.blackColor);
        buttonGenerator.addIcon(view.btnExport, "icon-print", 20);
        
    }
    
}
