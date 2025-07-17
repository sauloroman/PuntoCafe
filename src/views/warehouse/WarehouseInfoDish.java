package views.warehouse;

public class WarehouseInfoDish extends javax.swing.JFrame {

    private final WarehouseInfoDishInit styleView = new WarehouseInfoDishInit(this);
    
    public WarehouseInfoDish() {
        initComponents();
        styleView.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dishTitle = new javax.swing.JLabel();
        iconInfoDish = new javax.swing.JLabel();
        dishImage = new javax.swing.JLabel();
        dishCategory = new javax.swing.JLabel();
        dishName = new javax.swing.JLabel();
        dishPrice = new javax.swing.JLabel();
        dishCreatedAt = new javax.swing.JLabel();
        dishUpdatedAt = new javax.swing.JLabel();
        btnEditDish = new javax.swing.JButton();
        btnActivate = new javax.swing.JButton();
        btnDeactivate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dishDescription = new javax.swing.JTextArea();
        dishId = new javax.swing.JLabel();
        productId1 = new javax.swing.JLabel();
        dishStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(141, 180, 167));

        dishTitle.setBackground(new java.awt.Color(255, 255, 255));
        dishTitle.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        dishTitle.setForeground(new java.awt.Color(255, 255, 255));
        dishTitle.setText("Platillo Seleccionado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(dishTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconInfoDish, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconInfoDish, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(dishTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dishCategory.setBackground(new java.awt.Color(253, 233, 219));
        dishCategory.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dishCategory.setForeground(new java.awt.Color(153, 153, 153));
        dishCategory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dishCategory.setText("Comida Mexicana");
        dishCategory.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        dishName.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        dishName.setText("Enchiladas Verdes");

        dishPrice.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        dishPrice.setForeground(new java.awt.Color(141, 180, 167));
        dishPrice.setText("$25.50");

        dishCreatedAt.setBackground(new java.awt.Color(102, 102, 102));
        dishCreatedAt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dishCreatedAt.setForeground(new java.awt.Color(153, 153, 153));
        dishCreatedAt.setText("Fecha de creación: 25/06/23");

        dishUpdatedAt.setBackground(new java.awt.Color(204, 204, 204));
        dishUpdatedAt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dishUpdatedAt.setForeground(new java.awt.Color(153, 153, 153));
        dishUpdatedAt.setText("Última actualización: 15/08/23");

        btnEditDish.setText("Editar Producto");
        btnEditDish.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnActivate.setText("Activar");
        btnActivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDeactivate.setText("Desactivar");
        btnDeactivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        dishDescription.setColumns(20);
        dishDescription.setRows(5);
        dishDescription.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(dishDescription);

        dishId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dishId.setForeground(new java.awt.Color(255, 0, 51));
        dishId.setText("13");

        productId1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        productId1.setForeground(new java.awt.Color(255, 0, 51));
        productId1.setText("#");

        dishStatus.setBackground(new java.awt.Color(221, 233, 229));
        dishStatus.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        dishStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dishStatus.setText("Activo");
        dishStatus.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dishImage, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnEditDish, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(dishCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productId1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(dishId))
                        .addComponent(dishPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dishStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                        .addComponent(dishName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dishUpdatedAt)
                    .addComponent(dishCreatedAt))
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(dishImage, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnEditDish, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(dishStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dishCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dishId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productId1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(dishName)
                        .addGap(20, 20, 20)
                        .addComponent(dishPrice)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(dishCreatedAt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dishUpdatedAt)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WarehouseInfoDish().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivate;
    public javax.swing.JButton btnDeactivate;
    public javax.swing.JButton btnEditDish;
    public javax.swing.JLabel dishCategory;
    public javax.swing.JLabel dishCreatedAt;
    public javax.swing.JTextArea dishDescription;
    public javax.swing.JLabel dishId;
    public javax.swing.JLabel dishImage;
    public javax.swing.JLabel dishName;
    public javax.swing.JLabel dishPrice;
    public javax.swing.JLabel dishStatus;
    public javax.swing.JLabel dishTitle;
    public javax.swing.JLabel dishUpdatedAt;
    public javax.swing.JLabel iconInfoDish;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel productId1;
    // End of variables declaration//GEN-END:variables
}
