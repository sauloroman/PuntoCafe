package views.warehouse;

public class WarehouseMenus extends javax.swing.JPanel {
    
    private final WarehouseMenuInit style = new WarehouseMenuInit(this);
    
    public WarehouseMenus() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        quantityMenus = new javax.swing.JLabel();
        quantityItems = new javax.swing.JLabel();
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
            .addGap(0, 640, Short.MAX_VALUE)
        );

        btnSearch.setText("Buscar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(72, 30));

        searchTxt.setPreferredSize(new java.awt.Dimension(64, 30));

        btnRestore.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRestore.setText("Reestablecer");
        btnRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filterStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Todos los menús >");

        quantityMenus.setBackground(new java.awt.Color(255, 250, 199));
        quantityMenus.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        quantityMenus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityMenus.setText("10");
        quantityMenus.setOpaque(true);

        quantityItems.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        quantityItems.setForeground(new java.awt.Color(102, 102, 102));
        quantityItems.setText("Visualizando 10 de 30 menús");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(filterStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 315, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(btnCreateMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(quantityItems)))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreateMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addComponent(filterStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantityMenus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityItems))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
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
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel menuGrid;
    public javax.swing.JComboBox<String> pageComboBox;
    public javax.swing.JLabel quantityItems;
    public javax.swing.JLabel quantityMenus;
    public javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
