package controllers.supplier;

import java.awt.event.ActionListener;
import interfaces.ChangeStatusInterface;
import interfaces.HandlerController;
import controllers.supplier.handlers.ChangeSupplierStatusHandler;
import controllers.supplier.handlers.EditSupplierHandler;
import controllers.supplier.helpers.FilterSuppliers;
import controllers.supplier.helpers.LoadEditSupplier;
import controllers.supplier.handlers.SupplierPaginationHandler;
import controllers.supplier.helpers.FillBoxes;
import controllers.supplier.handlers.SaveSupplierHandler;
import controllers.supplier.helpers.SearchSuppliers;
import controllers.supplier.helpers.CreationCompanyForm;
import controllers.supplier.helpers.ViewElements;
import controllers.supplier.helpers.SupplierTableRefresher;
import models.SupplierModel;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.Modal;
import utils.helpers.SelectedRowTable;
import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesInfoSupplier;
import views.purchases.PurchasesSuppliers;

public class SupplierController {
    
    private final Modal modal = new Modal("Proveedores del sistema - PuntoCafé");
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;
    private final PurchasesInfoSupplier infoView;
    private final SupplierModel model;
    private final int QUANTITY_TABS = 3;
    private final SupplierService suppliersService;
    private final HandlerController saveSupplierHandler;
    private final HandlerController editSupplierHandler;
    private final ChangeStatusInterface activateSupplier;
    private final ChangeStatusInterface deactivateSupplier;
    private final FillBoxes fillCompanies;
    private final SupplierPaginationHandler paginationHandler;
    private final CreationCompanyForm creationCompanyForm;
    private final SupplierTableRefresher refresher;
    private final ViewElements elements;
    private final SearchSuppliers searchSupplier;
    private final FilterSuppliers filterSuppliers;
    private final LoadEditSupplier loadEditHandler;
    private final SelectedRowTable selectedRow;
    
    public SupplierController(PurchasesSuppliers view, SupplierModel model ) {
        this.view = view;
        this.model = model;
        
        this.createView = new PurchasesCreateSupplier();
        this.infoView = new PurchasesInfoSupplier();
        
        this.suppliersService = new SupplierService(this.model);
        
        this.saveSupplierHandler = new SaveSupplierHandler(view, suppliersService, modal);
        this.editSupplierHandler = new EditSupplierHandler(view, suppliersService, modal);
        
        this.activateSupplier = new ChangeSupplierStatusHandler(view, suppliersService, modal, true);
        this.deactivateSupplier = new ChangeSupplierStatusHandler(view, suppliersService, modal, false);
        
        this.fillCompanies = new FillBoxes(view, createView);
        this.paginationHandler = new SupplierPaginationHandler(view, suppliersService);
        this.creationCompanyForm = new CreationCompanyForm(view);
        this.refresher = new SupplierTableRefresher(paginationHandler);
        this.elements = new ViewElements(view, createView);
        this.searchSupplier = new SearchSuppliers(view);
        this.filterSuppliers = new FilterSuppliers(view);
        this.loadEditHandler = new LoadEditSupplier(view);
        this.selectedRow = new SelectedRowTable(view.suppliersTable);
        
        init();
        initListeners();     
    }
    
    private void init() {
        paginationHandler.execute();  
        elements.toggleCreateCompanyForm();
        fillCompanies.fillCompaniesBox(suppliersService.getCompaniesUnique());
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
    }
    
    private void initListeners() { 
        
        view.btnNewSupplier.addActionListener(e -> openCreateSupplierWindow());
        view.btnSeeSupplier.addActionListener(e -> openInfoSupplierWindow());
        
        createView.btnCancelSaveSupplier.addActionListener(e -> closeCreateSupplierWindow());
        createView.btnNewCompany.addActionListener(e -> elements.toggleCreateCompanyForm());
        
//        view.btnSaveSupplier.addActionListener(e -> createSupplier());
//        view.btnCancelSaveSupplier.addActionListener(e -> NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 0));
//        view.btnCancelEditSupplier.addActionListener(e -> NavegationTabs.activateTabPane(view.suppliersNavegationTab, QUANTITY_TABS, 0));
//        view.btnEditSupplier.addActionListener(e -> loadInfoToEdit());
//        view.btnUpdateSupplier.addActionListener(e -> editSupplier());
//        view.btnCreateCompany.addActionListener(e -> creationCompanyForm.toggleCompanyCreationFields());    
//        view.btnEditCreateCompany.addActionListener(e -> creationCompanyForm.toggleCompanyCreationFields());
//        view.suppliersStatusCombo.addActionListener(e -> filterSuppliersByStatus());
//        view.suppliersCompanyCombo.addActionListener(e -> filterSuppiersByCompany());
//        view.btnSearchSuppliers.addActionListener(e -> filterSuppliersByName());
//        view.btnActivateSupplier.addActionListener(e -> activateSupplier());
//        view.btnDeactivateSupplier.addActionListener(e -> deactivateSupplier());
//        view.pageComboBox.addActionListener(e -> paginationHandler.executeLoadSelectedPage(SearchCriteriaEnum.NAME));
//        view.itemsPerPageComboBox.addActionListener(e -> safelyRebuildPagination( SearchCriteriaEnum.NAME ));
//        view.btnNewSupplier.addActionListener(e -> navigateToCreateSupplierView());
//        view.btnRestore.addActionListener(e -> seeAllSuppliers());
    }
    
    private void seeAllSuppliers() {
        refresher.refresh(SearchCriteriaEnum.NAME, "");
        elements.showPaginationControls();
    }
    
    private void navigateToCreateSupplierView() {
        creationCompanyForm.hideCompanyCreationFields();
    }
    
    private void deactivateSupplier() {
        if ( !checkIfOneCategoryIsSelected() ) return;
        int row = selectedRow.getSelectedRow();
        if ( !deactivateSupplier.isStatusValid(row) ) return;
        if ( !deactivateSupplier.confirmChange(row) ) return;
        deactivateSupplier.change(row);
            
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
    }
    
    private void activateSupplier() {
        if ( !checkIfOneCategoryIsSelected() ) return;
        int row = selectedRow.getSelectedRow();
        if ( !activateSupplier.isStatusValid(row) ) return;
        if ( !activateSupplier.confirmChange(row) ) return;
        activateSupplier.change(row);
            
        safelyRebuildPagination( SearchCriteriaEnum.NAME );   
    }
    
    private void filterSuppliersByName() {
        String input = searchSupplier.getSearchInput();
        if ( !input.isEmpty() ) {
            elements.hidePaginationControls();
        }
        refresher.refresh(SearchCriteriaEnum.NAME, input);
    }
    
    private void filterSuppiersByCompany() {
        String company = filterSuppliers.filterByCompany();
        refresher.refresh(SearchCriteriaEnum.SUPPLIER_COMPANY_NAME, company);
        elements.hidePaginationControls();
    }
    
    private void filterSuppliersByStatus() {
        String status = filterSuppliers.filterByStatus();
        refresher.refresh(SearchCriteriaEnum.STATUS, status);
        elements.hidePaginationControls();
    }
    
    private void editSupplier() {
        editSupplierHandler.execute();
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
        safelyRebuildPagination(SearchCriteriaEnum.NAME );
        creationCompanyForm.hideCompanyCreationFields();
        elements.showPaginationControls();
    }
    
    private void loadInfoToEdit() {
        if ( !checkIfOneCategoryIsSelected() ) return;
            
        loadEditHandler.load();
        creationCompanyForm.hideCompanyCreationFields();       
    }
    
    private void createSupplier() {
        saveSupplierHandler.execute();
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
        elements.showPaginationControls();
    }
    
    private boolean checkIfOneCategoryIsSelected() {
        if ( !selectedRow.validate() ) {
            modal.show("Seleccione un proveedor", ModalTypeEnum.error);
            return false;
        }
        return true;
    }
    
    private void openInfoSupplierWindow() {
        infoView.setVisible(true);
    }
    
    private void openCreateSupplierWindow() {
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
        createView.setVisible(true);
    }
    
    private void closeCreateSupplierWindow() {
        createView.dispose();
        elements.clearCreateSupplierForm();
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
