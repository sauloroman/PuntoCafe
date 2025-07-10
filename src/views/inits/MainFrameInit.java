package views.inits;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import utils.constants.ViewConstants;
import views.MainFrame;
import views.components.Button;
import views.components.ImageCustom;

public class MainFrameInit {
    
    private final MainFrame view; 
    private final String COLOR_LOGOUT_BTN = ViewConstants.mainColor;
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
        
        imageGenerator.addImage(view.boxLogo, "logo-rh", 65);
        view.logoName.setFont( new Font("sansserif", Font.BOLD, 16) );
        view.logoName.setForeground(Color.decode(ViewConstants.textBtn));
        view.sidebar.setBackground(Color.decode(COLOR_SIDE_BAR));
        buttonGenerator.solidButton(view.btnLogout, COLOR_LOGOUT_BTN, "#F9F9F9");
        buttonGenerator.addIcon(view.btnLogout, "icon-logout", 20);
        buttonGenerator.solidButton(view.btnSettings, COLOR_SETTINGS_BTN, "#121615");
        buttonGenerator.addIcon(view.btnSettings, "icon-cog", 20);
        buttonGenerator.addIcon(view.btnWarehouse, "icon-box", 24);
        buttonGenerator.addIcon(view.btnPurchases, "icon-bag", 24);
        buttonGenerator.addIcon(view.btnSales, "icon-coins", 24);
        buttonGenerator.addIcon(view.btnAccess, "icon-key", 24);
        buttonGenerator.addIcon(view.btnQueries, "icon-document", 24);
        
        view.mainPanel.setSize( 900, 900 );
    }
}
