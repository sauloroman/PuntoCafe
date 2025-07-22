package views.components;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
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
    
    public void addImageUser(JLabel box, String nameImage, int maxWidth, int maxHeight) {
        ImageIcon icon = new ImageIcon("assets/images/users/" + nameImage);
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

    public void addImageDish(JLabel box, String nameImage, int maxWidth, int maxHeight) {
        ImageIcon icon = new ImageIcon("assets/images/dishes/" + nameImage);
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
    
    public void roundedImage(JLabel box) {
        ImageIcon icon = (ImageIcon) box.getIcon();
        if (icon == null) return;

        Image image = icon.getImage();
        int width = icon.getIconWidth();
        int height = icon.getIconHeight();

        BufferedImage rounded = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = rounded.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape circle = new Ellipse2D.Double(0, 0, width, height);
        g2.setClip(circle);
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();

        box.setIcon(new ImageIcon(rounded));
    }
    
}
