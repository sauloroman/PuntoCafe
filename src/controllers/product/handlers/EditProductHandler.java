package controllers.product.handlers;

import controllers.interfaces.HandlerController;
import entities.Category;
import entities.Product;
import entities.Supplier;
import services.CategoryService;
import services.ProductService;
import services.SupplierService;
import utils.enums.ModalTypeEnum;
import utils.helpers.Formatter;
import utils.helpers.Modal;
import views.warehouse.WarehouseEditProduct;

public class EditProductHandler implements HandlerController {
    
    private final WarehouseEditProduct view;
    private final Modal modal;
    private final CategoryService categorieService;
    private final SupplierService suppliersService;
    private final ProductService productsService;
    private String image = null;
    private int productId = 0;
    private String productOldName = null; 

    public EditProductHandler(
            WarehouseEditProduct view, 
            CategoryService categorieService,
            SupplierService suppliersService,
            ProductService productsService,
            Modal modal
    ) {
        this.view = view;
        this.categorieService = categorieService;
        this.suppliersService = suppliersService;
        this.productsService = productsService;
        this.modal = modal;
    }

    @Override
    public void execute() {
        
        String productName = view.productEditNameTxt.getText().trim();
        Double productPrice = Double.valueOf(view.productEditPriceTxt.getText());
        int stock = Integer.parseInt(view.productEditStockTxt.getText());
        int stockMin = Integer.parseInt(view.productEditStockMinTxt.getText());
        String productDescription = view.productEditDescriptionTxt.getText();
        
        String categorySelected = view.productEditCategoryCombo.getSelectedItem().toString();
        Category category = categorieService.getByName(categorySelected);
        int categoryId = category.getCategoryId();
        
        String supplierSelected = view.productEditSupplierCombo.getSelectedItem().toString();
        String supplierName = Formatter.extractName(supplierSelected);
        Supplier supplier = suppliersService.getByName(supplierName);
        int supplierId = supplier.getSupplierId();

        Product existingProduct = productsService.getProductByName(productName);
         
        if ( !productName.equals( productOldName ) && existingProduct != null && existingProduct.getProductId() != productId ) {
            modal.show("El producto ya existe", ModalTypeEnum.error);
            return;
        }
        
        Product product = new Product(
                productName,
                productDescription,
                image,
                productPrice,
                stock,
                stockMin,
                categoryId,
                supplierId
        );
        
        if ( !productsService.updateProduct(product, productId) ) {
            modal.show("El producto no pudo ser actualizado", ModalTypeEnum.error);
            return;
        }
        
        modal.show("El producto ha sido actualizado exitosamente", ModalTypeEnum.success);        
    }
    
    public void setProductOldName( String oldName ) {
        productOldName = oldName;
    }
    
    public void setProductId( int id ) {
        productId = id;
    }

    public void setProductImage(String productImage) {
        image = productImage;
    }
    
}
