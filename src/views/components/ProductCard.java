package views.components;

import entities.Product;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utils.constants.ViewConstants;

public class ProductCard {

    private final ImageCustom imageGenerator = new ImageCustom();

    public JPanel create(
            String name, 
            String category, 
            String supplier, 
            String price, 
            String img, 
            boolean status,
            Product product, 
            Consumer<Product> onClick
    ) {
        
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(140, 170));
        card.setBackground( Color.WHITE );
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        imageGenerator.addImageProduct( imageLabel, status ? img : "image-disabled.png", 100, 100);
        
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel supplierLabel = new JLabel("(" + supplier + ")");
        supplierLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        supplierLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel priceLabel = new JLabel("$" + price + "0");
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        priceLabel.setForeground(Color.decode(ViewConstants.mainColor));
        priceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        card.add(Box.createVerticalStrut(3));
        card.add(imageLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(nameLabel);
        card.add(supplierLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(priceLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(Box.createVerticalGlue());
        
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( onClick != null ) {
                    onClick.accept(product);
                }
            }
        });

        return card;
    }
}
