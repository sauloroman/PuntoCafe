package views.queries;

import javax.swing.WindowConstants;

public class ProductsHighestRetributionInit {
    
    private final ProductsHighestRetribution view;

    public ProductsHighestRetributionInit(ProductsHighestRetribution view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
    
}
