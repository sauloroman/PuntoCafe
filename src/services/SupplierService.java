package services;

import entities.Supplier;
import java.util.List;
import models.SupplierModel;
import utils.enums.SearchCriteriaEnum;

public class SupplierService {
    
    private final SupplierModel model;

    public SupplierService(SupplierModel model) {
        this.model = model;
    }
    
    public List<Supplier> getAll() {
        List<Supplier> suppliers = model.listItems("");
        return suppliers;
    }
    
    public List<String> getCompaniesUnique() {
        List<String> suppliersUnique = model.getCompaniesSupplier();
        return suppliersUnique;
    }
    
    public Supplier getByName(String supplierName) {
        Supplier supplier = model.getItemByName(supplierName);
        return supplier;
    }
    
    public Supplier getById(int id) {
        Supplier supplier = model.getItemById(id);
        return supplier;
    }
    
    public int getTotal() {
        return model.getTotalItems();
    }
    
    public Supplier getSupplierByCompany(String company) {
        return model.getItemByCompany(company);
    }
    
    public List<Supplier> listByPage(String filter, SearchCriteriaEnum criteria, int page, int perPage) {
        List<Supplier> suppliers = model.listItemsByPage(filter, criteria, page, perPage);
        return suppliers;
    }
    
    public boolean saveSupplier( Supplier supplier ) {
        return model.saveItem(supplier);
    }
    
    public boolean updateSupplier( Supplier supplier, int supplierId ) {
        return model.updateItem(supplier, supplierId);
    }
    
    public boolean activateSupplier( int supplierId ) {
        return model.changeStatus(supplierId, true);
    }
    
    public boolean deactivateSupplier( int supplierId ) {
        return model.changeStatus(supplierId, false);
    }
    
}
