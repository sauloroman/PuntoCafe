package views.purchases;

import entities.User;

public class PurchasesSuppliers extends javax.swing.JPanel {
   
    private final PurchasesSuppliersInit style;
    
    public PurchasesSuppliers(User user) {
        initComponents();
        this.style = new PurchasesSuppliersInit(this, user);
        this.style.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchSuppliersTxt = new javax.swing.JTextField();
        btnRestore = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliersTable = new javax.swing.JTable();
        suppliersStatusCombo = new javax.swing.JComboBox<>();
        suppliersCompanyCombo = new javax.swing.JComboBox<>();
        pageComboBox = new javax.swing.JComboBox<>();
        btnNewSupplier = new javax.swing.JButton();
        btnExportSuppliers = new javax.swing.JButton();
        itemsPerPageComboBox = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        titlePages = new javax.swing.JLabel();
        titleItems = new javax.swing.JLabel();
        btnSeeSupplier = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        quantitySuppliers = new javax.swing.JLabel();
        quantityItems = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnRestore.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRestore.setText("Reestablecer");
        btnRestore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 22, 21)));
        btnRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        suppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Compañía", "Teléfono", "Email", "Dirección", "Fecha de creación", "Fecha de actualización", "Estado"
            }
        ));
        jScrollPane1.setViewportView(suppliersTable);

        suppliersStatusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Activo", "Inactivo" }));
        suppliersStatusCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        suppliersCompanyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa" }));
        suppliersCompanyCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        pageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        btnNewSupplier.setText("Agregar Proveedor");
        btnNewSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnExportSuppliers.setText("Exportar ");
        btnExportSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        itemsPerPageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "25" }));
        itemsPerPageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        btnSearch.setText("Buscar");
        btnSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 22, 21)));
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        titlePages.setText("No. Página");

        titleItems.setText("Registros por página");

        btnSeeSupplier.setText("Ver Proveedor");
        btnSeeSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        title.setText("Proveedores del sistema");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Las alianzas de tu negocio son lo más importante para su funcionamiento.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Todos los proveedores >");

        quantitySuppliers.setBackground(new java.awt.Color(255, 250, 199));
        quantitySuppliers.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        quantitySuppliers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantitySuppliers.setText("10");
        quantitySuppliers.setOpaque(true);

        quantityItems.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        quantityItems.setForeground(new java.awt.Color(102, 102, 102));
        quantityItems.setText("Visualizando 10 de 30 proveedores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titlePages)
                        .addGap(18, 18, 18)
                        .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(titleItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantitySuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(quantityItems))
                            .addComponent(title)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSeeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnExportSuppliers)
                                .addGap(25, 25, 25)
                                .addComponent(suppliersStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(suppliersCompanyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(btnNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchSuppliersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppliersStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suppliersCompanyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchSuppliersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quantitySuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityItems))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titlePages)
                    .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleItems)
                    .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnExportSuppliers;
    public javax.swing.JButton btnNewSupplier;
    public javax.swing.JButton btnRestore;
    public javax.swing.JButton btnSearch;
    public javax.swing.JButton btnSeeSupplier;
    public javax.swing.JComboBox<String> itemsPerPageComboBox;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox<String> pageComboBox;
    public javax.swing.JLabel quantityItems;
    public javax.swing.JLabel quantitySuppliers;
    public javax.swing.JTextField searchSuppliersTxt;
    public javax.swing.JComboBox<String> suppliersCompanyCombo;
    public javax.swing.JComboBox<String> suppliersStatusCombo;
    public javax.swing.JTable suppliersTable;
    public javax.swing.JLabel title;
    public javax.swing.JLabel titleItems;
    public javax.swing.JLabel titlePages;
    // End of variables declaration//GEN-END:variables
}
