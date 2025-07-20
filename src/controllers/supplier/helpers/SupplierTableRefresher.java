package controllers.supplier.helpers;

import utils.enums.SearchCriteriaEnum;

public class SupplierTableRefresher {
    
    private final SupplierPagination paginationHandler;

    public SupplierTableRefresher(SupplierPagination paginationHandler) {
        this.paginationHandler = paginationHandler;
    }
    
    public void refresh(SearchCriteriaEnum criteria, String filter) {
        paginationHandler.getItemsPerFilter(criteria, filter);
    }
    
}
