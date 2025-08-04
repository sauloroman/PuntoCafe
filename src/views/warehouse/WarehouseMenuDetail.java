package views.warehouse;

import entities.User;

public class WarehouseMenuDetail extends javax.swing.JFrame {

    private final WarehouseMenuDetailInit style;
    
    public WarehouseMenuDetail(User user) {
        initComponents();
        this.style = new WarehouseMenuDetailInit(this, user);
        style.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuNameLabel = new javax.swing.JLabel();
        menuDetailGrid = new javax.swing.JPanel();
        btnActivate = new javax.swing.JButton();
        btnDeactivate = new javax.swing.JButton();
        btnChangeDishes = new javax.swing.JButton();
        btnEditMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/banner-blue.png"))); // NOI18N

        menuNameLabel.setBackground(new java.awt.Color(255, 250, 199));
        menuNameLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        menuNameLabel.setText("Menu Semana 1");
        menuNameLabel.setOpaque(true);

        javax.swing.GroupLayout menuDetailGridLayout = new javax.swing.GroupLayout(menuDetailGrid);
        menuDetailGrid.setLayout(menuDetailGridLayout);
        menuDetailGridLayout.setHorizontalGroup(
            menuDetailGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuDetailGridLayout.setVerticalGroup(
            menuDetailGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        btnActivate.setText("Activar");
        btnActivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDeactivate.setText("Desactivar");
        btnDeactivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnChangeDishes.setText("Cambiar platillos");
        btnChangeDishes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEditMenu.setText("Editar Menú");
        btnEditMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuDetailGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(menuNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                        .addComponent(btnEditMenu)
                        .addGap(18, 18, 18)
                        .addComponent(btnChangeDishes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnActivate)
                        .addGap(20, 20, 20)
                        .addComponent(btnDeactivate)))
                .addGap(50, 50, 50))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(menuNameLabel)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActivate)
                            .addComponent(btnDeactivate)
                            .addComponent(btnChangeDishes)
                            .addComponent(btnEditMenu))
                        .addGap(18, 18, 18)))
                .addComponent(menuDetailGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivate;
    public javax.swing.JButton btnChangeDishes;
    public javax.swing.JButton btnDeactivate;
    public javax.swing.JButton btnEditMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel menuDetailGrid;
    public javax.swing.JLabel menuNameLabel;
    // End of variables declaration//GEN-END:variables
}
