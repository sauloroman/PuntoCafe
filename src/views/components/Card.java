package views.components;

import entities.Dish;
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

public class Card {

    private final ImageCustom imageGenerator = new ImageCustom();

    public JPanel createProduct( 
            String supplier, 
            Product product, 
            Consumer<Product> onClick
    ) {
        
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(140, 170));
        card.setBackground( Color.WHITE );
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        String image = "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage();
        imageGenerator.addImageProduct( imageLabel, product.getProductIsActive() ? image : "image-disabled.png", 90, 90);
        
        JLabel nameLabel = new JLabel(product.getProductName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel supplierLabel = new JLabel("(" + supplier + ")");
        supplierLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        supplierLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel priceLabel = new JLabel("$" + product.getProductSellingPrice() + "0");
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
    
    public JPanel createDish(
            String category,
            Dish dish,
            Consumer<Dish> onClick
    ) {
        
         JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(140, 170));
        card.setBackground( Color.WHITE );
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        String image = "Platillo sin imagen".equals(dish.getDishImage()) ? "no-image.jpg" : dish.getDishImage();
        imageGenerator.addImageDish(imageLabel, dish.getIsActive() ? image : "image-disabled.png", 90, 90);
        
        JLabel nameLabel = new JLabel(dish.getDishName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JLabel categoryLabel = new JLabel(category);
        categoryLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
        categoryLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        JLabel priceLabel = new JLabel("$" + dish.getDishSellingPrice() + "0");
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        priceLabel.setForeground(Color.decode(ViewConstants.mainColor));
        priceLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        card.add(Box.createVerticalStrut(3));
        card.add(imageLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(nameLabel);
        card.add(categoryLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(priceLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(Box.createVerticalGlue());
        
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ( onClick != null ) {
                    onClick.accept(dish);
                }
            }
        });
        
        return card;
    }
    
}
