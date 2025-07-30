package views.queries;

import javax.swing.WindowConstants;

public class ProductsMostSoldInit {

    private final ProductsMostSold view;

    public ProductsMostSoldInit(ProductsMostSold view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
    }
    
}
