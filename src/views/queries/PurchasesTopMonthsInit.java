package views.queries;

import javax.swing.WindowConstants;

public class PurchasesTopMonthsInit {
    
    private final PurchasesTopMonths view;

    public PurchasesTopMonthsInit(PurchasesTopMonths view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
}
