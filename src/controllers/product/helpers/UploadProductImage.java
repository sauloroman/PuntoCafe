package controllers.product.helpers;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import utils.enums.ModalTypeEnum;
import utils.helpers.Modal;
import views.components.ImageCustom;
import views.warehouse.WarehouseCreateProduct;
import views.warehouse.WarehouseEditProduct;

public class UploadProductImage {
    
    private final WarehouseCreateProduct view;
    private final WarehouseEditProduct viewEdit;
    private final Modal modal;
    private final String DIRECTORY = "assets/images/products/";
    private final ImageCustom imageGenerator = new ImageCustom();
    
    private String originRoot;
    private String destinyRoot;
    public String image = "";
    public String oldImage = "";
    
    public UploadProductImage( WarehouseCreateProduct view, WarehouseEditProduct viewEdit, Modal modal ) {
        this.view = view;
        this.modal = modal;
        this.viewEdit = viewEdit;
    }
    
    public boolean upload() {
        
        File origin = new File(originRoot);
        File destiny = new File(destinyRoot);
        
        try (
            InputStream input = new FileInputStream(origin);
            OutputStream output = new FileOutputStream(destiny);    
        ) {
            
            byte[] buff = new byte[1024];
            int len;
            
            while ( (len = input.read(buff)) > 0 ) {
                output.write(buff, 0, len);
            }
            
            output.flush();
            return true;
            
        } catch(IOException e) {
            modal.show("No se pudo subir la imagen", ModalTypeEnum.error);
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public void load() {
        JFileChooser file = new JFileChooser();
        int status = file.showOpenDialog(null);
        
        if ( status == JFileChooser.APPROVE_OPTION ) {
            image = file.getSelectedFile().getName();
            originRoot = file.getSelectedFile().getAbsolutePath();
            destinyRoot = DIRECTORY + image;
            
            ImageIcon img = new ImageIcon(originRoot);
            Icon icon = new ImageIcon( img.getImage().getScaledInstance(
                    view.productImageLabel.getWidth(), 
                    view.productImageLabel.getHeight(), 
                    Image.SCALE_DEFAULT)
            );
            
            view.productImageLabel.setIcon(icon);
            viewEdit.productEditImageLabel.setIcon(icon);
            view.productImageLabel.repaint();
            viewEdit.productEditImageLabel.repaint();
        }
    }
    
    public void removeImage() {
        image = "";
        imageGenerator.addImageProduct(view.productImageLabel, "no-image.jpg", 200, 200);
        imageGenerator.addImageProduct(viewEdit.productEditImageLabel, "no-image.jpg", 200, 200);
    }
    
    
}
