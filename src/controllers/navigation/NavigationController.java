package controllers.navigation;

import entities.User;
import java.awt.BorderLayout;
import views.MainFrame;
import views.purchases.Purchases;
import utils.enums.NavigationEnum;
import javax.swing.JButton;
import javax.swing.JPanel;
import utils.helpers.ActivateButtonsNavegation;
import views.access.Access;
import views.queries.Queries;
import views.sales.Sales;
import views.sales.SalesSeller;
import views.warehouse.Warehouse;

public class NavigationController {
    
    private final User user;
    private final MainFrame mainFrame;
    private final Warehouse warehouse;
    private final Access access;
    private final Purchases purchases;
    private final Queries queries;
    private final Sales sales;
    private final SalesSeller salesSeller;
    private NavigationEnum currentView = null;
    
    public NavigationController(
            User user,
            MainFrame mainFrame,
            Warehouse warehouse,
            Purchases purchases,
            Access access,
            Queries queries,
            Sales sales,
            SalesSeller salesSeller
    ) {
        this.user = user;
        this.mainFrame = mainFrame; 
        this.warehouse = warehouse;
        this.access = access;
        this.purchases = purchases;
        this.sales = sales;
        this.queries = queries;
        this.salesSeller = salesSeller;
        
        mainFrame.btnWarehouse.addActionListener(e -> showWarehouseView());
        mainFrame.btnPurchases.addActionListener(e -> showPurchaseView());
        mainFrame.btnSales.addActionListener(e -> showSalesView());
        mainFrame.btnAccess.addActionListener(e -> showAccessView());
        mainFrame.btnQueries.addActionListener(e -> showQueriesView());
        
        changeView(
                user.getRoleId() == 3 ? salesSeller: sales, 
                user.getRoleId() == 3 ? NavigationEnum.SalesSeller : NavigationEnum.Sales, 
                mainFrame.btnSales
        );
    }
    
    private void changeView( JPanel panel, NavigationEnum navTarget, JButton btn ) {
        if ( currentView != navTarget ) {
            this.mainFrame.mainPanel.removeAll();
            this.mainFrame.mainPanel.add( panel, BorderLayout.CENTER );
            this.mainFrame.mainPanel.revalidate();
            this.mainFrame.mainPanel.repaint();
            currentView = navTarget;
            deactivateBtns();
            ActivateButtonsNavegation.activateBtn(btn);
        }
    }
    
    private void deactivateBtns() {
        JButton[] btns = new JButton[]{
            this.mainFrame.btnAccess,
            this.mainFrame.btnPurchases,
            this.mainFrame.btnQueries,
            this.mainFrame.btnSales,
            this.mainFrame.btnWarehouse
        };
        
        for (JButton btn : btns) {
            ActivateButtonsNavegation.deactivateBtn(btn);
        }
    }
    
    private void showQueriesView() {
        changeView(this.queries, NavigationEnum.Queries, this.mainFrame.btnQueries);
    }
    
    private void showAccessView() {
        changeView(this.access, NavigationEnum.Access, this.mainFrame.btnAccess );
    }
    
    private void showWarehouseView() {
        changeView(this.warehouse, NavigationEnum.WareHouse, this.mainFrame.btnWarehouse );
    }
     
    private void showSalesView() {
        if ( user.getRoleId() == 3 ) {
            changeView(this.salesSeller, NavigationEnum.Sales, this.mainFrame.btnSales );
        } else {
            changeView(this.sales, NavigationEnum.SalesSeller, this.mainFrame.btnSales );
        }
    }
    
    private void showPurchaseView() {
       changeView(this.purchases, NavigationEnum.Purchases, this.mainFrame.btnPurchases );
    }
}

