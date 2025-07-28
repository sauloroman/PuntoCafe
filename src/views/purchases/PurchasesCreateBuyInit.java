package views.purchases;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.components.Table;

public class PurchasesCreateBuyInit {
    
    private final PurchasesCreateBuy view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();
    
    public PurchasesCreateBuyInit(PurchasesCreateBuy view) {
        this.view = view;
    }
    
    public void init() {
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        Table.tableStyle3(view.productsTable);
        
        buttonGenerator.solidButton(view.btnSearch, ViewConstants.blackColor, "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnSearch, "icon-search", 16);
        buttonGenerator.solidButton(view.btnSavePurchase, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnSavePurchase, "icon-save", 16);
        
        inputGenerator.roundedComboBox(view.filterSupplier, "#DDDDDD", 10);
        inputGenerator.roundedField(view.searchProductTxt, "#dddddd", 10, "Buscar productos por nombre");
        
        imageGenerator.addImageFix(view.iconRh, "logo-rh", 40, 40);
    
        view.productsInPurchase.setLayout(new BoxLayout(view.productsInPurchase, BoxLayout.Y_AXIS));
        view.productsInPurchase.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        
        JScrollPane scroll = new JScrollPane(view.productsInPurchase);
        scroll.setPreferredSize(new Dimension(300, 430));
        
        view.productsInPurchaseParent.setLayout(new BorderLayout());
        view.productsInPurchaseParent.add(scroll, BorderLayout.CENTER);
        
        scroll.setBorder(null);
        view.productsInPurchaseParent.setBorder(null);
        
    }
    
}
