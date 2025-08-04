package views.sales;

import entities.User;
import java.awt.Color;
import javax.swing.BorderFactory;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;
import views.components.Table;

public class SalesInit {
    
    private final User user;
    private final Sales view;
    private final int WIDTH_PANEL = 1320;
    private final int HEIGHT_PANEL = 790;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();
    
    public SalesInit(Sales view, User user) {
        this.view = view;
        this.user = user;
    }
    
    public void init() {
        
        Table.tableStyle3(view.salesTable);
        view.scrollPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#DDDDDD")));        
        view.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        
        buttonGenerator.solidButton(view.btnFilter, ViewConstants.blackColor, "#FFFFFF", 11);
        buttonGenerator.addIcon(view.btnFilter, "icon-search", 16);
        buttonGenerator.solidButton(view.btnNewSale, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnNewSale, "icon-plus-white", 20);
        buttonGenerator.solidButton(view.btnReload, "#FFFFFF", ViewConstants.textBtn, 12);
        buttonGenerator.addIcon(view.btnReload, "icon-reload", 16);
        
        imageGenerator.addImageFix(view.iconTicket, "icon-ticket", 25, 25);
        imageGenerator.addImageFix(view.iconCoin, "icon-money", 25, 25);
        imageGenerator.addImageFix(view.iconArrow, "icon-avg", 25, 25);
        imageGenerator.addImageFix(view.iconDiscount, "icon-discount", 25, 25);
        imageGenerator.addImageFix(view.iconInfo, "icon-info-white", 15, 15);
        imageGenerator.addImageFix(view.iconInfo1, "icon-info-black", 15, 15);
        imageGenerator.addImageFix(view.iconInfo2, "icon-info-black", 15, 15);
        imageGenerator.addImageFix(view.iconInfo3, "icon-info-black", 15, 15);
        
        inputGenerator.roundedComboBox(view.filterUsers, "#DDDDDD", 10);
        
        hideElementsDependingRole();
    }
    
    public void hideElementsDependingRole() {
        if ( user.getRoleId() == 2 ) {
            view.btnNewSale.setVisible(false);
        }
    }
    
}
