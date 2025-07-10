package controllers.interfaces;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.enums.SearchCriteriaEnum;

public abstract class PaginationHandlerController<T, V, S> implements HandlerController {
    
    protected final V view;
    protected final S service;

    public PaginationHandlerController(V view, S service) {
        this.view = view;
        this.service = service;
    }
    
    @Override
    public void execute() {
        executeRebuildPagination(SearchCriteriaEnum.NAME);
    }
    
    public void executeRebuildPagination(SearchCriteriaEnum criteria) {
        int total = getTotalItems();
        int perPage = getSelectedItemsPerPage();
        int pages = Math.max((int) Math.ceil((double) total / perPage), 1);

        clearPageComboBox();
        for (int i = 1; i <= pages; i++) {
            addPageToComboBox(i);
        }

        if (getPageComboBoxItemCount() > 0) {
            setSelectedPageIndex(0);
        }
        
        loadPage(1, perPage, criteria, "");
        showQuantityItemsInView(total, perPage);
    }

    public void executeLoadSelectedPage(SearchCriteriaEnum criteria) {
        int total = getTotalItems();
        int perPage = getSelectedItemsPerPage();
        int page = getSelectedPage();

        loadPage(page, perPage, criteria, "");
        showQuantityItemsInView(total, perPage);
    }
    
    public void reloadCurrentPage( SearchCriteriaEnum criteria ) {
        int perPage = getSelectedItemsPerPage();
        int page = getSelectedPage();
        loadPage(page, perPage, criteria, "");
    }
    
    public void getItemsPerFilter(SearchCriteriaEnum criteria, String filter) {
        loadPage(1, 20, criteria, filter );
    }
    
    private void loadPage(int page, int perPage, SearchCriteriaEnum criteria, String filter ) {
        List<T> items = listItemsByPage(filter, criteria, page, perPage);
        DefaultTableModel tableModel = buildTableModel(items);
        setTableModel(tableModel);
        setRowSorter(new TableRowSorter<>(tableModel));
    }

    private void showQuantityItemsInView(int totalItems, int selectedItemsPerPage) {
        if (selectedItemsPerPage > totalItems) {
            selectedItemsPerPage = totalItems;
        }
        showQuantityLabel(selectedItemsPerPage, totalItems);
    }

    protected abstract int getTotalItems();
    protected abstract int getSelectedItemsPerPage();
    protected abstract int getSelectedPage();
    protected abstract void clearPageComboBox();
    protected abstract void addPageToComboBox(int pageNumber);
    protected abstract void setSelectedPageIndex(int index);
    protected abstract List<T> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int perPage);
    protected abstract DefaultTableModel buildTableModel(List<T> items);
    protected abstract void setTableModel(DefaultTableModel model);
    protected abstract void setRowSorter(TableRowSorter<DefaultTableModel> sorter);
    protected abstract void showQuantityLabel(int showing, int total);
    protected abstract int getPageComboBoxItemCount();

}
