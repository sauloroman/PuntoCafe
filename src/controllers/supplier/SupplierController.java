package controllers.supplier;

import java.awt.event.ActionListener;
import controllers.interfaces.ChangeStatusInterface;
import controllers.interfaces.HandlerController;
import controllers.supplier.handlers.ChangeSupplierStatusHandler;
import controllers.supplier.handlers.EditSupplierHandler;
import controllers.supplier.helpers.FilterSuppliers;
import controllers.supplier.helpers.LoadEditSupplier;
import controllers.supplier.handlers.SupplierPaginationHandler;
import controllers.supplier.helpers.FillCompanies;
import controllers.supplier.handlers.SaveSupplierHandler;
import controllers.supplier.helpers.SearchSuppliers;
import controllers.supplier.helpers.CreationCompanyForm;
import controllers.supplier.helpers.HidePaginationControls;
import controllers.supplier.helpers.SupplierTableRefresher;
import models.SupplierModel;
import services.SupplierService;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.NavegationTabs;
import utils.helpers.Modal;
import utils.helpers.SelectedRowTable;
import views.purchases.PurchasesSuppliers;

public class SupplierController {
    
    private final Modal modal = new Modal("Proveedores del sistema - PuntoCafé");
    private final PurchasesSuppliers view;
    private final SupplierModel model;
    private final int QUANTITY_TABS = 3;
    private final SupplierService suppliersService;
    private final HandlerController saveSupplierHandler;
    private final HandlerController editSupplierHandler;
    private final ChangeStatusInterface activateSupplier;
    private final ChangeStatusInterface deactivateSupplier;
    private final FillCompanies fillCompanies;
    private final SupplierPaginationHandler paginationHandler;
    private final CreationCompanyForm creationCompanyForm;
    private final SupplierTableRefresher refresher;
    private final HidePaginationControls hidePagination;
    private final SearchSuppliers searchSupplier;
    private final FilterSuppliers filterSuppliers;
    private final LoadEditSupplier loadEditHandler;
    private final SelectedRowTable selectedRow;
    
    public SupplierController(PurchasesSuppliers view, SupplierModel model ) {
        this.view = view;
        this.model = model;
        
        this.suppliersService = new SupplierService(this.model);
        
        this.saveSupplierHandler = new SaveSupplierHandler(view, suppliersService, modal);
        this.editSupplierHandler = new EditSupplierHandler(view, suppliersService, modal);
        
        this.activateSupplier = new ChangeSupplierStatusHandler(view, suppliersService, modal, true);
        this.deactivateSupplier = new ChangeSupplierStatusHandler(view, suppliersService, modal, false);
        
        this.fillCompanies = new FillCompanies(view, suppliersService);
        this.paginationHandler = new SupplierPaginationHandler(view, suppliersService);
        this.creationCompanyForm = new CreationCompanyForm(view);
        this.refresher = new SupplierTableRefresher(paginationHandler);
        this.hidePagination = new HidePaginationControls(view);
        this.searchSupplier = new SearchSuppliers(view);
        this.filterSuppliers = new FilterSuppliers(view);
        this.loadEditHandler = new LoadEditSupplier(view);
        this.selectedRow = new SelectedRowTable(modal, view.suppliersTable);
        
        init();
        initListeners();     
    }
    
    private void init() {
        paginationHandler.execute();  
        fillCompanies.fillCompaniesBoxes();
        hidePagination.show();
    }
    
    private void initListeners() {     
        view.btnSaveSupplier.addActionListener(e -> createSupplier());
        view.btnCancelSaveSupplier.addActionListener(e -> NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 0));
        view.btnCancelEditSupplier.addActionListener(e -> NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 0));
        view.btnEditSupplier.addActionListener(e -> loadInfoToEdit());
        view.btnUpdateSupplier.addActionListener(e -> editSupplier());
        view.btnCreateCompany.addActionListener(e -> creationCompanyForm.toggleCompanyCreationFields());    
        view.btnEditCreateCompany.addActionListener(e -> creationCompanyForm.toggleCompanyCreationFields());
        view.suppliersStatusCombo.addActionListener(e -> filterSuppliersByStatus());
        view.suppliersCompanyCombo.addActionListener(e -> filterSuppiersByCompany());
        view.btnSearchSuppliers.addActionListener(e -> filterSuppliersByName());
        view.btnActivateSupplier.addActionListener(e -> activateSupplier());
        view.btnDeactivateSupplier.addActionListener(e -> deactivateSupplier());
        view.pageComboBox.addActionListener(e -> paginationHandler.executeLoadSelectedPage(SearchCriteriaEnum.NAME));
        view.itemsPerPageComboBox.addActionListener(e -> safelyRebuildPagination( SearchCriteriaEnum.NAME ));
        view.btnNewSupplier.addActionListener(e -> navigateToCreateSupplierView());
        view.btnSeeAllSuppliers.addActionListener(e -> seeAllSuppliers());
    }
    
    private void seeAllSuppliers() {
        refresher.refresh(SearchCriteriaEnum.NAME, "");
        hidePagination.show();
    }
    
    private void navigateToCreateSupplierView() {
        NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 1);
        creationCompanyForm.hideCompanyCreationFields();
    }
    
    private void deactivateSupplier() {
        if ( !selectedRow.validate("Seleccione un proveedor") ) return;
        int row = selectedRow.getSelectedRow();
        if ( !deactivateSupplier.isStatusValid(row) ) return;
        if ( !deactivateSupplier.confirmChange(row) ) return;
        deactivateSupplier.change(row);
            
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
    }
    
    private void activateSupplier() {
        if ( !selectedRow.validate("Seleccione un proveedor") ) return;
        int row = selectedRow.getSelectedRow();
        if ( !activateSupplier.isStatusValid(row) ) return;
        if ( !activateSupplier.confirmChange(row) ) return;
        activateSupplier.change(row);
            
        safelyRebuildPagination( SearchCriteriaEnum.NAME );   
    }
    
    private void filterSuppliersByName() {
        String input = searchSupplier.getSearchInput();
        if ( !input.isEmpty() ) {
            hidePagination.hide();
        }
        refresher.refresh(SearchCriteriaEnum.NAME, input);
    }
    
    private void filterSuppiersByCompany() {
        String company = filterSuppliers.filterByCompany();
        refresher.refresh(SearchCriteriaEnum.SUPPLIER_COMPANY_NAME, company);
        hidePagination.hide();
    }
    
    private void filterSuppliersByStatus() {
        String status = filterSuppliers.filterByStatus();
        refresher.refresh(SearchCriteriaEnum.STATUS, status);
        hidePagination.hide();
    }
    
    private void editSupplier() {
        editSupplierHandler.execute();
        fillCompanies.fillCompaniesBoxes();
        safelyRebuildPagination(SearchCriteriaEnum.NAME );
        creationCompanyForm.hideCompanyCreationFields();
        hidePagination.show();
        NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 0);
    }
    
    private void loadInfoToEdit() {
        if ( !selectedRow.validate("Seleccione un proveedor") ) return;
            
        loadEditHandler.load();
        NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 2);
        creationCompanyForm.hideCompanyCreationFields();       
    }
    
    private void createSupplier() {
        saveSupplierHandler.execute();
        fillCompanies.fillCompaniesBoxes();
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
        NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 0);
        hidePagination.show();
    }
    
    private void safelyRebuildPagination (SearchCriteriaEnum criteria) {
        ActionListener[] listeners = view.pageComboBox.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageComboBox.removeActionListener(l);
        }

        paginationHandler.executeRebuildPagination(criteria);

        for (ActionListener l : listeners) {
            view.pageComboBox.addActionListener(l);
        }
    }
    
}
