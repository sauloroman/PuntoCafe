package controllers.purchase;

import controllers.purchase.helpers.LoadInformation;
import entities.User;
import models.PurchaseDetailModel;
import models.PurchaseModel;
import models.SupplierModel;
import services.PurchaseService;
import services.SupplierService;
import utils.helpers.DateFilterPanel;
import views.purchases.PurchasesBuy;

public class PurchaseController {
    
    private final User user;
    
    private final PurchasesBuy view;
    
    private final PurchaseModel model;
    private final PurchaseDetailModel purchaseDetailModel;
    private final SupplierModel supplierModel;
    
    private final SupplierService supplierService;
    private final PurchaseService purchaseService;

    private final LoadInformation load;
    private final DateFilterPanel dateFilter;
    
    public PurchaseController(
            User user,
            PurchasesBuy view, 
            PurchaseModel purchasemodel,
            PurchaseDetailModel purchaseDetailModel,
            SupplierModel supplierModel
    ) {
        this.user = user;
        
        this.view = view;
        this.purchaseDetailModel = purchaseDetailModel;
        this.supplierModel = supplierModel;
        
        this.model = purchasemodel;
        
        this.supplierService = new SupplierService(this.supplierModel);
        this.purchaseService = new PurchaseService(this.model, this.purchaseDetailModel);
        
        this.load = new LoadInformation(view);
        this.dateFilter = new DateFilterPanel(view.startDatePanel, view.endDatePanel);

        
        init();
        initHandlers();
    }
    
    private void init() {
        load.fillSuppliersBox(supplierService.getAll());
        loadStats();
    }
    
    private void initHandlers() {
        view.btnNewBuy.addActionListener(e -> openRegisterBuyWindow());
    }
    
    private void loadStats() {
        load.setTotalPurchasesAmount(purchaseService.getTotalPurchasesAmount());
        load.setTotalPurchases(purchaseService.getTotalPurchases());
        load.setAvgPurchaseAmount(purchaseService.getAvgPurchasesAmount());
        load.setTopSupplier(purchaseService.getTopSupplier());
    }
    
    private void openRegisterBuyWindow() {
        
        
        
    }
    
}
