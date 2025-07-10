package views.purchases;

import views.inits.PurchasesSuppliersInit;

public class PurchasesSuppliers extends javax.swing.JPanel {
   
    private final PurchasesSuppliersInit styleView = new PurchasesSuppliersInit(this);
    
    public PurchasesSuppliers() {
        initComponents();
        styleView.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        suppliersNavegationTab = new javax.swing.JTabbedPane();
        listSupplier = new javax.swing.JPanel();
        suppliersStatusCombo = new javax.swing.JComboBox<>();
        suppliersCompanyCombo = new javax.swing.JComboBox<>();
        btnNewSupplier = new javax.swing.JButton();
        btnPrintSuppliers = new javax.swing.JButton();
        btnSearchSuppliers = new javax.swing.JButton();
        searchSuppliersTxt = new javax.swing.JTextField();
        quantityItems = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliersTable = new javax.swing.JTable();
        btnActivateSupplier = new javax.swing.JButton();
        btnDeactivateSupplier = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        pageComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        itemsPerPageComboBox = new javax.swing.JComboBox<>();
        btnEditSupplier = new javax.swing.JButton();
        btnSeeAllSuppliers = new javax.swing.JButton();
        createSupplier = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        creationTitle = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        iconCreateSupplier = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        supplierLastnameTxt = new javax.swing.JTextField();
        supplierNameTxt = new javax.swing.JTextField();
        supplierRestrictionName = new javax.swing.JLabel();
        supplierRestrictionLastname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        supplierPhoneTxt = new javax.swing.JFormattedTextField();
        supplierRestrictionPhone = new javax.swing.JLabel();
        supplierEmailTxt = new javax.swing.JTextField();
        supplierRestrictionEmail = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        supplierAddressTxt = new javax.swing.JTextField();
        supplierRestrictionAddress = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCreateCompany = new javax.swing.JButton();
        supplierCompanyTxt = new javax.swing.JComboBox<>();
        supplierNewCompanyLabel = new javax.swing.JLabel();
        supplierNewCompanyTxt = new javax.swing.JTextField();
        supplierRestrictionNewCompany = new javax.swing.JLabel();
        btnCancelSaveSupplier = new javax.swing.JButton();
        btnSaveSupplier = new javax.swing.JButton();
        iconInputMandatory = new javax.swing.JLabel();
        iconInputMandatory2 = new javax.swing.JLabel();
        iconInputMandatory3 = new javax.swing.JLabel();
        iconInputMandatory4 = new javax.swing.JLabel();
        updateSupplier = new javax.swing.JPanel();
        supplierEditAddressTxt = new javax.swing.JTextField();
        supplierRestrictionAddress1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnEditCreateCompany = new javax.swing.JButton();
        supplierEditCompanyTxt = new javax.swing.JComboBox<>();
        supplierEditNewCompanyLabel = new javax.swing.JLabel();
        supplierEditNewCompanyTxt = new javax.swing.JTextField();
        supplierEditRestrictionNewCompany = new javax.swing.JLabel();
        btnCancelEditSupplier = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnUpdateSupplier = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        supplierEditLastnameTxt = new javax.swing.JTextField();
        iconInputMandatory5 = new javax.swing.JLabel();
        iconInputMandatory6 = new javax.swing.JLabel();
        supplierEditNameTxt = new javax.swing.JTextField();
        iconInputMandatory7 = new javax.swing.JLabel();
        supplierRestrictionName1 = new javax.swing.JLabel();
        iconInputMandatory8 = new javax.swing.JLabel();
        supplierRestrictionLastname1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        supplierEditPhoneTxt = new javax.swing.JFormattedTextField();
        supplierRestrictionPhone1 = new javax.swing.JLabel();
        supplierEditEmailTxt = new javax.swing.JTextField();
        supplierRestrictionEmail1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        creationTitle1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        iconEditSupplier = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        supplierIDSelected = new javax.swing.JLabel();
        supplierEmailSelected = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        supplierNameSelected = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        supplierLastnameSelected = new javax.swing.JLabel();
        supplierAddressSelected = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        iconInfo = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        supplierPhoneSelected = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        supplierCompanySelected = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        supplierStatusSelected = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        supplierCreatedAtSelected = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        supplierUpdatedAtSelected = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        suppliersNavegationTab.setBackground(new java.awt.Color(255, 255, 255));
        suppliersNavegationTab.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        suppliersNavegationTab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        listSupplier.setBackground(new java.awt.Color(255, 255, 255));
        listSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        suppliersStatusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "Activo", "Inactivo" }));
        suppliersStatusCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        suppliersCompanyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa" }));
        suppliersCompanyCombo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnNewSupplier.setText("Agregar Proveedor");
        btnNewSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnPrintSuppliers.setText("Exportar ");
        btnPrintSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearchSuppliers.setText("Buscar");
        btnSearchSuppliers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 22, 21)));
        btnSearchSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        quantityItems.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        quantityItems.setForeground(new java.awt.Color(102, 102, 102));
        quantityItems.setText("Visualizando 10 de 30 proveedores");

        suppliersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Compañía", "Teléfono", "Email", "Dirección", "Fecha de creación", "Fecha de actualización", "Estado"
            }
        ));
        jScrollPane1.setViewportView(suppliersTable);

        btnActivateSupplier.setText("Activar Proveedor");
        btnActivateSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDeactivateSupplier.setText("Desactivar Proveedor");
        btnDeactivateSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel16.setText("No. Página");

        pageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        jLabel17.setText("Registros por página");

        itemsPerPageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "25" }));
        itemsPerPageComboBox.setPreferredSize(new java.awt.Dimension(70, 22));

        btnEditSupplier.setText("Editar ");
        btnEditSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSeeAllSuppliers.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnSeeAllSuppliers.setText("Reestablecer");
        btnSeeAllSuppliers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(18, 22, 21)));
        btnSeeAllSuppliers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout listSupplierLayout = new javax.swing.GroupLayout(listSupplier);
        listSupplier.setLayout(listSupplierLayout);
        listSupplierLayout.setHorizontalGroup(
            listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listSupplierLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(listSupplierLayout.createSequentialGroup()
                        .addComponent(btnActivateSupplier)
                        .addGap(12, 12, 12)
                        .addComponent(btnDeactivateSupplier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(listSupplierLayout.createSequentialGroup()
                        .addComponent(suppliersStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(suppliersCompanyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrintSuppliers)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditSupplier)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(listSupplierLayout.createSequentialGroup()
                        .addComponent(btnSearchSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchSuppliersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeeAllSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quantityItems))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        listSupplierLayout.setVerticalGroup(
            listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listSupplierLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrintSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliersStatusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suppliersCompanyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(listSupplierLayout.createSequentialGroup()
                        .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchSuppliersTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityItems))
                            .addComponent(btnSearchSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addGroup(listSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActivateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeactivateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(pageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(itemsPerPageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSeeAllSuppliers, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(340, Short.MAX_VALUE))
        );

        suppliersNavegationTab.addTab("Listado", listSupplier);

        createSupplier.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(231, 241, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1192, 180));

        creationTitle.setBackground(new java.awt.Color(51, 51, 51));
        creationTitle.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        creationTitle.setForeground(new java.awt.Color(51, 51, 51));
        creationTitle.setText("Crear un nuevo proveedor");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Los proveedores de tus sistemas son pieza fundamental. Registra oportunamente.");

        iconCreateSupplier.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(iconCreateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creationTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 677, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creationTitle)
                    .addComponent(iconCreateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Nombre del proveedor:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Apellido del proveedor:");

        supplierRestrictionName.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionName.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionName.setText("Máximo 100 caracteres");

        supplierRestrictionLastname.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionLastname.setText("Máximo 100 caracteres");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Teléfono de contacto:");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Correo electrónico:");

        try {
            supplierPhoneTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        supplierRestrictionPhone.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionPhone.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionPhone.setText("Máximo 15 caracteres");

        supplierRestrictionEmail.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionEmail.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionEmail.setText("Máximo 100 caracteres");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Dirección:");

        supplierRestrictionAddress.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionAddress.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionAddress.setText("Máximo 200 caracteres");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Empresa:");

        btnCreateCompany.setText("Crear");
        btnCreateCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        supplierNewCompanyLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        supplierNewCompanyLabel.setForeground(new java.awt.Color(153, 153, 153));
        supplierNewCompanyLabel.setText("Nombre de empresa:");

        supplierRestrictionNewCompany.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionNewCompany.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionNewCompany.setText("Máximo 100 caracteres");

        btnCancelSaveSupplier.setText("Cancelar");
        btnCancelSaveSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSaveSupplier.setText("Guardar Proveedor");
        btnSaveSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout createSupplierLayout = new javax.swing.GroupLayout(createSupplier);
        createSupplier.setLayout(createSupplierLayout);
        createSupplierLayout.setHorizontalGroup(
            createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addGroup(createSupplierLayout.createSequentialGroup()
                .addGap(205, 205, 205)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(createSupplierLayout.createSequentialGroup()
                            .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(supplierCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(createSupplierLayout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnCreateCompany)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(iconInputMandatory4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(84, 84, 84)
                            .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(supplierNewCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(supplierNewCompanyLabel)))
                        .addGroup(createSupplierLayout.createSequentialGroup()
                            .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(createSupplierLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(205, 205, 205)
                                    .addComponent(iconInputMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(supplierRestrictionName)
                                    .addComponent(supplierNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(29, 29, 29)
                            .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(supplierRestrictionLastname)
                                .addComponent(supplierLastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(createSupplierLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(iconInputMandatory2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6))))
                        .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(supplierRestrictionAddress)
                            .addComponent(supplierAddressTxt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, createSupplierLayout.createSequentialGroup()
                                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(supplierPhoneTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(createSupplierLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(iconInputMandatory3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(supplierRestrictionPhone))
                                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(createSupplierLayout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createSupplierLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                        .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(supplierRestrictionEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(supplierEmailTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(supplierRestrictionNewCompany))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createSupplierLayout.createSequentialGroup()
                            .addComponent(btnCancelSaveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSaveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createSupplierLayout.setVerticalGroup(
            createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createSupplierLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(createSupplierLayout.createSequentialGroup()
                        .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(iconInputMandatory2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(supplierLastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierRestrictionLastname))
                    .addGroup(createSupplierLayout.createSequentialGroup()
                        .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createSupplierLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createSupplierLayout.createSequentialGroup()
                                .addComponent(iconInputMandatory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(supplierNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierRestrictionName)))
                .addGap(26, 26, 26)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5))
                    .addComponent(iconInputMandatory3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierPhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supplierEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplierRestrictionPhone)
                    .addComponent(supplierRestrictionEmail))
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(supplierAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierRestrictionAddress)
                .addGap(12, 12, 12)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createSupplierLayout.createSequentialGroup()
                        .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(btnCreateCompany))
                            .addComponent(supplierNewCompanyLabel))
                        .addGap(18, 18, 18)
                        .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplierCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierNewCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierRestrictionNewCompany))
                    .addComponent(iconInputMandatory4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(createSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelSaveSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );

        suppliersNavegationTab.addTab("Creación", createSupplier);

        updateSupplier.setBackground(new java.awt.Color(255, 255, 255));

        supplierRestrictionAddress1.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionAddress1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionAddress1.setText("Máximo 200 caracteres");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Empresa:");

        btnEditCreateCompany.setText("Crear");
        btnEditCreateCompany.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        supplierEditNewCompanyLabel.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        supplierEditNewCompanyLabel.setForeground(new java.awt.Color(153, 153, 153));
        supplierEditNewCompanyLabel.setText("Nombre de empresa:");

        supplierEditRestrictionNewCompany.setBackground(new java.awt.Color(204, 204, 204));
        supplierEditRestrictionNewCompany.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierEditRestrictionNewCompany.setText("Máximo 100 caracteres");

        btnCancelEditSupplier.setText("Cancelar");
        btnCancelEditSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Nuevo nombre:");

        btnUpdateSupplier.setText("Editar Proveedor");
        btnUpdateSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Nuevo apellido:");

        supplierRestrictionName1.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionName1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionName1.setText("Máximo 100 caracteres");

        supplierRestrictionLastname1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionLastname1.setText("Máximo 100 caracteres");

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Nuevo teléfono de contacto:");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Nuevo correo electrónico:");

        try {
            supplierEditPhoneTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        supplierRestrictionPhone1.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionPhone1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionPhone1.setText("Máximo 15 caracteres");

        supplierRestrictionEmail1.setBackground(new java.awt.Color(204, 204, 204));
        supplierRestrictionEmail1.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        supplierRestrictionEmail1.setText("Máximo 100 caracteres");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setText("Nueva dirección:");

        jPanel5.setBackground(new java.awt.Color(231, 241, 243));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1192, 180));

        creationTitle1.setBackground(new java.awt.Color(51, 51, 51));
        creationTitle1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        creationTitle1.setForeground(new java.awt.Color(51, 51, 51));
        creationTitle1.setText("Editar proveedor");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Actualiza la información de tus proveedores y no pierdas contacto para el abastecimiento de tus productos");

        iconEditSupplier.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(iconEditSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(creationTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 541, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creationTitle1)
                    .addComponent(iconEditSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel18.setText("Proveedor ID:");

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel19.setText("Telefono:");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setText("Email:");

        jLabel21.setBackground(new java.awt.Color(51, 51, 51));
        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel21.setText("Dirección:");

        supplierIDSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        supplierEmailSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel22.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel22.setText("Nombre:");

        jLabel23.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel23.setText("Apellido:");

        supplierAddressSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jPanel6.setBackground(new java.awt.Color(231, 241, 243));

        iconInfo.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel24.setText("Proveedor Seleccionada");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(iconInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        supplierPhoneSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel25.setText("Empresa:");

        supplierCompanySelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel26.setText("Estado:");

        supplierStatusSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel27.setText("Fecha de creación:");

        supplierCreatedAtSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel28.setText("Fecha de actualización:");

        supplierUpdatedAtSelected.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierUpdatedAtSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierCreatedAtSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierStatusSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierCompanySelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierAddressSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierEmailSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierPhoneSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierLastnameSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierNameSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(supplierIDSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierIDSelected, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierNameSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierLastnameSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addComponent(supplierPhoneSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierEmailSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierAddressSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierCompanySelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierStatusSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierCreatedAtSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(supplierUpdatedAtSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout updateSupplierLayout = new javax.swing.GroupLayout(updateSupplier);
        updateSupplier.setLayout(updateSupplierLayout);
        updateSupplierLayout.setHorizontalGroup(
            updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE)
            .addGroup(updateSupplierLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(supplierRestrictionAddress1)
                    .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(updateSupplierLayout.createSequentialGroup()
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(supplierEditPhoneTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(updateSupplierLayout.createSequentialGroup()
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(iconInputMandatory7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(supplierRestrictionPhone1))
                            .addGap(76, 76, 76)
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(supplierRestrictionEmail1)
                                    .addComponent(supplierEditEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(supplierEditAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(updateSupplierLayout.createSequentialGroup()
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(updateSupplierLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iconInputMandatory5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(updateSupplierLayout.createSequentialGroup()
                                        .addGap(191, 191, 191)
                                        .addComponent(supplierRestrictionName1)))
                                .addComponent(supplierEditNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(supplierRestrictionLastname1)
                                    .addComponent(supplierEditLastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(updateSupplierLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(iconInputMandatory6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel14)
                        .addGroup(updateSupplierLayout.createSequentialGroup()
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(supplierEditCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(updateSupplierLayout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnEditCreateCompany)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(iconInputMandatory8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(supplierEditNewCompanyLabel)
                                .addComponent(supplierEditNewCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(supplierEditRestrictionNewCompany, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(updateSupplierLayout.createSequentialGroup()
                            .addComponent(btnCancelEditSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        updateSupplierLayout.setVerticalGroup(
            updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateSupplierLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateSupplierLayout.createSequentialGroup()
                        .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateSupplierLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel11))
                            .addGroup(updateSupplierLayout.createSequentialGroup()
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(iconInputMandatory5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(iconInputMandatory6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(supplierEditLastnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(supplierEditNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(supplierRestrictionName1)
                                    .addComponent(supplierRestrictionLastname1))))
                        .addGap(30, 30, 30)
                        .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(iconInputMandatory7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13))
                        .addGap(20, 20, 20)
                        .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplierEditEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierEditPhoneTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplierRestrictionPhone1)
                            .addComponent(supplierRestrictionEmail1))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14)
                        .addGap(20, 20, 20)
                        .addComponent(supplierEditAddressTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(supplierRestrictionAddress1)
                        .addGap(30, 30, 30)
                        .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(updateSupplierLayout.createSequentialGroup()
                                .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(btnEditCreateCompany))
                                .addGap(20, 20, 20)
                                .addComponent(supplierEditCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(iconInputMandatory8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(updateSupplierLayout.createSequentialGroup()
                                .addComponent(supplierEditNewCompanyLabel)
                                .addGap(20, 20, 20)
                                .addComponent(supplierEditNewCompanyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(supplierEditRestrictionNewCompany)))
                        .addGap(50, 50, 50)
                        .addGroup(updateSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdateSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelEditSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(272, Short.MAX_VALUE))
        );

        suppliersNavegationTab.addTab("Edición", updateSupplier);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(suppliersNavegationTab, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(suppliersNavegationTab, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivateSupplier;
    public javax.swing.JButton btnCancelEditSupplier;
    public javax.swing.JButton btnCancelSaveSupplier;
    public javax.swing.JButton btnCreateCompany;
    public javax.swing.JButton btnDeactivateSupplier;
    public javax.swing.JButton btnEditCreateCompany;
    public javax.swing.JButton btnEditSupplier;
    public javax.swing.JButton btnNewSupplier;
    public javax.swing.JButton btnPrintSuppliers;
    public javax.swing.JButton btnSaveSupplier;
    public javax.swing.JButton btnSearchSuppliers;
    public javax.swing.JButton btnSeeAllSuppliers;
    public javax.swing.JButton btnUpdateSupplier;
    public javax.swing.JPanel createSupplier;
    public javax.swing.JLabel creationTitle;
    public javax.swing.JLabel creationTitle1;
    public javax.swing.JLabel iconCreateSupplier;
    public javax.swing.JLabel iconEditSupplier;
    public javax.swing.JLabel iconInfo;
    public javax.swing.JLabel iconInputMandatory;
    public javax.swing.JLabel iconInputMandatory2;
    public javax.swing.JLabel iconInputMandatory3;
    public javax.swing.JLabel iconInputMandatory4;
    public javax.swing.JLabel iconInputMandatory5;
    public javax.swing.JLabel iconInputMandatory6;
    public javax.swing.JLabel iconInputMandatory7;
    public javax.swing.JLabel iconInputMandatory8;
    public javax.swing.JComboBox<String> itemsPerPageComboBox;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel listSupplier;
    public javax.swing.JComboBox<String> pageComboBox;
    public javax.swing.JLabel quantityItems;
    public javax.swing.JTextField searchSuppliersTxt;
    public javax.swing.JLabel supplierAddressSelected;
    public javax.swing.JTextField supplierAddressTxt;
    public javax.swing.JLabel supplierCompanySelected;
    public javax.swing.JComboBox<String> supplierCompanyTxt;
    public javax.swing.JLabel supplierCreatedAtSelected;
    public javax.swing.JTextField supplierEditAddressTxt;
    public javax.swing.JComboBox<String> supplierEditCompanyTxt;
    public javax.swing.JTextField supplierEditEmailTxt;
    public javax.swing.JTextField supplierEditLastnameTxt;
    public javax.swing.JTextField supplierEditNameTxt;
    public javax.swing.JLabel supplierEditNewCompanyLabel;
    public javax.swing.JTextField supplierEditNewCompanyTxt;
    public javax.swing.JFormattedTextField supplierEditPhoneTxt;
    public javax.swing.JLabel supplierEditRestrictionNewCompany;
    public javax.swing.JLabel supplierEmailSelected;
    public javax.swing.JTextField supplierEmailTxt;
    public javax.swing.JLabel supplierIDSelected;
    public javax.swing.JLabel supplierLastnameSelected;
    public javax.swing.JTextField supplierLastnameTxt;
    public javax.swing.JLabel supplierNameSelected;
    public javax.swing.JTextField supplierNameTxt;
    public javax.swing.JLabel supplierNewCompanyLabel;
    public javax.swing.JTextField supplierNewCompanyTxt;
    public javax.swing.JLabel supplierPhoneSelected;
    public javax.swing.JFormattedTextField supplierPhoneTxt;
    public javax.swing.JLabel supplierRestrictionAddress;
    public javax.swing.JLabel supplierRestrictionAddress1;
    public javax.swing.JLabel supplierRestrictionEmail;
    public javax.swing.JLabel supplierRestrictionEmail1;
    public javax.swing.JLabel supplierRestrictionLastname;
    public javax.swing.JLabel supplierRestrictionLastname1;
    public javax.swing.JLabel supplierRestrictionName;
    public javax.swing.JLabel supplierRestrictionName1;
    public javax.swing.JLabel supplierRestrictionNewCompany;
    public javax.swing.JLabel supplierRestrictionPhone;
    public javax.swing.JLabel supplierRestrictionPhone1;
    public javax.swing.JLabel supplierStatusSelected;
    public javax.swing.JLabel supplierUpdatedAtSelected;
    public javax.swing.JComboBox<String> suppliersCompanyCombo;
    public javax.swing.JTabbedPane suppliersNavegationTab;
    public javax.swing.JComboBox<String> suppliersStatusCombo;
    public javax.swing.JTable suppliersTable;
    public javax.swing.JPanel updateSupplier;
    // End of variables declaration//GEN-END:variables
}
