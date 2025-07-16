package controllers.user.handlers;

import controllers.interfaces.PaginationHandlerController;
import entities.User;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.RoleService;
import services.UserService;
import utils.builders.BadgeCellRenderer;
import utils.builders.StatusBadgeCellRenderer;
import utils.builders.UserCellRenderer;
import utils.builders.UserTableBuilder;
import utils.enums.SearchCriteriaEnum;
import views.access.AccessUsers;

public class UserPaginationHandler extends PaginationHandlerController<User, AccessUsers, UserService>{

    private final RoleService roleService;
    
    public UserPaginationHandler(AccessUsers view, UserService service, RoleService roleService) {
        super(view, service);
        this.roleService = roleService;
    }
    
    @Override
    protected int getTotalItems() {
        return service.getTotalUsers();
    }

    @Override
    protected int getSelectedItemsPerPage() {
        return Integer.parseInt(view.itemsPerPageComboBox.getSelectedItem().toString());
    }

    @Override
    protected int getSelectedPage() {
        Object selectedItem = view.pageCombo.getSelectedItem();
        if ( selectedItem == null ) return 1;
        return Integer.parseInt(selectedItem.toString());
    }

    @Override
    protected void clearPageComboBox() {
        view.pageCombo.removeAllItems();
    }

    @Override
    protected void addPageToComboBox(int pageNumber) {
        view.pageCombo.addItem(pageNumber + "");
    }

    @Override
    protected void setSelectedPageIndex(int index) {
        view.pageCombo.setSelectedItem(index);
    }

    @Override
    protected List<User> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int perPage) {
        return service.getUsersByPage(filter, criteria, page, getSelectedItemsPerPage());
    }

    @Override
    protected DefaultTableModel buildTableModel(List<User> items) {
        return UserTableBuilder.create(items, roleService);
    }

    @Override
    protected void setTableModel(DefaultTableModel model) {
        view.usersTable.setModel(model);
        
        view.usersTable.getColumnModel().getColumn(1).setCellRenderer(new UserCellRenderer());
        view.usersTable.getColumnModel().getColumn(3).setCellRenderer(new BadgeCellRenderer());
        view.usersTable.getColumnModel().getColumn(6).setCellRenderer(new StatusBadgeCellRenderer());
    }

    @Override
    protected void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.usersTable.setRowSorter(sorter);
    }

    @Override
    protected void showQuantityLabel(int showing, int total) {
        view.quantityItems.setText("Visualizando " + showing + " de " + total + " usuarios");
    }

    @Override
    protected int getPageComboBoxItemCount() {
        return view.pageCombo.getItemCount();
    }
    
}
