package views.purchases;

import java.awt.Color;
import javax.swing.BorderFactory;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.components.Table;

public class PurchasesBuyInit {
    
    private final PurchasesBuy view;
    private final int PANEL_WIDTH = 1320;
    private final int PANEL_HEIGHT = 800;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();
    private final ImageCustom imageGenerator = new ImageCustom();

    
    public PurchasesBuyInit(PurchasesBuy view) {
        this.view = view;
    }
    
    public void init() {
        Table.tableStyle3(view.purchasesTable);
        view.scrollPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#DDDDDD"))); 
        view.setVisible(true);
        view.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        
        buttonGenerator.solidButton(view.btnReload, "#FFFFFF", ViewConstants.textBtn, 12);
        buttonGenerator.addIcon(view.btnReload, "icon-reload", 16);
        buttonGenerator.solidButton(view.btnNewBuy, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNewBuy, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnFilter, ViewConstants.blackColor, "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnFilter, "icon-search", 16);
        
        imageGenerator.addImageFix(view.iconTicket, "icon-ticket", 25, 25);
        imageGenerator.addImageFix(view.iconCoin, "icon-money", 25, 25);
        imageGenerator.addImageFix(view.iconArrow, "icon-avg", 25, 25);
        imageGenerator.addImageFix(view.iconSupplier, "icon-supplier", 25, 25);
        imageGenerator.addImageFix(view.iconInfo, "icon-info-white", 15, 15);
        imageGenerator.addImageFix(view.iconInfo1, "icon-info-black", 15, 15);
        imageGenerator.addImageFix(view.iconInfo2, "icon-info-black", 15, 15);
        imageGenerator.addImageFix(view.iconInfo3, "icon-info-black", 15, 15);
        
        inputGenerator.roundedComboBox(view.filterSupplier, "#DDDDDD", 10);        
    }
    
}
