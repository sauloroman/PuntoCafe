package views.queries;

import javax.swing.WindowConstants;
import views.components.Input;

public class ProductsLowRotationInit {
    
    private final ProductsLowRotation view;
    private final Input inputGenerator = new Input();
    
    public ProductsLowRotationInit(ProductsLowRotation view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        inputGenerator.roundedComboBox(view.quantityCombo, "#DDDDDD", 10);
    }
    
}
