package controllers.category.helpers;

import controllers.category.handlers.CategoryPaginationHandler;
import utils.enums.SearchCriteriaEnum;

public class CategoryTableRefresher {
    
    private final CategoryPaginationHandler paginationHandler;

    public CategoryTableRefresher(CategoryPaginationHandler paginationHandler) {
        this.paginationHandler = paginationHandler;
    }
    
    // Usar cuando la cantidad de ítems cambia
    public void rebuild(SearchCriteriaEnum criteria) {
        paginationHandler.executeRebuildPagination(criteria);
    }
    
    // Usar solo para filtros de texto sin cambiar total
    public void refresh(SearchCriteriaEnum criteria, String filter) {
        paginationHandler.getItemsPerFilter(criteria, filter);
    }
    
}
