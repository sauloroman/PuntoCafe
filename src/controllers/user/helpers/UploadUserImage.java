package controllers.user.helpers;

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
import views.access.AccessCreateUser;
import views.access.AccessEditUser;
import views.components.ImageCustom;

public class UploadUserImage {
    
    private final AccessCreateUser createView;
    private final AccessEditUser editView;
    private final Modal modal;
    private final String DIRECTORY = "assets/images/users/";
    private final ImageCustom imageGenerator = new ImageCustom();
    
    private String originRoot;
    private String destinyRoot;
    public String image = "no-image.jpg";
    
    public UploadUserImage( AccessCreateUser createView, AccessEditUser editView, Modal modal ) {
        this.createView = createView;
        this.editView = editView;
        this.modal = modal;
    }
    
    public boolean upload() {
        if (originRoot == null || destinyRoot == null || image == null || image.isBlank()) {
            return false;
        }
        
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
    
    public boolean handleUploadForCreate() {
        System.out.println(image);
        
        if ( !image.equals("no-image.jpg") ) {
            if ( !upload() ) {
                modal.show("No se pudo subir la imagen. Intente de nuevo", ModalTypeEnum.error );
                return false;
            }
        } else {
            image = "no-image.jpg";
        }
        
        return true;
    }
    
    public boolean handleUploadForEdit() {
        if ( !image.equals("no-image.jpg")  && originRoot != null && destinyRoot != null ) {
            if ( !upload() ) {
                modal.show("No se pudo subir la imagen. Intente de nuevo", ModalTypeEnum.error );
                return false;
            }
        }
        return true;
    }
    
    public void load(boolean isEdit) {
        JFileChooser file = new JFileChooser();
        int status = file.showOpenDialog(null);
        
        if ( status == JFileChooser.APPROVE_OPTION ) {
            image = file.getSelectedFile().getName();
            originRoot = file.getSelectedFile().getAbsolutePath();
            destinyRoot = DIRECTORY + image;
            
            ImageIcon img = new ImageIcon(originRoot);
            Icon icon = new ImageIcon( img.getImage().getScaledInstance(
                    createView.userImageLabel.getWidth(), 
                    createView.userImageLabel.getHeight(), 
                    Image.SCALE_DEFAULT)
            );
            
            if ( isEdit ) {
                editView.userImageLabel.setIcon(icon);
                editView.userImageLabel.repaint();
            } else {
                createView.userImageLabel.setIcon(icon);
                createView.userImageLabel.repaint();
            }
        }
    }
    
    public void removeImage() {
        image = "no-image.jpg";
        originRoot = null;
        destinyRoot = null;
        imageGenerator.addImageDish(createView.userImageLabel, "no-image.jpg", 150, 150);
        imageGenerator.addImageProduct(editView.userImageLabel, "no-image.jpg", 150, 150);
    }
    
}
