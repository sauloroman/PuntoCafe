package controllers.user.helpers;

import controllers.user.handlers.UserPaginationHandler;
import utils.enums.SearchCriteriaEnum;

public class UserTableRefresher {
 
    private final UserPaginationHandler paginationHandler;

    public UserTableRefresher(UserPaginationHandler paginationHandler) {
        this.paginationHandler = paginationHandler;
    }
    
    public void rebuild(SearchCriteriaEnum criteria) {
        paginationHandler.executeRebuildPagination(criteria);
    } 
    
    public void refresh(SearchCriteriaEnum criteria, String filter) {
        System.out.println("Criterio en user table refresher: " + criteria);
        paginationHandler.getItemsPerFilter(criteria, filter);
    }
    
}
