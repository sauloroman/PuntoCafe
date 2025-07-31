package views.queries;

import javax.swing.WindowConstants;
import views.components.Input;

public class PurchasesMontlyGrowInit {
    
    private final PurchasesMontlyGrow view;
    private final Input inputGenerator = new Input();

    public PurchasesMontlyGrowInit(PurchasesMontlyGrow view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        inputGenerator.roundedComboBox(view.quantityCombo, "#DDDDDD", 10);
    }
    
}
