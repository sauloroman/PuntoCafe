package controllers.product;

import controllers.interfaces.ChangeStatusNoTableInterface;
import services.ProductService;
import services.CategoryService;
import controllers.interfaces.HandlerController;
import controllers.product.handlers.ChangeProductStatusHandler;
import controllers.product.handlers.EditProductHandler;
import controllers.product.handlers.SaveProductHandler;
import controllers.product.helpers.ResetElements;
import controllers.product.helpers.ProductGrid;
import controllers.product.helpers.FillComboBoxes;
import controllers.product.helpers.LoadEditInformation;
import controllers.product.helpers.LoadInformationProduct;
import controllers.product.helpers.UploadProductImage;
import controllers.product.helpers.Pages;
import entities.Product;
import java.awt.event.ActionListener;
import services.SupplierService;
import models.CategoryModel;
import models.ProductModel;
import models.SupplierModel;
import utils.enums.ModalTypeEnum;
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
    private final Modal modal = new Modal("Productos del sistema - PuntoCafé");
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
    private final HandlerController saveProductHandler;
    private final HandlerController editProductHandler;
    private Product productSelected;
    
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
        this.productGrid = new ProductGrid(view, products, categories, suppliers);
        this.resetElements = new ResetElements(createProductWindow, editProductWindow);
        this.loadInfo = new LoadInformationProduct(infoProductWindow, categories, suppliers);
        this.loadEdit = new LoadEditInformation(editProductWindow, categories, suppliers);
        this.activateProduct = new ChangeProductStatusHandler(infoProductWindow, products, modal, true);
        this.deactivateProduct = new ChangeProductStatusHandler(infoProductWindow, products, modal, false);
        
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
        view.pageComboBox.addActionListener(e -> changePage());
        
        createProductWindow.btnCancelSaveProduct.addActionListener(e -> closeCreateProductWindow());
        createProductWindow.btnLoadImage.addActionListener(e -> uploadImage());
        createProductWindow.btnRemoveImage.addActionListener(e -> removeImage());
        createProductWindow.btnSaveProduct.addActionListener(e -> createProduct());
        
        infoProductWindow.btnEditProduct.addActionListener(e -> openEditProductWindow());
        infoProductWindow.btnActivate.addActionListener(e -> activateProduct());
        infoProductWindow.btnDeactivate.addActionListener(e -> deactivateProduct());
        
        editProductWindow.btnRemoveImage.addActionListener(e -> removeImage());
        editProductWindow.btnLoadImage.addActionListener(e -> uploadImage());
        editProductWindow.btnCancelEditProduct.addActionListener(e -> closeEditProductWindow());
        editProductWindow.btnUpdateProduct.addActionListener(e -> editProduct());
        
        productGrid.setOnProductClick(product -> openInfoProduct(product));
        
        productGrid.create(1);
    }
    
   
    private void editProduct() {
        
        if ( !upload.image.equals("no-image.jpg") ){
            boolean uploaded = upload.upload();
            
            if ( !uploaded ) {
                ((EditProductHandler) editProductHandler).setProductImage("no-image.jpg");
                modal.show("No se pudo subir la imagen. Intente de nuevo", ModalTypeEnum.error);
                return;
            }
            
            ((EditProductHandler) editProductHandler).setProductImage(upload.image);
        }
        
        ((EditProductHandler) editProductHandler).setProductId(productSelected.getProductId());
        editProductHandler.execute();
        productGrid.create(1);
        safelyRebuildPagination(pages);
        resetElements.resetCreateForm();
    }
    
    private void deactivateProduct() {
        if ( !deactivateProduct.isValidStatus(productSelected.getProductIsActive() ) ) return;
        if ( !deactivateProduct.confirmChange() ) return;
            
        int productId = productSelected.getProductId();
        deactivateProduct.change(productId);
        productGrid.create(1);
        infoProductWindow.setVisible(false);
    }
    
    private void activateProduct() {
        if ( !activateProduct.isValidStatus(productSelected.getProductIsActive() ) ) return;
        if ( !activateProduct.confirmChange() ) return;
            
        int productId = productSelected.getProductId();
        activateProduct.change(productId);
        productGrid.create(1);
        infoProductWindow.setVisible(false);
    }
    
    private void closeEditProductWindow() {
        resetElements.resetEditForm();
        editProductWindow.setVisible(false);
    }
    
    private void openEditProductWindow() {
        editProductWindow.setVisible(true);
            
        if ( productSelected != null ) {
            fillComboBoxes.categoriesCreateBox(categories.getProductCategories());
            fillComboBoxes.suppliersCreateBox(suppliers.getAll());
            resetElements.hideButtonUploadImage();
            loadEdit.load(productSelected);
        }
    }
    
    private void openInfoProduct(Product product) {
        productSelected = product;
        infoProductWindow.setVisible(true);
        loadInfo.load(product);
    }
    
    private void createProduct() {
        
        if ( !upload.image.equals("no-image.jpg") ){
            boolean uploaded = upload.upload();
            
            if ( !uploaded ) {
                ((SaveProductHandler) saveProductHandler).setProductImage("no-image.jpg");
                modal.show("No se pudo subir la imagen. Intente de nuevo", ModalTypeEnum.error);
                return;
            }
            
            ((SaveProductHandler) saveProductHandler).setProductImage(upload.image);
        }
            
        saveProductHandler.execute();
        productGrid.create(1);
        safelyRebuildPagination(pages);
        resetElements.resetCreateForm();
    }
    
    private void removeImage() {
        upload.removeImage();
        resetElements.showButtonUploadImage();
    }
    
    private void uploadImage() {
        upload.load();
        resetElements.hideButtonUploadImage();
    }
    
    private void closeCreateProductWindow() {
        resetElements.resetCreateForm();
        createProductWindow.setVisible(false);
        upload.removeImage();
    }
    
    private void changePage() {
        int selectedPage = pages.getSelectedPage();
        productGrid.create(selectedPage);
    }
    
    private void openCreateProductWindow() {
        fillComboBoxes.categoriesCreateBox(categories.getProductCategories());
        fillComboBoxes.suppliersCreateBox(suppliers.getAll());
        resetElements.showButtonUploadImage();
        createProductWindow.setVisible(true);
    }
    
    private void safelyRebuildPagination(Pages pages) {
        ActionListener[] listeners = view.pageComboBox.getActionListeners();
        for (ActionListener l : listeners) {
            view.pageComboBox.removeActionListener(l);
        }

        pages.create();

        for (ActionListener l : listeners) {
            view.pageComboBox.addActionListener(l);
        }
    }
    
}
