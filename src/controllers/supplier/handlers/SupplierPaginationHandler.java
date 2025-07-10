package controllers.supplier.handlers;

import controllers.interfaces.PaginationHandlerController;
import entities.Supplier;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import services.SupplierService;
import utils.builders.SupplierTableBuilder;
import utils.enums.SearchCriteriaEnum;
import views.purchases.PurchasesSuppliers;

public class SupplierPaginationHandler extends PaginationHandlerController<Supplier, PurchasesSuppliers, SupplierService> {

    public SupplierPaginationHandler(PurchasesSuppliers view, SupplierService service) {
        super(view, service);
    }
    
    @Override
    protected int getTotalItems() {
        return service.getTotal();
    }

    @Override
    protected int getSelectedItemsPerPage() {
        return Integer.parseInt(view.itemsPerPageComboBox.getSelectedItem().toString());
    }

    @Override
    protected int getSelectedPage() {
        Object selectedItem = view.pageComboBox.getSelectedItem();
        if (selectedItem == null) {
            return 1;
        }
        return Integer.parseInt(selectedItem.toString());
    }

    @Override
    protected void clearPageComboBox() {
        view.pageComboBox.removeAllItems();
    }

    @Override
    protected void addPageToComboBox(int pageNumber) {
        view.pageComboBox.addItem(pageNumber + "");
    }

    @Override
    protected void setSelectedPageIndex(int index) {
        view.pageComboBox.setSelectedIndex(index);
    }

    @Override
    protected List<Supplier> listItemsByPage(String filter, SearchCriteriaEnum criteria, int page, int perPage) {
        return service.listByPage(filter, criteria, page, perPage);
    }

    @Override
    protected DefaultTableModel buildTableModel(List<Supplier> items) {
        return SupplierTableBuilder.create(items);
    }

    @Override
    protected void setTableModel(DefaultTableModel model) {
        view.suppliersTable.setModel(model);
    }

    @Override
    protected void setRowSorter(TableRowSorter<DefaultTableModel> sorter) {
        view.suppliersTable.setRowSorter(sorter);
    }

    @Override
    protected void showQuantityLabel(int showing, int total) {
        view.quantityItems.setText("Visualizando " + showing + " de " + total + " proveedores");
    }

    @Override
    protected int getPageComboBoxItemCount() {
        return view.pageComboBox.getItemCount();
    }

}
