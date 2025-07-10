package controllers.supplier.helpers;

import controllers.supplier.handlers.SupplierPaginationHandler;
import utils.enums.SearchCriteriaEnum;

public class SupplierTableRefresher {
    
    private final SupplierPaginationHandler paginationHandler;

    public SupplierTableRefresher(SupplierPaginationHandler paginationHandler) {
        this.paginationHandler = paginationHandler;
    }
    
    public void refresh(SearchCriteriaEnum criteria, String filter) {
        paginationHandler.getItemsPerFilter(criteria, filter);
    }
    
}
