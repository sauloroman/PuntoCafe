package views.warehouse;

import views.inits.WarehouseCategoriesInit;

public class WarehouseCategories extends javax.swing.JPanel {
    
    private final WarehouseCategoriesInit styleView = new WarehouseCategoriesInit(this);
    
    public WarehouseCategories() {
        initComponents();
        styleView.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        categoriesNavegationPane = new javax.swing.JTabbedPane();
        categoriesListPane = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();
        btnDeactivate = new javax.swing.JButton();
        btnActivate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoriesTable = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        pageComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        itemsPerPageComboBox = new javax.swing.JComboBox<>();
        quantityItems = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        panelCreated = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        quantityTotalCategories = new javax.swing.JLabel();
        iconPanel = new javax.swing.JLabel();
        panelActive = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        quantityActiveCategories = new javax.swing.JLabel();
        iconPanel2 = new javax.swing.JLabel();
        panelInactive = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        quantityInactiveCategories = new javax.swing.JLabel();
        iconPanel3 = new javax.swing.JLabel();
        categoriesCreationPane = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        iconInputMandatory = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        iconInputMandatory2 = new javax.swing.JLabel();
        categoryNameTxt = new javax.swing.JTextField();
        categoryTypeCombo = new javax.swing.JComboBox<>();
        categoryRestrictionName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        categoryDescriptionTxt = new javax.swing.JTextArea();
        categoryRestrictionDescription = new javax.swing.JLabel();
        btnCancelSaveCategory = new javax.swing.JButton();
        btnSaveCategory = new javax.swing.JButton();
        creationTitle = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        logoCreateCategory = new javax.swing.JLabel();
        bannerBottom = new javax.swing.JLabel();
        categoriesUpdatePane = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        editCategoryNameTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnEditCategory = new javax.swing.JButton();
        btnCancelEditCategory = new javax.swing.JButton();
        iconInputMandatory1 = new javax.swing.JLabel();
        categoryRestrictionEditName = new javax.swing.JLabel();
        categoryRestrictionEditDescription = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        editCategoryTypeCombo = new javax.swing.JComboBox<>();
        iconInputMandatory3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        categoryIdSelected = new javax.swing.JLabel();
        categoryCreatedSelected = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        categoryNameSelected = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        categoryTypeSelected = new javax.swing.JLabel();
        categoryUpdatedSelected = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        iconInfo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        categoryStatusSelected = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        editCategoryDescriptionTxt = new javax.swing.JTextArea();
        categoryDescriptionSelected = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        creationTitle1 = new javax.swing.JLabel();
        logoCreateCategory1 = new javax.swing.JLabel();
        bannerBottom2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(1200, 700));

        categoriesNavegationPane.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        categoriesListPane.setBackground(new java.awt.Color(255, 255, 255));

        btnSearch.setText("Buscar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(72, 30));

        searchTxt.setPreferredSize(new java.awt.Dimension(64, 30));

        btnDeactivate.setText("Desactivar Categoría");
        btnDeactivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnActivate.setText("Activar Categoría");
        btnActivate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        categoriesTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
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
        jScrollPane2.setViewportView(categoriesTable);

        jLabel16.setText("No. Página");

        pageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        jLabel17.setText("Registros por página");

        itemsPerPageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "10", "20" }));
        itemsPerPageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        quantityItems.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        quantityItems.setForeground(new java.awt.Color(102, 102, 102));
        quantityItems.setText("Visualizando 10 de 30 categorías");

        btnNew.setText("Crear Categoría");
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEdit.setText("Editar ");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panelCreated.setBackground(new java.awt.Color(231, 241, 243));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setText("Categorías Creadas");

        quantityTotalCategories.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        quantityTotalCategories.setText("15");

        javax.swing.GroupLayout panelCreatedLayout = new javax.swing.GroupLayout(panelCreated);
        panelCreated.setLayout(panelCreatedLayout);
        panelCreatedLayout.setHorizontalGroup(
            panelCreatedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreatedLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelCreatedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreatedLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(panelCreatedLayout.createSequentialGroup()
                        .addComponent(quantityTotalCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        panelCreatedLayout.setVerticalGroup(
            panelCreatedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreatedLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelCreatedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCreatedLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantityTotalCategories)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        panelActive.setBackground(new java.awt.Color(253, 233, 219));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel22.setText("Categorías Activas");

        quantityActiveCategories.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        quantityActiveCategories.setText("10");

        javax.swing.GroupLayout panelActiveLayout = new javax.swing.GroupLayout(panelActive);
        panelActive.setLayout(panelActiveLayout);
        panelActiveLayout.setHorizontalGroup(
            panelActiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActiveLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelActiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelActiveLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(140, Short.MAX_VALUE))
                    .addGroup(panelActiveLayout.createSequentialGroup()
                        .addComponent(quantityActiveCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        panelActiveLayout.setVerticalGroup(
            panelActiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActiveLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelActiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityActiveCategories)
                    .addComponent(iconPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInactive.setBackground(new java.awt.Color(255, 250, 199));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel24.setText("Categorías Inactivas");

        quantityInactiveCategories.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        quantityInactiveCategories.setText("5");

        javax.swing.GroupLayout panelInactiveLayout = new javax.swing.GroupLayout(panelInactive);
        panelInactive.setLayout(panelInactiveLayout);
        panelInactiveLayout.setHorizontalGroup(
            panelInactiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInactiveLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelInactiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInactiveLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addContainerGap(152, Short.MAX_VALUE))
                    .addGroup(panelInactiveLayout.createSequentialGroup()
                        .addComponent(quantityInactiveCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iconPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        panelInactiveLayout.setVerticalGroup(
            panelInactiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInactiveLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelInactiveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelInactiveLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(12, 12, 12)
                        .addComponent(quantityInactiveCategories)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout categoriesListPaneLayout = new javax.swing.GroupLayout(categoriesListPane);
        categoriesListPane.setLayout(categoriesListPaneLayout);
        categoriesListPaneLayout.setHorizontalGroup(
            categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesListPaneLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, categoriesListPaneLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(categoriesListPaneLayout.createSequentialGroup()
                                .addComponent(panelCreated, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(panelActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(panelInactive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(categoriesListPaneLayout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnNew))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, categoriesListPaneLayout.createSequentialGroup()
                        .addComponent(btnActivate)
                        .addGap(12, 12, 12)
                        .addComponent(btnDeactivate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(quantityItems)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        categoriesListPaneLayout.setVerticalGroup(
            categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesListPaneLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelActive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInactive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCreated, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addGroup(categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(quantityItems)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(categoriesListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeactivate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );

        categoriesNavegationPane.addTab("Listado", categoriesListPane);

        categoriesCreationPane.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Nombre de la categoría:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Tipo de categoría:");

        categoryRestrictionName.setBackground(new java.awt.Color(102, 102, 102));
        categoryRestrictionName.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        categoryRestrictionName.setText("Máximo 100 caracteres");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Descripción de categoría:");

        categoryDescriptionTxt.setColumns(20);
        categoryDescriptionTxt.setRows(5);
        jScrollPane3.setViewportView(categoryDescriptionTxt);

        categoryRestrictionDescription.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        categoryRestrictionDescription.setText("Máximo 220 caracteres");

        btnCancelSaveCategory.setText("Cancelar");
        btnCancelSaveCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSaveCategory.setText("Guardar Categoría");
        btnSaveCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconInputMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(categoryRestrictionName)
                                .addComponent(categoryNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(iconInputMandatory2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(categoryTypeCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(categoryRestrictionDescription)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(btnCancelSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(63, 63, 63))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconInputMandatory2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(iconInputMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryRestrictionName)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryRestrictionDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSaveCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        creationTitle.setBackground(new java.awt.Color(255, 250, 199));
        creationTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        creationTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creationTitle.setText("Crear una nueva categoría");
        creationTitle.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Organiza mejor tus productos agrupándolos en categorías específicas.");

        bannerBottom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/banner-bottom-2.png"))); // NOI18N

        javax.swing.GroupLayout categoriesCreationPaneLayout = new javax.swing.GroupLayout(categoriesCreationPane);
        categoriesCreationPane.setLayout(categoriesCreationPaneLayout);
        categoriesCreationPaneLayout.setHorizontalGroup(
            categoriesCreationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesCreationPaneLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 174, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesCreationPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(categoriesCreationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesCreationPaneLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesCreationPaneLayout.createSequentialGroup()
                        .addComponent(creationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260)))
                .addComponent(logoCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addComponent(bannerBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        categoriesCreationPaneLayout.setVerticalGroup(
            categoriesCreationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesCreationPaneLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(categoriesCreationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(categoriesCreationPaneLayout.createSequentialGroup()
                        .addComponent(creationTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addComponent(logoCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(bannerBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        categoriesNavegationPane.addTab("Creación", categoriesCreationPane);

        categoriesUpdatePane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Nombre de la categoría:");

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Descripción de categoría:");

        btnEditCategory.setText("Editar Categoría");
        btnEditCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnCancelEditCategory.setText("Cancelar");
        btnCancelEditCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        categoryRestrictionEditName.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        categoryRestrictionEditName.setText("Máximo 100 caracteres");

        categoryRestrictionEditDescription.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        categoryRestrictionEditDescription.setText("Máximo 220 caracteres");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Tipo de categoría:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setText("Categoría ID:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setText("Estado:");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setText("Fecha de creación:");

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setText("Fecha de actualización:");

        categoryIdSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        categoryCreatedSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel18.setText("Nombre de la categoría:");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel19.setText("Tipo de categoría:");

        categoryUpdatedSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jPanel4.setBackground(new java.awt.Color(253, 233, 219));

        iconInfo.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setText("Categoría Seleccionada");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(iconInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(iconInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        categoryStatusSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryUpdatedSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryCreatedSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryStatusSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryIdSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryNameSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryTypeSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryIdSelected, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(categoryNameSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoryTypeSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(categoryStatusSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryCreatedSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryUpdatedSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18))
        );

        editCategoryDescriptionTxt.setColumns(20);
        editCategoryDescriptionTxt.setRows(5);
        jScrollPane4.setViewportView(editCategoryDescriptionTxt);

        categoryDescriptionSelected.setForeground(new java.awt.Color(255, 255, 255));
        categoryDescriptionSelected.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Realiza los cambios que consideres necesarios para tus categorías");

        creationTitle1.setBackground(new java.awt.Color(255, 250, 199));
        creationTitle1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        creationTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creationTitle1.setText("Editar Categoría");
        creationTitle1.setOpaque(true);

        bannerBottom2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/banner-bottom-2.png"))); // NOI18N

        javax.swing.GroupLayout categoriesUpdatePaneLayout = new javax.swing.GroupLayout(categoriesUpdatePane);
        categoriesUpdatePane.setLayout(categoriesUpdatePaneLayout);
        categoriesUpdatePaneLayout.setHorizontalGroup(
            categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesUpdatePaneLayout.createSequentialGroup()
                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesUpdatePaneLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                .addComponent(btnCancelEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iconInputMandatory3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(categoryRestrictionEditName)
                                        .addComponent(editCategoryNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                        .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                                .addGap(82, 82, 82)
                                                .addComponent(creationTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(logoCreateCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                        .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(127, 127, 127)
                                                .addComponent(iconInputMandatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(editCategoryTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel8)
                            .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(categoryRestrictionEditDescription)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesUpdatePaneLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categoryDescriptionSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addComponent(bannerBottom2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        categoriesUpdatePaneLayout.setVerticalGroup(
            categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, categoriesUpdatePaneLayout.createSequentialGroup()
                        .addComponent(creationTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)
                        .addGap(0, 0, 0)
                        .addComponent(categoryDescriptionSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(logoCreateCategory1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                        .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(iconInputMandatory3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27)
                                .addComponent(editCategoryNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(categoriesUpdatePaneLayout.createSequentialGroup()
                                .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(iconInputMandatory1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(editCategoryTypeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addComponent(categoryRestrictionEditName)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categoryRestrictionEditDescription)
                        .addGap(50, 50, 50)
                        .addGroup(categoriesUpdatePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(90, 90, 90)
                .addComponent(bannerBottom2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        categoriesNavegationPane.addTab("Edición", categoriesUpdatePane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(categoriesNavegationPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(categoriesNavegationPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bannerBottom;
    private javax.swing.JLabel bannerBottom2;
    public javax.swing.JButton btnActivate;
    public javax.swing.JButton btnCancelEditCategory;
    public javax.swing.JButton btnCancelSaveCategory;
    public javax.swing.JButton btnDeactivate;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnEditCategory;
    public javax.swing.JButton btnNew;
    public javax.swing.JButton btnSaveCategory;
    public javax.swing.JButton btnSearch;
    private javax.swing.JPanel categoriesCreationPane;
    private javax.swing.JPanel categoriesListPane;
    public javax.swing.JTabbedPane categoriesNavegationPane;
    public javax.swing.JTable categoriesTable;
    private javax.swing.JPanel categoriesUpdatePane;
    public javax.swing.JLabel categoryCreatedSelected;
    public javax.swing.JLabel categoryDescriptionSelected;
    public javax.swing.JTextArea categoryDescriptionTxt;
    public javax.swing.JLabel categoryIdSelected;
    public javax.swing.JLabel categoryNameSelected;
    public javax.swing.JTextField categoryNameTxt;
    public javax.swing.JLabel categoryRestrictionDescription;
    public javax.swing.JLabel categoryRestrictionEditDescription;
    public javax.swing.JLabel categoryRestrictionEditName;
    public javax.swing.JLabel categoryRestrictionName;
    public javax.swing.JLabel categoryStatusSelected;
    public javax.swing.JComboBox<String> categoryTypeCombo;
    public javax.swing.JLabel categoryTypeSelected;
    public javax.swing.JLabel categoryUpdatedSelected;
    public javax.swing.JLabel creationTitle;
    private javax.swing.JLabel creationTitle1;
    public javax.swing.JTextArea editCategoryDescriptionTxt;
    public javax.swing.JTextField editCategoryNameTxt;
    public javax.swing.JComboBox<String> editCategoryTypeCombo;
    public javax.swing.JLabel iconInfo;
    public javax.swing.JLabel iconInputMandatory;
    public javax.swing.JLabel iconInputMandatory1;
    public javax.swing.JLabel iconInputMandatory2;
    public javax.swing.JLabel iconInputMandatory3;
    public javax.swing.JLabel iconPanel;
    public javax.swing.JLabel iconPanel2;
    public javax.swing.JLabel iconPanel3;
    public javax.swing.JComboBox<String> itemsPerPageComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    public javax.swing.JLabel logoCreateCategory;
    public javax.swing.JLabel logoCreateCategory1;
    public javax.swing.JComboBox<String> pageComboBox;
    public javax.swing.JPanel panelActive;
    public javax.swing.JPanel panelCreated;
    public javax.swing.JPanel panelInactive;
    public javax.swing.JLabel quantityActiveCategories;
    public javax.swing.JLabel quantityInactiveCategories;
    public javax.swing.JLabel quantityItems;
    public javax.swing.JLabel quantityTotalCategories;
    public javax.swing.JTextField searchTxt;
    // End of variables declaration//GEN-END:variables
}
