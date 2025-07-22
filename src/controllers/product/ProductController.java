package controllers.product;

import interfaces.ChangeStatusNoTableInterface;
import services.ProductService;
import services.CategoryService;
import controllers.product.helpers.ChangeProductStatus;
import controllers.product.helpers.ViewElements;
import controllers.product.helpers.ProductGrid;
import controllers.product.helpers.FillComboBoxes;
import controllers.product.helpers.LoadInformation;
import controllers.product.helpers.UploadProductImage;
import controllers.product.helpers.Pages;
import controllers.product.helpers.ProductValidator;
import controllers.product.helpers.QuantityProducts;
import controllers.product.helpers.InputReader;
import entities.Product;
import java.awt.event.ActionListener;
import services.SupplierService;
import models.CategoryModel;
import models.ProductModel;
import models.SupplierModel;
import utils.enums.ModalTypeEnum;
import utils.enums.SearchCriteriaEnum;
import utils.helpers.Formatter;
import utils.helpers.GenerateReports;
import utils.helpers.Modal;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;
import views.warehouse.WarehouseInfoProduct;
import views.warehouse.WarehouseProducts;

public class ProductController {
    
    private final WarehouseProducts view;
    private final WarehouseInfoProduct infoView;
    private final WarehouseEditProduct editView;
    private final WarehouseCreateProduct createView;
    private final ProductModel model;
    private final CategoryModel categoryModel;
    private final SupplierModel supplierModel;
    private final ProductService productsService;
    private final CategoryService categoriesService;
    private final SupplierService suppliersService;
    private final Pages pages;
    private final UploadProductImage upload;
    private final FillComboBoxes fillComboBoxes;
    private final ProductGrid productGrid;
    private final ViewElements elements;
    private final InputReader inputReader;
    private final LoadInformation loadInfo;
    private final ChangeStatusNoTableInterface activateProduct;
    private final ChangeStatusNoTableInterface deactivateProduct;
    private final QuantityProducts quantity;
    private final ProductValidator validator;
    private Product productSelected;
    private SearchCriteriaEnum filterSelected = SearchCriteriaEnum.NONE;
    private final Modal modal = new Modal("Productos del sistema - PuntoCafé");
    private String image = null;
    
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
        
        this.infoView = new WarehouseInfoProduct();
        this.editView = new WarehouseEditProduct();
        this.createView = new WarehouseCreateProduct();
        
        this.productsService = new ProductService( this.model);
        this.categoriesService = new CategoryService(this.categoryModel);
        this.suppliersService = new SupplierService(this.supplierModel);
        
        this.pages = new Pages( view, productsService );
        this.inputReader = new InputReader(view, createView, editView);
        this.quantity = new QuantityProducts(view);
        this.upload = new UploadProductImage(createView, editView, modal);
        this.fillComboBoxes = new FillComboBoxes(createView, editView, view);
        this.productGrid = new ProductGrid(view, productsService, suppliersService);
        this.elements = new ViewElements(view, createView, editView);
        this.loadInfo = new LoadInformation(infoView, editView, categoriesService, suppliersService);
        this.validator = new ProductValidator(modal);
        this.activateProduct = new ChangeProductStatus(infoView, productsService, modal, true);
        this.deactivateProduct = new ChangeProductStatus(infoView, productsService, modal, false);
        
        init();
        initListeners();
    }
    
    private void init() {
        pages.create();
        quantity.setQuantity(productsService.getQuantityProducts());
        elements.showButtonUploadImage();
        fillComboBoxes.categoriesCreateBox(categoriesService.getProductCategories());
        fillComboBoxes.suppliersCreateBox(suppliersService.getAll());
        fillComboBoxes.categoriesFilterBox(categoriesService.getProductCategories());
        fillComboBoxes.suppliersFilterBox(suppliersService.getCompaniesUnique());
        fillComboBoxes.categoriesEditBox(categoriesService.getProductCategories());
        fillComboBoxes.suppliersEditBox(suppliersService.getAll());    
    }

    private void initListeners() {        
        view.btnNewProduct.addActionListener(e -> openCreateProductWindow());
        view.pageComboBox.addActionListener(e -> changePage(filterSelected));
        view.productCategoryCombo.addActionListener(e -> filterProductsByCategory());
        view.productSupplierCombo.addActionListener(e -> filterProductsBySupplierCompany());
        view.productStatusCombo.addActionListener(e -> filterProductsByStatus() );
        view.btnSearch.addActionListener(e -> filterProductsByName());
        view.btnExportProducts.addActionListener(e -> generateReport());
        view.btnReload.addActionListener(e -> seeAllProducts());
        
        createView.btnCancelSaveProduct.addActionListener(e -> closeCreateProductWindow());
        createView.btnLoadImage.addActionListener(e -> uploadImage(false));
        createView.btnRemoveImage.addActionListener(e -> removeImage());
        createView.btnSaveProduct.addActionListener(e -> saveProduct());
        
        infoView.btnEditProduct.addActionListener(e -> openEditProductWindow());
        infoView.btnActivate.addActionListener(e -> activateProduct());
        infoView.btnDeactivate.addActionListener(e -> deactivateProduct());
        
        editView.btnRemoveImage.addActionListener(e -> removeImage());
        editView.btnLoadImage.addActionListener(e -> uploadImage(true));
        editView.btnCancelEditProduct.addActionListener(e -> closeEditProductWindow());
        editView.btnUpdateProduct.addActionListener(e -> editProduct());
        
        productGrid.setOnProductClick(product -> openInfoProduct(product));
        
        productGrid.showAllProducts(1);
    }
    
    private void filterProductsByName() {
        String productNameSearched = inputReader.getProductNameSearched();
        
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
        String statusSelected = inputReader.getStatusSelected();
        if (statusSelected == null) return;
        
        safelyRebuildPagination(() -> pages.createByStatus(statusSelected));
        productGrid.showProductsByStatus(statusSelected, 1);
        filterSelected = SearchCriteriaEnum.STATUS;
    }
    
    private void filterProductsBySupplierCompany() {
        String supplierSelected = inputReader.getSupplierCompanyName();
        if ( supplierSelected == null ) return;
        
        safelyRebuildPagination(() -> pages.createBySuppliers(supplierSelected));
        productGrid.showProductsBySupplier(supplierSelected, 1);
        filterSelected = SearchCriteriaEnum.PRODUCT_SUPPLIER;
    }
    
    private void filterProductsByCategory() {
        String categorySelected = inputReader.getCategorySelected();
        if ( categorySelected == null ) return;
        
        int categoryId = categoriesService.getByName(categorySelected).getCategoryId();
        safelyRebuildPagination(() -> pages.createByCategories(categoryId));
        productGrid.showProductsByCategory(categoryId, 1);
        filterSelected = SearchCriteriaEnum.PRODUCT_CATEGORY;
    }
    
    private void saveProduct() {
        String productName = inputReader.getNameCreate();
        String productPrice = inputReader.getPriceCreate();
        String productStock = inputReader.getStockCreate();
        String productStockMin = inputReader.getStockMinCreate();
        String productDesc = inputReader.getDescriptionCreate();
        String categorySelected = inputReader.getCategorySelectedCreate();
        String supplierSelected = inputReader.getSupplierSelectedCreate();
        
        if ( !validator.isValidForm(productName, productPrice, productStock, productStockMin, productDesc, categorySelected, supplierSelected)) return;
        
        if (!upload.handleUploadForCreate()) {
            image = "no-image.jpg";
            return;
        }
        image = upload.image;
        
        if ( productsService.getProductByName(productName) != null ) {
            modal.show("El producto ya existe", ModalTypeEnum.error);
            return;
        }
        
        int categoryId = categoriesService.getByName(categorySelected).getCategoryId();
        String supplierName = Formatter.extractName(supplierSelected);
        int supplierId = suppliersService.getByName(supplierName).getSupplierId();
        
        Product product = new Product(productName, productDesc, image, Double.valueOf(productPrice), Integer.parseInt(productStock), Integer.parseInt(productStockMin), categoryId, supplierId);
        
        if ( !productsService.saveProduct(product) ) {
            modal.show("El producto no pudo ser creado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El producto ha sido creado exitosamente", ModalTypeEnum.success);
        productGrid.showAllProducts(1);
        safelyRebuildPagination(() -> pages.create());
        quantity.setQuantity(productsService.getQuantityProducts());
        elements.resetCreateForm();
        createView.dispose();
        upload.removeImage();
    }
   
    private void editProduct() {
        String productName = inputReader.getNameEdition();
        String productPrice = inputReader.getPriceEdition();
        String productStock = inputReader.getStockEdition();
        String productStockMin = inputReader.getStockMinEdition();
        String productDesc = inputReader.getDescriptionEdition();
        String categorySelected = inputReader.getCategorySelectedEdition();
        String supplierSelected = inputReader.getSupplierSelectedEdition();
        
        if ( !validator.isValidForm(productName, productPrice, productStock, productStockMin, productDesc, categorySelected, supplierSelected)) return;
        
        if (!upload.handleUploadForEdit()) {
            image = "no-image.jpg";
            return;
        }
        image = upload.image;
        
        Product existingProduct = productsService.getProductByName(productName);
        int productId = productSelected.getProductId();
        String oldProductName = productSelected.getProductName();
        
        if ( !productName.equals(oldProductName) && existingProduct != null && existingProduct.getProductId()!= productId ) {
            modal.show("El producto ya existe", ModalTypeEnum.error);
            return;
        }
        
        int categoryId = categoriesService.getByName(categorySelected).getCategoryId();
        String supplierName = Formatter.extractName(supplierSelected);
        int supplierId = suppliersService.getByName(supplierName).getSupplierId();
        
        Product product = new Product(productName, productDesc, image, Double.valueOf(productPrice), Integer.parseInt(productStock), Integer.parseInt(productStockMin), categoryId, supplierId);
        
        if ( !productsService.updateProduct(product, productId) ) {
            modal.show("El producto no pudo ser actualizado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El producto ha sido actualizado exitosamente", ModalTypeEnum.success);
        productGrid.showAllProducts(1);
        safelyRebuildPagination(() -> pages.create());
        elements.resetEditForm();
        infoView.dispose();
        editView.dispose();
        upload.removeImage();
    }
    
    private void deactivateProduct() {
        if ( !deactivateProduct.isValidStatus(productSelected.getProductIsActive() ) ) return;
        if ( !deactivateProduct.confirmChange() ) return;
            
        int productId = productSelected.getProductId();
        deactivateProduct.change(productId);
        productGrid.showAllProducts(1);
        infoView.setVisible(false);
    }
    
    private void activateProduct() {
        if ( !activateProduct.isValidStatus(productSelected.getProductIsActive() ) ) return;
        if ( !activateProduct.confirmChange() ) return;
            
        int productId = productSelected.getProductId();
        activateProduct.change(productId);
        productGrid.showAllProducts(1);
        infoView.dispose();
    }
    
    private void closeEditProductWindow() {
        infoView.dispose();
        editView.dispose();
        elements.resetEditForm();
        image = null;
    }
    
    private void openEditProductWindow() {
        editView.setVisible(true);
        upload.image = productSelected.getProductImage(); 
        fillComboBoxes.categoriesEditBox(categoriesService.getProductCategories());
        fillComboBoxes.suppliersEditBox(suppliersService.getAll());
        elements.hideButtonUploadImage();
        loadInfo.loadProductEdit(productSelected);
    }
    
    private void openInfoProduct(Product product) {
        productSelected = product;
        infoView.setVisible(true);
        loadInfo.loadProductInfo(product);
    }
    
    private void removeImage() {
        upload.removeImage();
        elements.showButtonUploadImage();
    }
    
    private void uploadImage( boolean isEdit ) {
        upload.load(isEdit);
        elements.hideButtonUploadImage();
    }
    
    private void closeCreateProductWindow() {
        elements.resetCreateForm();
        createView.setVisible(false);
        upload.removeImage();
    }
    
    private void seeAllProducts() {
        safelyRebuildPagination(() -> pages.create());
        filterSelected = SearchCriteriaEnum.NONE;
        productGrid.showAllProducts(1);
        elements.clearSearchProduct();
    }
    
    private void changePage(SearchCriteriaEnum criteria) {
        int selectedPage = pages.getSelectedPage();
        
        switch ( criteria ) {
            case SearchCriteriaEnum.NONE -> productGrid.showAllProducts(selectedPage);
            case SearchCriteriaEnum.NAME -> productGrid.showProductsByName(inputReader.getProductNameSearched(), selectedPage);
            case SearchCriteriaEnum.PRODUCT_CATEGORY -> {
                int categoryId = categoriesService.getByName(inputReader.getCategorySelected()).getCategoryId();
                productGrid.showProductsByCategory(categoryId, selectedPage);
            }
            case SearchCriteriaEnum.PRODUCT_SUPPLIER -> productGrid.showProductsBySupplier(inputReader.getSupplierCompanyName(), selectedPage);
            case SearchCriteriaEnum.STATUS -> productGrid.showProductsByStatus(inputReader.getStatusSelected(), selectedPage);
        }
    }
    
    private void openCreateProductWindow() {
        fillComboBoxes.categoriesCreateBox(categoriesService.getProductCategories());
        fillComboBoxes.suppliersCreateBox(suppliersService.getAll());
        elements.showButtonUploadImage();
        createView.setVisible(true);
    }

    private void generateReport() {
        GenerateReports.generateReport("products-report", "Reporte de productos");
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
