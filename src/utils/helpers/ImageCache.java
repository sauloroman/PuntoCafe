package utils.helpers;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public final class ImageCache {

    private static final Map<String, ImageIcon> CACHE = new HashMap<>();

    public static ImageIcon getImage(String path, int width, int height) {
        String key = path + "_" + width + "x" + height;

        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        } else {
            java.net.URL url = ImageCache.class.getResource(path);
            if (url == null) {
                System.err.println("❌ No se encontró la imagen: " + path);
                return null;
            }

            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            CACHE.put(key, scaledIcon);
            return scaledIcon;
        }
    }
    
    public static void removeImage(String key) {
        CACHE.remove(key);
    }

    public static ImageIcon getResourceImage(String resourcePath, int width, int height) {
        String key = resourcePath + "_" + width + "x" + height;

        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        } else {
            ImageIcon icon = new ImageIcon(ImageCache.class.getResource(resourcePath));
            Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(image);
            CACHE.put(key, scaledIcon);
            return scaledIcon;
        }
    }
}
