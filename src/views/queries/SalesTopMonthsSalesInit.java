package views.queries;

import javax.swing.WindowConstants;

public class SalesTopMonthsSalesInit {
    
    private final SalesTopMonthsSales view;

    public SalesTopMonthsSalesInit(SalesTopMonthsSales view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
    
}
