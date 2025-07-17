package views.warehouse;

public class WarehouseInfoProduct extends javax.swing.JFrame {

    private final WarehouseInfoProductInit styleView = new WarehouseInfoProductInit(this);
    
    public WarehouseInfoProduct() {
        initComponents();
        styleView.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        productImage = new javax.swing.JLabel();
        productCategory = new javax.swing.JLabel();
        productName = new javax.swing.JLabel();
        iconStock = new javax.swing.JLabel();
        productStock = new javax.swing.JLabel();
        productMinStock = new javax.swing.JLabel();
        productPrice = new javax.swing.JLabel();
        productSupplierName = new javax.swing.JLabel();
        productCreatedAt = new javax.swing.JLabel();
        productUpdatedAt = new javax.swing.JLabel();
        btnEditProduct = new javax.swing.JButton();
        btnActivate = new javax.swing.JButton();
        btnDeactivate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productDescription = new javax.swing.JTextArea();
        productId = new javax.swing.JLabel();
        productId1 = new javax.swing.JLabel();
        productStatus = new javax.swing.JLabel();
        iconStock1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        productCategory.setBackground(new java.awt.Color(253, 233, 219));
        productCategory.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        productCategory.setForeground(new java.awt.Color(153, 153, 153));
        productCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productCategory.setText("Galletas");
        productCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        productName.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        productName.setText("Donitas Bimbo ");

        productStock.setBackground(new java.awt.Color(102, 102, 102));
        productStock.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        productStock.setForeground(new java.awt.Color(102, 102, 102));
        productStock.setText("Stock: 15");

        productMinStock.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        productMinStock.setForeground(new java.awt.Color(102, 102, 102));
        productMinStock.setText("Stock Min: 5");

        productPrice.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        productPrice.setForeground(new java.awt.Color(141, 180, 167));
        productPrice.setText("$25.50");

        productSupplierName.setBackground(new java.awt.Color(255, 250, 199));
        productSupplierName.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        productSupplierName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productSupplierName.setText("Saulo Santillán - Gamesa");
        productSupplierName.setOpaque(true);

        productCreatedAt.setBackground(new java.awt.Color(102, 102, 102));
        productCreatedAt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        productCreatedAt.setForeground(new java.awt.Color(153, 153, 153));
        productCreatedAt.setText("Fecha de creación: 25/06/23");

        productUpdatedAt.setBackground(new java.awt.Color(204, 204, 204));
        productUpdatedAt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        productUpdatedAt.setForeground(new java.awt.Color(153, 153, 153));
        productUpdatedAt.setText("Última actualización: 15/08/23");

        btnEditProduct.setText("Editar Producto");
        btnEditProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnActivate.setText("Activar");
        btnActivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDeactivate.setText("Desactivar");
        btnDeactivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        productDescription.setColumns(20);
        productDescription.setRows(5);
        productDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(productDescription);

        productId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productId.setForeground(new java.awt.Color(255, 0, 51));
        productId.setText("13");

        productId1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productId1.setForeground(new java.awt.Color(255, 0, 51));
        productId1.setText("#");

        productStatus.setBackground(new java.awt.Color(221, 233, 229));
        productStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        productStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productStatus.setText("Activo");
        productStatus.setOpaque(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/banner-blue.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEditProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(productId1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productId))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(productUpdatedAt)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productCreatedAt)
                            .addComponent(productPrice)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconStock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(productStock)
                                .addGap(30, 30, 30)
                                .addComponent(iconStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(productMinStock))
                            .addComponent(productName, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                            .addComponent(productStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productSupplierName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(productImage, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productId1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(productName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconStock, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productStock)
                                        .addComponent(productMinStock))))
                            .addComponent(iconStock1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(productPrice)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(productSupplierName)
                        .addGap(27, 27, 27)
                        .addComponent(productStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(productCreatedAt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productUpdatedAt)))
                .addGap(0, 81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WarehouseInfoProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivate;
    public javax.swing.JButton btnDeactivate;
    public javax.swing.JButton btnEditProduct;
    public javax.swing.JLabel iconStock;
    public javax.swing.JLabel iconStock1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel productCategory;
    public javax.swing.JLabel productCreatedAt;
    public javax.swing.JTextArea productDescription;
    public javax.swing.JLabel productId;
    public javax.swing.JLabel productId1;
    public javax.swing.JLabel productImage;
    public javax.swing.JLabel productMinStock;
    public javax.swing.JLabel productName;
    public javax.swing.JLabel productPrice;
    public javax.swing.JLabel productStatus;
    public javax.swing.JLabel productStock;
    public javax.swing.JLabel productSupplierName;
    public javax.swing.JLabel productUpdatedAt;
    // End of variables declaration//GEN-END:variables
}
