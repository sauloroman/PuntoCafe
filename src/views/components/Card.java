package views.components;

import entities.Dish;
import entities.Product;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
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
    
    public JPanel createModernProductCard(
        Product product,
        Consumer<Product> onClick
    ) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(140, 155));
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setBorder(javax.swing.BorderFactory.createLineBorder(Color.decode("#FFFFFF")));

        // Panel superior para imagen y nombre
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        String image = "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage();
        imageGenerator.addImageProduct(imageLabel, product.getProductIsActive() ? image : "image-disabled.png", 65, 65);

        JLabel nameLabel = new JLabel(product.getProductName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(imageLabel);
        topPanel.add(Box.createVerticalStrut(10));
        topPanel.add(nameLabel);

        card.add(topPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel priceLabel = new JLabel("$" + product.getProductSellingPrice());
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        priceLabel.setForeground(Color.BLACK);

        JPanel addButton = new JPanel();
        addButton.setBackground(new Color(135, 206, 250)); 
        addButton.setPreferredSize(new Dimension(30, 30));
        JLabel plus = new JLabel("+");
        plus.setForeground(Color.WHITE);
        plus.setFont(new Font("SansSerif", Font.BOLD, 16));
        addButton.add(plus);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onClick != null) {
                    onClick.accept(product);
                }
            }
        });

        bottomPanel.add(priceLabel, BorderLayout.WEST);
        bottomPanel.add(addButton, BorderLayout.EAST);

        card.add(bottomPanel, BorderLayout.SOUTH);

        return card;
    }

    public JPanel createSaleItemCard(
        Product product,
        int quantity,
        double discount,
        Consumer<Integer> onDelete 
    ) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(300, 80));
        card.setPreferredSize(new Dimension(300, 80));
        card.setMinimumSize(new Dimension(300, 80));
        card.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        card.setBorder(javax.swing.BorderFactory.createLineBorder(Color.decode("#FFFFFF"), 1, true));

        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(70, 70));
        String image = "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage();
        imageGenerator.addImageProduct(imageLabel, image, 70, 70);

        card.add(imageLabel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(product.getProductName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setForeground(Color.decode("#222222"));

        JPanel priceDiscountPanel = new JPanel();
        priceDiscountPanel.setLayout(new BoxLayout(priceDiscountPanel, BoxLayout.X_AXIS));
        priceDiscountPanel.setBackground(Color.WHITE);

        JLabel priceLabel = new JLabel("$" + product.getProductSellingPrice());
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        priceDiscountPanel.add(priceLabel);

        if (discount > 0) {
            JLabel discountLabel = new JLabel(" -$" + String.format("%.2f", discount));
            discountLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
            discountLabel.setForeground(Color.RED);
            discountLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0)); 
            priceDiscountPanel.add(discountLabel);
        }

        centerPanel.add(Box.createVerticalStrut(8));
        centerPanel.add(nameLabel);
        centerPanel.add(Box.createVerticalStrut(5));
        centerPanel.add(priceDiscountPanel);

        card.add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));

        JLabel quantityLabel = new JLabel(" x" + quantity + " ");
        quantityLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel deleteLabel = new JLabel("🗑️"); 
        deleteLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        deleteLabel.setForeground(Color.decode("#FF0000"));
        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        deleteLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onDelete != null) {
                    onDelete.accept(product.getProductId()); 
                }
            }
        });

        rightPanel.add(quantityLabel);
        rightPanel.add(deleteLabel);

        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }    

}
