package controllers.supplier;

import controllers.supplier.helpers.InputReader;
import java.awt.event.ActionListener;
import controllers.supplier.helpers.LoadInformation;
import controllers.supplier.helpers.SupplierPagination;
import controllers.supplier.helpers.ChangeSupplierStatus;
import controllers.supplier.helpers.FillBoxes;
import controllers.supplier.helpers.QuantitySuppliers;
import controllers.supplier.helpers.SupplierFromTable;
import controllers.supplier.helpers.ViewElements;
import controllers.supplier.helpers.SupplierTableRefresher;
import controllers.supplier.helpers.SupplierValidator;
import entities.Supplier;
import models.SupplierModel;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.Modal;
import controllers.supplier.helpers.SelectedRowTable;
import utils.helpers.GenerateReports;
import views.purchases.PurchasesCreateSupplier;
import views.purchases.PurchasesEditSupplier;
import views.purchases.PurchasesInfoSupplier;
import views.purchases.PurchasesSuppliers;

public class SupplierController {
    
    private final PurchasesSuppliers view;
    private final PurchasesCreateSupplier createView;
    private final PurchasesInfoSupplier infoView;
    private final PurchasesEditSupplier editView;
    private final SupplierModel model;
    private final SupplierService suppliersService;
    private final ChangeSupplierStatus activate;
    private final ChangeSupplierStatus deactivate;
    private final FillBoxes fillCompanies;
    private final SupplierValidator validator; 
    private final InputReader inputReader;
    private final SupplierPagination paginationHandler;
    private final SupplierTableRefresher refresher;
    private final ViewElements elements;
    private final QuantitySuppliers quantity;
    private final LoadInformation loadInformation;
    private final SelectedRowTable selectedRow;
    private final SupplierFromTable fromTable;
    private final Modal modal = new Modal("Proveedores del sistema - PuntoCafé");
    private Supplier supplierSelected = null;

    
    public SupplierController(PurchasesSuppliers view, SupplierModel model ) {
        this.view = view;
        this.model = model;
        
        this.createView = new PurchasesCreateSupplier();
        this.infoView = new PurchasesInfoSupplier();
        this.editView = new PurchasesEditSupplier();
        
        this.suppliersService = new SupplierService(this.model);
                
        this.activate = new ChangeSupplierStatus(view, suppliersService, true);
        this.deactivate = new ChangeSupplierStatus(view, suppliersService, false);
        
        this.quantity = new QuantitySuppliers(view);
        this.fromTable = new SupplierFromTable(view, suppliersService);
        this.validator = new SupplierValidator(modal);
        this.inputReader = new InputReader(view, createView, editView );
        this.fillCompanies = new FillBoxes(view, createView, editView);
        this.paginationHandler = new SupplierPagination(view, suppliersService);
        this.refresher = new SupplierTableRefresher(paginationHandler);
        this.elements = new ViewElements(view, createView, editView);
        this.loadInformation = new LoadInformation(infoView, editView);
        this.selectedRow = new SelectedRowTable(view.suppliersTable);
        
        init();
        initListeners();     
    }
    
    private void init() {
        paginationHandler.execute(); 
        quantity.setQuantity(suppliersService.getTotal());
        elements.toggleCreateCompanyFormEdit();
        elements.toggleCreateCompanyForm();
        fillCompanies.fillCompaniesBox(suppliersService.getCompaniesUnique());
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
    }
    
    private void initListeners() {
        view.btnNewSupplier.addActionListener(e -> openCreateSupplierWindow());
        view.btnSeeSupplier.addActionListener(e -> openInfoSupplierWindow());
        view.pageComboBox.addActionListener(e -> paginationHandler.executeLoadSelectedPage(SearchCriteriaEnum.NAME));
        view.itemsPerPageComboBox.addActionListener(e -> safelyRebuildPagination( SearchCriteriaEnum.NAME ));
        view.btnRestore.addActionListener(e -> seeAllSuppliers());
        view.btnSearch.addActionListener(e -> filterSuppliersByName());
        view.suppliersCompanyCombo.addActionListener(e -> filterSuppliersByCompany());
        view.suppliersStatusCombo.addActionListener(e -> filterSuppliersByStatus());
        view.btnExportSuppliers.addActionListener(e -> generateReport());
        
        infoView.btnEdit.addActionListener(e -> openEditSupplierWindow());
        infoView.btnActivate.addActionListener(e -> activateSupplier());
        infoView.btnDeactivate.addActionListener(e -> deactivateSupplier());
        
        createView.btnCancelSaveSupplier.addActionListener(e -> closeCreateSupplierWindow());
        createView.btnNewCompany.addActionListener(e -> elements.toggleCreateCompanyForm());
        createView.btnSaveSupplier.addActionListener(e -> saveSupplier());
    
        editView.btnCancelEditSupplier.addActionListener( e -> closeEditSupplierWindow());
        editView.btnEditSupplier.addActionListener(e -> editSupplier());
        editView.btnNewCompany.addActionListener(e -> elements.toggleCreateCompanyFormEdit());
    }
        
    private void seeAllSuppliers() {
        elements.showPaginationControls();
        elements.clearInputSearch();
        safelyRebuildPagination(SearchCriteriaEnum.NAME);
    }
    
    private void deactivateSupplier() {
        int id = selectedRow.getId();
        String status = selectedRow.getStatus();
        String name = selectedRow.getName();
        
        if (!deactivate.isStatusValid(status)) {
            modal.show("El proveedor ya está inactivo", ModalTypeEnum.warning);
            return;
        }
        
        if ( modal.confirm("¿Está seguro de cambiar el estado del proveedor?") != 0 ) return;
        
        if ( !deactivate.change(id )) {
            modal.show("El proveedor no pudo cambiar de estado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El proveedor " + name + " se ha desactivado", ModalTypeEnum.success);       
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
        infoView.dispose();
    }
    
    private void activateSupplier() {
        int id = selectedRow.getId();
        String status = selectedRow.getStatus();
        String name = selectedRow.getName();
        
        if (!activate.isStatusValid(status)) {
            modal.show("El proveedor ya está activo", ModalTypeEnum.warning);
            return;
        }
        
        if ( modal.confirm("¿Está seguro de cambiar el estado del proveedor?") != 0 ) return;
        
        if ( !activate.change(id )) {
            modal.show("El proveedor no pudo cambiar de estado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El proveedor " + name + " se ha activado", ModalTypeEnum.success);       
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
        infoView.dispose();
    }
    
    private void filterSuppliersByName() {
        String supplierSearched = inputReader.getNameSearch();        
        if ( supplierSearched == null ) return;
        
        refresher.refresh(SearchCriteriaEnum.NAME, supplierSearched);
        elements.hidePaginationControls();
    }
    
    private void filterSuppliersByCompany() {
        String companySearch = inputReader.getCompanySearch();
        if ( companySearch == null ) return;
        
        refresher.refresh(SearchCriteriaEnum.SUPPLIER_COMPANY_NAME, companySearch);
        elements.hidePaginationControls();
    }
    
    private void filterSuppliersByStatus() {
        String statusSearch = inputReader.getStatusSearch();
        if ( statusSearch == null ) return;
        
        refresher.refresh(SearchCriteriaEnum.STATUS, statusSearch);
        elements.hidePaginationControls();
    }
    
    private void editSupplier() {
        String name = inputReader.getNameEdit();
        String lastName = inputReader.getLastNameEdit();
        String phone = inputReader.getPhoneEdit();
        String email = inputReader.getEmailEdit();
        String address = inputReader.getAddressEdit();
        String finalCompany = determineSupplierCompany(
                inputReader.getCompanySelectedEdit(), 
                inputReader.getNewCompanyEdit()
        );
        
        if ( finalCompany == null ) {
            modal.show("La empresa que intentas crear está entre las opciones disponibles", ModalTypeEnum.error);
            return;
        }
        
        if ( !validator.isValidForm(name, lastName, phone, email, address, finalCompany)) return;
        
        Supplier supplier = new Supplier(name, lastName, finalCompany, phone, email, address);
        
        if ( !suppliersService.updateSupplier(supplier, supplierSelected.getSupplierId()) ) {
            modal.show("El proveedor no pudo ser actualizado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El proveedor ha sido actualizado exitosamente", ModalTypeEnum.success);
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
        fillCompanies.fillCompaniesBoxEdit(suppliersService.getCompaniesUnique());
        safelyRebuildPagination(SearchCriteriaEnum.NAME );
        elements.showPaginationControls();
        elements.clearEditSupplierForm();
        editView.dispose();
        infoView.dispose();
    }

    private void saveSupplier() {
        String name = inputReader.getNameCreate();
        String lastName = inputReader.getLastNameCreate();
        String phone = inputReader.getPhoneCreate();
        String email = inputReader.getEmailCreate();
        String address = inputReader.getAddressCreate();
        String finalCompany = determineSupplierCompany(
                inputReader.getCompanySelectedCreate(), 
                inputReader.getNewCompanyCreate()
        );
        
        if ( finalCompany == null ) {
            modal.show("La empresa que intentas crear está entre las opciones disponibles", ModalTypeEnum.error);
            return;
        }
        
        if ( !validator.isValidForm(name, lastName, phone, email, address, finalCompany)) return;
        
        Supplier newSupplier = new Supplier(name, lastName, finalCompany, phone, email, address);
        
        if ( !suppliersService.saveSupplier(newSupplier) ) {
            modal.show("El proveedor no pudo ser creado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El proveedor ha sido creado exitosamente", ModalTypeEnum.success);
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
        fillCompanies.fillCompaniesBoxEdit(suppliersService.getCompaniesUnique());
        safelyRebuildPagination( SearchCriteriaEnum.NAME );
        elements.showPaginationControls();
        elements.clearCreateSupplierForm();
        quantity.setQuantity(suppliersService.getTotal());
        createView.dispose();
    }
    
    private String determineSupplierCompany( String company, String newCompany ) {
        String finalCompany = company;
        
        if ( !newCompany.isEmpty()) {
            finalCompany = newCompany;
            if ( suppliersService.getSupplierByCompany(finalCompany) != null ) return null;
        }
        
        return finalCompany;
    }
    
    private void openInfoSupplierWindow() {
        if ( !selectedRow.validate() ) {
            modal.show("Seleccione un proveedor", ModalTypeEnum.error);
            return;
        }
        
        Supplier supplier = fromTable.supplierSelectedInTable(selectedRow.getSelectedRow());
        supplierSelected = supplier;
        loadInformation.infoWindow(supplier);
        infoView.setVisible(true);
    }
    
    private void openEditSupplierWindow() {
        editView.setVisible(true);
        fillCompanies.fillCompaniesBoxEdit(suppliersService.getCompaniesUnique());
        loadInformation.editWindow(supplierSelected);
        elements.hideCreateCompanyFormEdit();
    }
    
    private void closeEditSupplierWindow() {
        editView.dispose();
        elements.clearEditSupplierForm();
    }
    
    private void openCreateSupplierWindow() {
        fillCompanies.fillCompaniesBoxCreate(suppliersService.getCompaniesUnique());
        createView.setVisible(true);
        elements.hideCreateCompanyForm();
    }
    
    private void closeCreateSupplierWindow() {
        createView.dispose();
        elements.clearCreateSupplierForm();
    }
    
    private void generateReport() {
        GenerateReports.generateReport("suppliers-report", "Reporte de proveedores del sistema");
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
