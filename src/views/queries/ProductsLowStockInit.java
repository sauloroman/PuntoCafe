package views.queries;

import javax.swing.WindowConstants;

public class ProductsLowStockInit {
    
    private final ProductsLowStock view;

    public ProductsLowStockInit(ProductsLowStock view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
    
}
