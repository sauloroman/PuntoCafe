package views.warehouse;

import entities.User;

public class WarehouseCategories extends javax.swing.JPanel {
    
    private final WarehouseCategoriesInit style;
    
    public WarehouseCategories(User user) {
        initComponents();
        this.style = new WarehouseCategoriesInit(this, user);
        style.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSearch = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        btnSeeCategory = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        quantityItems = new javax.swing.JLabel();
        scrollTable = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        quantityCategories = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        categoryTypeCombo = new javax.swing.JComboBox<>();
        pageTitle = new javax.swing.JLabel();
        pageCombo = new javax.swing.JComboBox<>();
        pageItems = new javax.swing.JLabel();
        itemsPerPageComboBox = new javax.swing.JComboBox<>();
        btnRestore = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1300, 900));

        btnSearch.setText("Buscar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(72, 30));

        searchTxt.setPreferredSize(new java.awt.Dimension(64, 30));

        btnSeeCategory.setText("Ver Categoría");
        btnSeeCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnNew.setText("Crear Categoría");
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        quantityItems.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        quantityItems.setForeground(new java.awt.Color(102, 102, 102));
        quantityItems.setText("Visualizando 10 de 30 categorías");

        scrollTable.setBackground(new java.awt.Color(221, 221, 221));

        categoriesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripción", "Tipo", "Fecha de creación", "Última actualización", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollTable.setViewportView(categoriesTable);

        quantityCategories.setBackground(new java.awt.Color(255, 250, 199));
        quantityCategories.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        quantityCategories.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quantityCategories.setText("10");
        quantityCategories.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Todos las categorías >");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Las categorías son pieza fundamental que diferencía a tus platillos y productos. ");

        title.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        title.setText("Categorías del sistema");

        categoryTypeCombo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        categoryTypeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Categoría", "Platillo", "Producto" }));

        pageTitle.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        pageTitle.setText("No. Página");

        pageItems.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        pageItems.setText("Registros por página");

        itemsPerPageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "15", "20" }));
        itemsPerPageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        btnRestore.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnRestore.setText("Restablecer");
        btnRestore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pageTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pageItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollTable)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(quantityItems))
                            .addComponent(title)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(categoryTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnSeeCategory)
                                .addGap(30, 30, 30)
                                .addComponent(btnNew)))))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSeeCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quantityCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityItems))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pageTitle)
                    .addComponent(pageItems)
                    .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnNew;
    public javax.swing.JButton btnRestore;
    public javax.swing.JButton btnSearch;
    public javax.swing.JButton btnSeeCategory;
    public javax.swing.JTable categoriesTable;
    public javax.swing.JComboBox<String> categoryTypeCombo;
    public javax.swing.JComboBox<String> itemsPerPageComboBox;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JComboBox<String> pageCombo;
    public javax.swing.JLabel pageItems;
    public javax.swing.JLabel pageTitle;
    public javax.swing.JLabel quantityCategories;
    public javax.swing.JLabel quantityItems;
    public javax.swing.JScrollPane scrollTable;
    public javax.swing.JTextField searchTxt;
    public javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
