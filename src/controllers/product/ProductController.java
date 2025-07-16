package controllers.product;

import interfaces.ChangeStatusNoTableInterface;
import services.ProductService;
import services.CategoryService;
import interfaces.HandlerController;
import controllers.product.handlers.ChangeProductStatusHandler;
import controllers.product.handlers.EditProductHandler;
import controllers.product.handlers.SaveProductHandler;
import controllers.product.helpers.ResetElements;
import controllers.product.helpers.ProductGrid;
import controllers.product.helpers.FillComboBoxes;
import controllers.product.helpers.FilterProducts;
import controllers.product.helpers.LoadEditInformation;
import controllers.product.helpers.LoadInformationProduct;
import controllers.product.helpers.UploadProductImage;
import controllers.product.helpers.Pages;
import controllers.product.helpers.ProductValidator;
import entities.Product;
import java.awt.event.ActionListener;
import services.SupplierService;
import models.CategoryModel;
import models.ProductModel;
import models.SupplierModel;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;
import views.warehouse.WarehouseInfoProduct;
import views.warehouse.WarehouseProducts;

public class ProductController {
    
    private final WarehouseProducts view;
    private final ProductModel model;
    private final CategoryModel categoryModel;
    private final SupplierModel supplierModel;
    private final WarehouseInfoProduct infoProductWindow;
    private final WarehouseEditProduct editProductWindow;
    private final WarehouseCreateProduct createProductWindow;
    private final ProductService products;
    private final CategoryService categories;
    private final SupplierService suppliers;
    private final Pages pages;
    private final UploadProductImage upload;
    private final FillComboBoxes fillComboBoxes;
    private final ProductGrid productGrid;
    private final ResetElements resetElements;
    private final LoadInformationProduct loadInfo;
    private final LoadEditInformation loadEdit;
    private final ChangeStatusNoTableInterface activateProduct;
    private final ChangeStatusNoTableInterface deactivateProduct;
    private final FilterProducts filter;
    private final ProductValidator productValidator;
    private final HandlerController saveProductHandler;
    private final HandlerController editProductHandler;
    private Product productSelected;
    private SearchCriteriaEnum filterSelected = SearchCriteriaEnum.NONE;
    private final Modal modal = new Modal("Productos del sistema - PuntoCafé");

    public ProductController(
            WarehouseProducts view, 
            ProductModel model,
            CategoryModel categoryModel,
            SupplierModel supplierModel
    ) {
        this.view = view;
        this.model = model;
        this.categoryModel = categoryModel;
        this.supplierModel = supplierModel;
        
        this.infoProductWindow = new WarehouseInfoProduct();
        this.editProductWindow = new WarehouseEditProduct();
        this.createProductWindow = new WarehouseCreateProduct();
        
        this.products = new ProductService( this.model);
        this.categories = new CategoryService(this.categoryModel);
        this.suppliers = new SupplierService(this.supplierModel);
        
        this.pages = new Pages( view, products );
        
        this.upload = new UploadProductImage(createProductWindow, editProductWindow, modal);
        this.fillComboBoxes = new FillComboBoxes(createProductWindow, editProductWindow, view);
        this.productGrid = new ProductGrid(view, products, suppliers);
        this.resetElements = new ResetElements(createProductWindow, editProductWindow);
        this.loadInfo = new LoadInformationProduct(infoProductWindow, categories, suppliers);
        this.loadEdit = new LoadEditInformation(editProductWindow, categories, suppliers);
        this.productValidator = new ProductValidator(createProductWindow, editProductWindow, modal);
        this.activateProduct = new ChangeProductStatusHandler(infoProductWindow, products, modal, true);
        this.deactivateProduct = new ChangeProductStatusHandler(infoProductWindow, products, modal, false);
        this.filter = new FilterProducts(view, categories);
        
        this.saveProductHandler = new SaveProductHandler(createProductWindow, categories, suppliers, products, modal );
        this.editProductHandler = new EditProductHandler(editProductWindow, categories, suppliers, products, modal);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
        resetElements.showButtonUploadImage();
        fillComboBoxes.categoriesCreateBox(categories.getProductCategories());
        fillComboBoxes.suppliersCreateBox(suppliers.getAll());
        fillComboBoxes.categoriesFilterBox(categories.getProductCategories());
        fillComboBoxes.suppliersFilterBox(suppliers.getCompaniesUnique());
        fillComboBoxes.categoriesEditBox(categories.getProductCategories());
        fillComboBoxes.suppliersEditBox(suppliers.getAll());    
    }

    private void initListeners() {        
        view.btnNewProduct.addActionListener(e -> openCreateProductWindow());
        view.pageComboBox.addActionListener(e -> changePage(filterSelected));
        view.productCategoryCombo.addActionListener(e -> filterProductsByCategory());
        view.productSupplierCombo.addActionListener(e -> filterProductsBySupplierCompany());
        view.productStatusCombo.addActionListener(e -> filterProductsByStatus() );
        view.btnSearch.addActionListener(e -> filterProductsByName());
        
        createProductWindow.btnCancelSaveProduct.addActionListener(e -> closeCreateProductWindow());
        createProductWindow.btnLoadImage.addActionListener(e -> uploadImage(false));
        createProductWindow.btnRemoveImage.addActionListener(e -> removeImage());
        createProductWindow.btnSaveProduct.addActionListener(e -> createProduct());
        
        infoProductWindow.btnEditProduct.addActionListener(e -> openEditProductWindow());
        infoProductWindow.btnActivate.addActionListener(e -> activateProduct());
        infoProductWindow.btnDeactivate.addActionListener(e -> deactivateProduct());
        
        editProductWindow.btnRemoveImage.addActionListener(e -> removeImage());
        editProductWindow.btnLoadImage.addActionListener(e -> uploadImage(true));
        editProductWindow.btnCancelEditProduct.addActionListener(e -> closeEditProductWindow());
        editProductWindow.btnUpdateProduct.addActionListener(e -> editProduct());
        
        productGrid.setOnProductClick(product -> openInfoProduct(product));
        
        productGrid.showAllProducts(1);
    }
    
    private void filterProductsByName() {
        String productNameSearched = filter.getProductNameSearched();
        
        if (productNameSearched == null) {
            safelyRebuildPagination(() -> pages.create());
            filterSelected = SearchCriteriaEnum.NONE;
            productGrid.showAllProducts(1);
            return; 
        } 
        
        safelyRebuildPagination(() -> pages.createByName(productNameSearched));
        productGrid.showProductsByName(productNameSearched, 1);
        filterSelected = SearchCriteriaEnum.NAME;
    }
    
    private void filterProductsByStatus() {
        String statusSelected = filter.getStatusSelected();
        
        if (statusSelected == null) {
            safelyRebuildPagination(() -> pages.create());
            filterSelected = SearchCriteriaEnum.NONE;
            productGrid.showAllProducts(1);
            return;
        }
        
        safelyRebuildPagination(() -> pages.createByStatus(statusSelected));
        productGrid.showProductsByStatus(statusSelected, 1);
        filterSelected = SearchCriteriaEnum.STATUS;
    }
    
    private void filterProductsBySupplierCompany() {
        String supplierSelected = filter.getSupplierCompanyName();
        
        if ( supplierSelected == null ) {
            safelyRebuildPagination(() -> pages.create());
            filterSelected = SearchCriteriaEnum.NONE;
            productGrid.showAllProducts(1);
            return;
        }
        
        safelyRebuildPagination(() -> pages.createBySuppliers(supplierSelected));
        productGrid.showProductsBySupplier(supplierSelected, 1);
        filterSelected = SearchCriteriaEnum.PRODUCT_SUPPLIER;
    }
    
    private void filterProductsByCategory() {
        int categorySelected = filter.getCategoryIDSelected();
        
        if ( categorySelected == -1 ){
            safelyRebuildPagination(() -> pages.create());
            filterSelected = SearchCriteriaEnum.NONE;
            productGrid.showAllProducts(1);
            return;
        }
        
        safelyRebuildPagination(() -> pages.createByCategories(categorySelected));
        productGrid.showProductsByCategory(categorySelected, 1);
        filterSelected = SearchCriteriaEnum.PRODUCT_CATEGORY;
    }
    
    private void createProduct() {
        if ( !productValidator.isValidCreation() ) return;
        
        if (!upload.handleUploadForCreate()) {
            ((SaveProductHandler) saveProductHandler).setProductImage("no-image.jpg");
        } else {
            ((SaveProductHandler) saveProductHandler).setProductImage(upload.image);
        }
        
        ((SaveProductHandler) saveProductHandler).setProductImage(upload.image);
        saveProductHandler.execute();
        productGrid.showAllProducts(1);
        safelyRebuildPagination(() -> pages.create());
        resetElements.resetCreateForm();
        createProductWindow.setVisible(false);
        upload.removeImage();
    }
   
    private void editProduct() {
        if (!productValidator.isValidEdition()) return;
        
        if (!upload.handleUploadForEdit()) {
            ((EditProductHandler) editProductHandler).setProductImage("no-image.jpg");
            return;
        }
        
        ((EditProductHandler) editProductHandler).setProductImage(upload.image);
        ((EditProductHandler) editProductHandler).setProductId(productSelected.getProductId());
        editProductHandler.execute();
        productGrid.showAllProducts(1);
        safelyRebuildPagination(() -> pages.create());
        resetElements.resetEditForm();
        infoProductWindow.setVisible(false);
        editProductWindow.setVisible(false);
        upload.removeImage();
    }
    
    private void deactivateProduct() {
        if ( !deactivateProduct.isValidStatus(productSelected.getProductIsActive() ) ) return;
        if ( !deactivateProduct.confirmChange() ) return;
            
        int productId = productSelected.getProductId();
        deactivateProduct.change(productId);
        productGrid.showAllProducts(1);
        infoProductWindow.setVisible(false);
    }
    
    private void activateProduct() {
        if ( !activateProduct.isValidStatus(productSelected.getProductIsActive() ) ) return;
        if ( !activateProduct.confirmChange() ) return;
            
        int productId = productSelected.getProductId();
        activateProduct.change(productId);
        productGrid.showAllProducts(1);
        infoProductWindow.setVisible(false);
    }
    
    private void closeEditProductWindow() {
        infoProductWindow.setVisible(false);
        editProductWindow.setVisible(false);
        resetElements.resetEditForm();
        ((EditProductHandler) editProductHandler).setProductOldName(null);
        ((EditProductHandler) editProductHandler).setProductId(0);
        ((EditProductHandler) editProductHandler).setProductImage(null);
    }
    
    private void openEditProductWindow() {
        editProductWindow.setVisible(true);
            
        if ( productSelected != null ) {
            ((EditProductHandler) editProductHandler).setProductOldName(productSelected.getProductName());
            upload.image = productSelected.getProductImage(); 
            fillComboBoxes.categoriesEditBox(categories.getProductCategories());
            fillComboBoxes.suppliersEditBox(suppliers.getAll());
            resetElements.hideButtonUploadImage();
            loadEdit.load(productSelected);
        }
    }
    
    private void openInfoProduct(Product product) {
        productSelected = product;
        infoProductWindow.setVisible(true);
        loadInfo.load(product);
    }
    
    private void removeImage() {
        upload.removeImage();
        resetElements.showButtonUploadImage();
    }
    
    private void uploadImage( boolean isEdit ) {
        upload.load(isEdit);
        resetElements.hideButtonUploadImage();
    }
    
    private void closeCreateProductWindow() {
        resetElements.resetCreateForm();
        createProductWindow.setVisible(false);
        upload.removeImage();
    }
    
    private void changePage(SearchCriteriaEnum criteria) {
        int selectedPage = pages.getSelectedPage();
        
        switch ( criteria ) {
            case SearchCriteriaEnum.NONE -> productGrid.showAllProducts(selectedPage);
            case SearchCriteriaEnum.NAME -> productGrid.showProductsByName(filter.getProductNameSearched(), selectedPage);
            case SearchCriteriaEnum.PRODUCT_CATEGORY -> productGrid.showProductsByCategory(filter.getCategoryIDSelected(), selectedPage);
            case SearchCriteriaEnum.PRODUCT_SUPPLIER -> productGrid.showProductsBySupplier(filter.getSupplierCompanyName(), selectedPage);
            case SearchCriteriaEnum.STATUS -> productGrid.showProductsByStatus(filter.getStatusSelected(), selectedPage);
        }
    }
    
    private void openCreateProductWindow() {
        fillComboBoxes.categoriesCreateBox(categories.getProductCategories());
        fillComboBoxes.suppliersCreateBox(suppliers.getAll());
        resetElements.showButtonUploadImage();
        createProductWindow.setVisible(true);
    }
    
    private void safelyRebuildPagination(Runnable rebuildLogic) {
        ActionListener[] listeners = view.pageComboBox.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageComboBox.removeActionListener(l);
        }

        rebuildLogic.run();

        for (ActionListener l : listeners) {
            view.pageComboBox.addActionListener(l);
        }
    }
    
}
