package views.purchases;

import javax.swing.WindowConstants;
import utils.constants.ViewConstants;
import views.components.Button;
import views.components.ImageCustom;
import views.components.Input;

public class PurchasesCreateSupplierInit {
    
    private final PurchasesCreateSupplier view;
    private final Button buttonGenerator = new Button(); 
    private final ImageCustom imageGenerator = new ImageCustom();
    private final Input inputGenerator = new Input();

    public PurchasesCreateSupplierInit(PurchasesCreateSupplier view) {
        this.view = view;
    }
    
    public void init() {
        
        view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        view.setResizable(false);
        
        buttonGenerator.solidButton(view.btnSaveSupplier, ViewConstants.skyColor, "#FFFFFF", 12);
        buttonGenerator.addIcon(view.btnSaveSupplier, "icon-save", 20);
        buttonGenerator.outlineButton(view.btnCancelSaveSupplier, ViewConstants.errorColor, ViewConstants.errorColor);
        buttonGenerator.addIcon(view.btnCancelSaveSupplier, "icon-left-red", 20);
        buttonGenerator.outlineButton(view.btnNewCompany, "#DDDDDD", ViewConstants.textBtn);
        
        inputGenerator.roundedField(view.supplierNameTxt, "#DDDDDD", 10, "Ingrese nombre de proveedor");
        inputGenerator.roundedField(view.supplierLastnameTxt, "#DDDDDD", 10, "Ingrese apellido de proveedor");
        inputGenerator.roundedField(view.supplierPhoneTxt, "#DDDDDD", 10, "");
        inputGenerator.roundedField(view.supplierEmailTxt, "#DDDDDD", 10, "proveedor@correo.com");
        inputGenerator.roundedField(view.supplierAddressTxt, "#DDDDDD", 10, "Ingrese la dirección del proveedor");
        inputGenerator.roundedField(view.supplierCompanyNameTxt, "#DDDDDD", 10, "Ingrese el nombre de la empresa");
        inputGenerator.roundedComboBox(view.suppleirCompaniesCombo, "#DDDDDD", 10);
        
        imageGenerator.addImageFix(view.iconRH, "logo-rh", 50, 50);
        imageGenerator.addImageFix(view.iconInputMandatory, "icon-lock", 16, 16);
        imageGenerator.addImageFix(view.iconInputMandatory2, "icon-lock", 16, 16);
        imageGenerator.addImageFix(view.iconInputMandatory3, "icon-lock", 16, 16);
        imageGenerator.addImageFix(view.iconInputMandatory4, "icon-lock", 16, 16);
    }
    
}
