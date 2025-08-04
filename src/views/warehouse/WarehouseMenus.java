package views.warehouse;

import entities.User;

public class WarehouseMenus extends javax.swing.JPanel {
    
    private final WarehouseMenuInit style;
    
    public WarehouseMenus(User user) {
        initComponents();
        this.style = new WarehouseMenuInit(this, user);
        style.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCreateMenu = new javax.swing.JButton();
        menuGrid = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        btnRestore = new javax.swing.JButton();
        filterStatus = new javax.swing.JComboBox<>();
        pageComboBox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnCreateMenu.setText("Crear Menú");
        btnCreateMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuGrid.setBackground(new java.awt.Color(248, 249, 250));

        javax.swing.GroupLayout menuGridLayout = new javax.swing.GroupLayout(menuGrid);
        menuGrid.setLayout(menuGridLayout);
        menuGridLayout.setHorizontalGroup(
            menuGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuGridLayout.setVerticalGroup(
            menuGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        btnSearch.setText("Buscar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(72, 30));

        searchTxt.setPreferredSize(new java.awt.Dimension(64, 30));

        btnRestore.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRestore.setText("Reestablecer");
        btnRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filterStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Activo", "Inactivo" }));

        pageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        jLabel16.setText("No. Página");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                        .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(btnCreateMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(menuGrid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCreateMenu;
    public javax.swing.JButton btnRestore;
    public javax.swing.JButton btnSearch;
    public javax.swing.JComboBox<String> filterStatus;
    private javax.swing.JLabel jLabel16;
    public javax.swing.JPanel menuGrid;
    public javax.swing.JComboBox<String> pageComboBox;
    public javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
