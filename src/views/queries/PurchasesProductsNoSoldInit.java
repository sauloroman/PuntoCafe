package views.queries;

import javax.swing.WindowConstants;

public class PurchasesProductsNoSoldInit {
    
    private final PurchasesProductsNoSold view;

    public PurchasesProductsNoSoldInit(PurchasesProductsNoSold view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
    
}
