package views.components;

import entities.Dish;
import entities.Menu;
import entities.Product;
import entities.PurchaseItem;
import interfaces.SaleItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
        imageGenerator.addImageProduct( imageLabel, product.getProductIsActive() ? image : "image-disabled.png", 85, 85);
        
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
        imageGenerator.addImageDish(imageLabel, dish.getIsActive() ? image : "image-disabled.png", 75, 75);
        
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
        card.setMaximumSize(new Dimension(200, 150));
        card.setPreferredSize(new Dimension(200, 150));
        card.setMinimumSize(new Dimension(200, 150));
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setBorder(javax.swing.BorderFactory.createLineBorder(Color.decode("#FFFFFF")));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        String image = "Producto sin imagen".equals(product.getProductImage()) ? "no-image.jpg" : product.getProductImage();
        imageGenerator.addImageProduct(imageLabel, product.getProductIsActive()? image : "image-disabled.png", 65, 65);

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
    
    public JPanel cartWrapper(JPanel card) {
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        wrapper.setOpaque(false);
        wrapper.setPreferredSize(card.getPreferredSize());
        wrapper.add(card);
        return wrapper;
    }
    
    public JPanel createModernDishCard(
        Dish dish,
        Consumer<Dish> onClick
    ) {
        JPanel card = new JPanel();
        card.setMaximumSize(new Dimension(200, 150));
        card.setPreferredSize(new Dimension(200, 150));
        card.setMinimumSize(new Dimension(200, 150));
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.WHITE);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        String image = "Producto sin imagen".equals(dish.getDishImage()) ? "no-image.jpg" : dish.getDishImage();
        imageGenerator.addImageDish(imageLabel, dish.getIsActive()? image : "image-disabled.png", 65, 65);

        JLabel nameLabel = new JLabel(dish.getDishName());
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

        JLabel priceLabel = new JLabel("$" + dish.getDishSellingPrice());
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
                    onClick.accept(dish);
                }
            }
        });

        bottomPanel.add(priceLabel, BorderLayout.WEST);
        bottomPanel.add(addButton, BorderLayout.EAST);

        card.add(bottomPanel, BorderLayout.SOUTH);

        return card;
    }

    public JPanel createSaleItemCard(
        SaleItem item,
        int quantity,
        double discount,
        String type,
        Consumer<SaleItem> onDelete 
    ) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(300, 80));
        card.setPreferredSize(new Dimension(300, 80));
        card.setMinimumSize(new Dimension(300, 80));
        card.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        
        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(70, 70));
        String image = "Producto sin imagen".equals(item.getImage()) ? "no-image.jpg" : item.getImage();
        
        if ( type.equals("Producto") ) {
            imageGenerator.addImageProduct(imageLabel, image, 70, 70);
        } else {
            imageGenerator.addImageDish(imageLabel, image, 70, 70);
        }

        card.add(imageLabel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(item.getName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setForeground(Color.decode("#222222"));

        JPanel priceDiscountPanel = new JPanel();
        priceDiscountPanel.setLayout(new BoxLayout(priceDiscountPanel, BoxLayout.X_AXIS));
        priceDiscountPanel.setBackground(Color.WHITE);

        JLabel priceLabel = new JLabel("$" + item.getSellingPrice());
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
                    onDelete.accept(item); 
                }
            }
        });

        rightPanel.add(quantityLabel);
        rightPanel.add(deleteLabel);

        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }    
    
    public JPanel createMinimalSaleItemCard(
        PurchaseItem item,
        Consumer<PurchaseItem> onDelete
    ) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(290, 50));
        card.setPreferredSize(new Dimension(290, 50));
        card.setMinimumSize(new Dimension(290, 50));
        card.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(item.getProduct().getProductName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setForeground(Color.decode("#222222"));

        JLabel priceLabel = new JLabel("$" + item.getPrice());
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        priceLabel.setForeground(Color.GRAY);

        centerPanel.add(nameLabel);
        centerPanel.add(priceLabel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
        rightPanel.setBackground(Color.WHITE);

        JLabel quantityLabel = new JLabel(" x" + item.getQuantity() + " ");
        quantityLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel deleteLabel = new JLabel("🗑️");
        deleteLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        deleteLabel.setForeground(Color.RED);
        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        deleteLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onDelete != null) {
                    onDelete.accept(item);
                }
            }
        });

        rightPanel.add(quantityLabel);
        rightPanel.add(deleteLabel);

        card.add(centerPanel, BorderLayout.CENTER);
        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }
    
    public JPanel createMinimalDishCard(
        Dish dish,
        Consumer<Dish> onDelete
    ) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BorderLayout());
        card.setMaximumSize(new Dimension(290, 50));
        card.setPreferredSize(new Dimension(290, 50));
        card.setMinimumSize(new Dimension(290, 50));
        card.setAlignmentX(JPanel.CENTER_ALIGNMENT);

        JLabel imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(40, 40));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (dish.getDishImage()!= null) {
            imageGenerator.addImageDish(imageLabel, dish.getDishImage(), 30, 30);
            imageGenerator.roundedImage(imageLabel);
        }
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel(dish.getDishName());
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        nameLabel.setForeground(Color.decode("#222222"));

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(nameLabel);
        centerPanel.add(Box.createVerticalGlue());

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
        rightPanel.setBackground(Color.WHITE);

        JLabel deleteLabel = new JLabel("🗑️");
        deleteLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        deleteLabel.setForeground(Color.RED);
        deleteLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deleteLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onDelete != null) {
                    onDelete.accept(dish);
                }
            }
        });

        rightPanel.add(deleteLabel);

        card.add(imageLabel, BorderLayout.WEST);
        card.add(centerPanel, BorderLayout.CENTER);
        card.add(rightPanel, BorderLayout.EAST);

        return card;
    }
    
    public JPanel createMenuCard(
        Menu menu,
        Consumer<Menu> onViewClick,
        Consumer<Menu> onEditClick
    ) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setPreferredSize(new Dimension(180, 140));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.decode("#E0E0E0")), 
            BorderFactory.createEmptyBorder(12, 16, 12, 16)
        ));
        
        JLabel titleLabel = new JLabel(menu.getMenuName());
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(Color.decode("#1D1C1D"));

        // Fechas
        JLabel dateLabel = new JLabel("Del " + menu.getMenuStartDate() + " al " + menu.getMenuEndDate());
        dateLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        dateLabel.setForeground(Color.GRAY);

        // Descripción
        JLabel descLabel = new JLabel("<html><p style='width:200px;'>" + menu.getMenuDescription() + "</p></html>");
        descLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        descLabel.setForeground(Color.GRAY);

        // Contenedor vertical de textos
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.WHITE);
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(4));
        textPanel.add(dateLabel);
        textPanel.add(Box.createVerticalStrut(6));
        textPanel.add(descLabel);

        // Botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.setBackground(Color.WHITE);

        JLabel btnVer = new JLabel("Ver Detalle");
        btnVer.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnVer.setForeground(Color.decode("#1264A3")); // azul Slack
        btnVer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVer.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 15));
        btnVer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onViewClick != null) {
                    onViewClick.accept(menu);
                }
            }
        });

        buttonPanel.add(btnVer);
        buttonPanel.add(Box.createHorizontalStrut(10));

        card.add(textPanel, BorderLayout.CENTER);
        card.add(buttonPanel, BorderLayout.SOUTH);

        return card;
    }
    
    public JPanel createMinimalDishMenuCard(Dish dish) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setMaximumSize(new Dimension(120, 100));
        card.setPreferredSize(new Dimension(120, 100));
        card.setMinimumSize(new Dimension(120, 100));
        card.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel imageLabel = new JLabel();
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imageLabel.setPreferredSize(new Dimension(40, 40));
        imageLabel.setMaximumSize(new Dimension(40, 40));
        imageLabel.setMinimumSize(new Dimension(40, 40));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        String image = dish.getDishImage() == null || "Platillo sin imagen".equals(dish.getDishImage())
            ? "no-image.jpg"
            : dish.getDishImage();
        imageGenerator.addImageDish(imageLabel, image, 40, 40);
        imageGenerator.roundedImage(imageLabel);

        JLabel nameLabel = new JLabel(dish.getDishName());
        nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        nameLabel.setForeground(Color.decode("#333333"));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel priceLabel = new JLabel("$" + dish.getDishSellingPrice());
        priceLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
        priceLabel.setForeground(Color.decode(ViewConstants.mainColor));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(imageLabel);
        card.add(Box.createVerticalStrut(5));
        card.add(nameLabel);
        card.add(Box.createVerticalStrut(2));
        card.add(priceLabel);

        return card;
    }

}
