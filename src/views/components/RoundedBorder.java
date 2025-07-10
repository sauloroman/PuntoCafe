package views.components;

import java.awt.*;
import javax.swing.border.Border;

public class RoundedBorder implements Border {
    
    private final Color color;
    private final int radius;
    
    public RoundedBorder( Color color, int radius ) {
        this.color = color;
        this.radius = radius;
    }
    
    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(color);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(4, 8, 4, 8);
    }
}