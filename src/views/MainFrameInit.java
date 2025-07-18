package views;

import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;

public class MainFrameInit {
    
    private final MainFrame view; 
    private final String COLOR_SIDE_BAR = ViewConstants.mainColor;
    private final String COLOR_SETTINGS_BTN = "#f9f9f9";
    private final Button buttonGenerator  = new Button();
    private final ImageCustom imageGenerator = new ImageCustom();

    public MainFrameInit(MainFrame view) {
        this.view = view;
    }
    
    public void init() {
        view.setExtendedState(MAXIMIZED_BOTH);
        view.setTitle("PuntoCafé - Sistema de control de inventario y registro de ventas");
        view.header.setVisible(true);
        view.header.setBackground(Color.WHITE);
        
        imageGenerator.addImageFix(view.boxLogo, "logo-3", 200, 200);
        view.sidebar.setBackground(Color.decode(COLOR_SIDE_BAR));
        
        buttonGenerator.solidButton(view.btnLogout, ViewConstants.blackColor, "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnLogout, "icon-logout", 20);
        buttonGenerator.solidButton(view.btnSettings, COLOR_SETTINGS_BTN, "#121615", 11);
        buttonGenerator.addIcon(view.btnSettings, "icon-cog", 20);
        
        buttonGenerator.solidButton(view.btnWarehouse, ViewConstants.mainColor, ViewConstants.whiteColor, 14);
        buttonGenerator.solidButton(view.btnPurchases, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnSales, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnAccess, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        buttonGenerator.solidButton(view.btnQueries, ViewConstants.mainColor, ViewConstants.whiteColor, 14 );
        
        buttonGenerator.addIcon(view.btnWarehouse, "icon-box", 24);
        buttonGenerator.addIcon(view.btnPurchases, "icon-bag", 24);
        buttonGenerator.addIcon(view.btnSales, "icon-coins", 24);
        buttonGenerator.addIcon(view.btnAccess, "icon-key", 24);
        buttonGenerator.addIcon(view.btnQueries, "icon-document", 24);
        
        buttonGenerator.addLeftPadding(view.btnWarehouse, 50);
        buttonGenerator.addLeftPadding(view.btnPurchases, 50);
        buttonGenerator.addLeftPadding(view.btnSales, 50);
        buttonGenerator.addLeftPadding(view.btnAccess, 50);
        buttonGenerator.addLeftPadding(view.btnQueries, 50);
        
        view.mainPanel.setSize( 900, 900 );
    }
}
