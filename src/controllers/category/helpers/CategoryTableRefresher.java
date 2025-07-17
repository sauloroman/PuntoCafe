package controllers.category.helpers;

import utils.enums.SearchCriteriaEnum;

public class CategoryTableRefresher {
    
    private final CategoryPagination paginationHandler;

    public CategoryTableRefresher(CategoryPagination paginationHandler) {
        this.paginationHandler = paginationHandler;
    }
    
    public void rebuild(SearchCriteriaEnum criteria) {
        paginationHandler.executeRebuildPagination(criteria);
    }
    
    public void refresh(SearchCriteriaEnum criteria, String filter) {
        paginationHandler.getItemsPerFilter(criteria, filter);
    }
    
}
