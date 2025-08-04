package views.queries;

import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class QueriesInit {
    
    private final Queries view;
    private final int WINDOW_WIDTH = 1320;
    private final int WINDOW_HEIGHT = 800;
    private final Button buttonGenerator = new Button();
    private final Input inputGenerator = new Input();
    private final ImageCustom imageGenerator = new ImageCustom();

    public QueriesInit(Queries view) {
        this.view = view;
    }
    
    public void init() {
        view.setVisible(true);
        view.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        inputGenerator.roundedComboBox(view.timeBox, "#DDDDDD", 10);
        
        imageGenerator.addImageFix(view.iconCoin, "icon-money", 25, 25);
        imageGenerator.addImageFix(view.iconGrow, "icon-increase", 25, 25);
        imageGenerator.addImageFix(view.iconTopProduct, "icon-top", 25, 25);
        imageGenerator.addImageFix(view.iconTopUser, "icon-top-seller", 25, 25);
        imageGenerator.addImageFix(view.iconInfo, "icon-info-white", 15, 15);
        imageGenerator.addImageFix(view.iconInfo1, "icon-info-black", 15, 15);
        imageGenerator.addImageFix(view.iconInfo2, "icon-info-black", 15, 15);
        imageGenerator.addImageFix(view.iconInfo3, "icon-info-black", 15, 15);
        
        buttonGenerator.solidButton(view.btnLoadInfo, ViewConstants.blackColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnLoadInfo, "icon-reload", 16);
        
        buttonGenerator.outlineButton(view.btnProductsEarn, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnProductsLowRotation, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnProductsLowStock, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnProductsSold, ViewConstants.skyColor, ViewConstants.textBtn);
        
        buttonGenerator.outlineButton(view.btnGrowAvgMonth, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnGrowBestMonths, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnGrowMontly, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnGrowMostQuantity, ViewConstants.skyColor, ViewConstants.textBtn);
        
        buttonGenerator.outlineButton(view.btnPurchasesBestMonths, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnPurchasesNoSold, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnPurchasesSuppliers, ViewConstants.skyColor, ViewConstants.textBtn);
        buttonGenerator.outlineButton(view.btnPurchasesTime, ViewConstants.skyColor, ViewConstants.textBtn);
    }
    
}
