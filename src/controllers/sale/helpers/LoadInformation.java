package controllers.sale.helpers;

import entities.Dish;
import entities.Product;
import entities.User;
import java.awt.BorderLayout;
import java.util.List;
import org.jfree.chart.ChartPanel;
import views.sales.CreateSaleDishQuantity;
import views.sales.CreateSaleProductQuantity;
import views.sales.Sales;

public class LoadInformation {
    
    private final Sales view;
    private final CreateSaleProductQuantity productQuantityView;
    private final CreateSaleDishQuantity dishQuantityView;

    public LoadInformation(
            Sales view,
            CreateSaleProductQuantity productQuantityView,
            CreateSaleDishQuantity dishQuantityView
    ) {
        this.view = view;
        this.productQuantityView = productQuantityView;
        this.dishQuantityView = dishQuantityView;
    }
    
    public void productQuantiy(Product product) {
        productQuantityView.productName.setText(product.getProductName());
        productQuantityView.productStock.setText(product.getProductStock() + "");
        productQuantityView.sellingPrice.setText(product.getProductSellingPrice() + "0");
    }
    
    public void dishQuantity(Dish dish) {
        dishQuantityView.dishName.setText(dish.getDishName());
        dishQuantityView.sellingPrice.setText(dish.getDishSellingPrice() + "");
    }
    
    public void fillUserBox(List<User> users) {
        view.filterUsers.removeAllItems();
        view.filterUsers.addItem("Usuarios");
        for ( User user: users ) {
            view.filterUsers.addItem(user.getUserName() + " " + user.getUserLastname());
        }
        view.filterUsers.setSelectedItem(0);
    }
    
    public void setTotalSalesAmount( double total ) {
        view.saleMoney.setText("$" + String.format("%.2f", total));
    }
    
    public void setTotalSales( int totalSales ) {
        view.saleQuantity.setText(totalSales + "");
    }
    
    public void setAvgSaleAmount( double quantity ) {
        view.saleAvg.setText("$" + String.format("%.2f", quantity));
    }
    
    public void setTotalDiscountSalesAmount( double quantity ) {
        view.saleDisscount.setText("$" + String.format("%.2f", quantity));
    }
    
    public void createSalesAmountBarChart( ChartPanel chart ) {
        view.salesGraph.removeAll();
        view.salesGraph.setLayout(new BorderLayout());
        view.salesGraph.add(chart, BorderLayout.CENTER);
        view.salesGraph.revalidate();
        view.salesGraph.repaint();
    }
    
    public void createCategoryItemsCountDonutChart( ChartPanel chart ) {
        view.salesItems.removeAll();
        view.salesItems.setLayout(new BorderLayout());
        view.salesItems.add(chart, BorderLayout.CENTER);
        view.salesItems.revalidate();
        view.salesItems.repaint();
    }
    
}
