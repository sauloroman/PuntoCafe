package views.queries;

import javax.swing.WindowConstants;

public class PurchasesTopMonthsSalesInit {
    
    private final PurchasesTopMonthsSales view;

    public PurchasesTopMonthsSalesInit(PurchasesTopMonthsSales view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
    
}
