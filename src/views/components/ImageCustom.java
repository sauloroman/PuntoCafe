package views.components;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public final class ImageCustom {
    
    public void addImage(JLabel box, String nameImage, int sizeImage ) {
        String pathImage = "/views/images/" + nameImage + ".png";
        ImageIcon logo = new ImageIcon( getClass().getResource(pathImage));
        java.awt.Image image = logo.getImage().getScaledInstance(sizeImage, sizeImage, java.awt.Image.SCALE_SMOOTH);
        ImageIcon logoImage = new ImageIcon( image );
        box.setIcon(logoImage);
    }
    
    public void addImageFix(JLabel box, String nameImage, int maxWidth, int maxHeight) {
        String pathImage = "/views/images/" + nameImage + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(pathImage));
        Image image = icon.getImage();

        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        double widthRatio = (double) maxWidth / originalWidth;
        double heightRatio = (double) maxHeight / originalHeight;
        double ratio = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (originalWidth * ratio);
        int newHeight = (int) (originalHeight * ratio);

        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        box.setIcon(new ImageIcon(scaledImage));
    }
    
    public void addImageProduct(JLabel box, String nameImage, int maxWidth, int maxHeight) {
        ImageIcon icon = new ImageIcon("assets/images/products/" + nameImage);
        Image image = icon.getImage();

        int originalWidth = image.getWidth(null);
        int originalHeight = image.getHeight(null);

        double widthRatio = (double) maxWidth / originalWidth;
        double heightRatio = (double) maxHeight / originalHeight;
        double ratio = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (originalWidth * ratio);
        int newHeight = (int) (originalHeight * ratio);

        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        box.setIcon(new ImageIcon(scaledImage));
    }

    
}
