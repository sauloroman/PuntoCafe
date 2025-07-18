package views.access;

public class AccessRoles extends javax.swing.JPanel {

    private final AccessRolesInit style = new AccessRolesInit(this);
    
    public AccessRoles() {
        initComponents();
        style.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        iconAdmin = new javax.swing.JLabel();
        quantityAdmins = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        adminCheck = new javax.swing.JLabel();
        adminCheck1 = new javax.swing.JLabel();
        adminCheck2 = new javax.swing.JLabel();
        adminCheck3 = new javax.swing.JLabel();
        adminCheck4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        adminCheck5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        iconSeller = new javax.swing.JLabel();
        quantitySellers = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        adminCheck6 = new javax.swing.JLabel();
        adminCheck7 = new javax.swing.JLabel();
        adminCheck8 = new javax.swing.JLabel();
        adminCheck9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        adminCheck11 = new javax.swing.JLabel();
        adminCheck12 = new javax.swing.JLabel();
        adminCheck13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        iconSupervisor = new javax.swing.JLabel();
        quantitySupervisors = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        adminCheck10 = new javax.swing.JLabel();
        adminCheck14 = new javax.swing.JLabel();
        adminCheck15 = new javax.swing.JLabel();
        adminCheck16 = new javax.swing.JLabel();
        adminCheck17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        adminCheck18 = new javax.swing.JLabel();
        adminCheck19 = new javax.swing.JLabel();
        logoRH = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 400));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 51, 255));
        jLabel4.setText("Administrador");

        jLabel5.setBackground(new java.awt.Color(153, 51, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Acceso Total");
        jLabel5.setOpaque(true);

        quantityAdmins.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        quantityAdmins.setText("1 usuarios");

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Activos mientras esté asignados");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setText("Permisos");

        adminCheck.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck.setText("Gestiona usuarios, proveedores, productos, platillos y menús.");

        adminCheck1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck1.setText("Realiza ventas al igual que los demás roles.");

        adminCheck2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck2.setText("Consulta todas las ventas históricas por usuario o por día.");

        adminCheck3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck3.setText("Genera reportes de venta por fecha, usuario o producto.");

        adminCheck4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck4.setText("Ve estadísticas de productos vendidos.");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel9.setText("Restricciones");

        adminCheck5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck5.setText("Sin restricciones en el módulo de venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(iconAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(quantityAdmins))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminCheck5)
                            .addComponent(jLabel9)
                            .addComponent(adminCheck4)
                            .addComponent(adminCheck3)
                            .addComponent(adminCheck2)
                            .addComponent(adminCheck1)
                            .addComponent(adminCheck)
                            .addComponent(jLabel8))
                        .addGap(0, 35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(quantityAdmins)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addComponent(adminCheck)
                .addGap(10, 10, 10)
                .addComponent(adminCheck1)
                .addGap(10, 10, 10)
                .addComponent(adminCheck2)
                .addGap(10, 10, 10)
                .addComponent(adminCheck3)
                .addGap(10, 10, 10)
                .addComponent(adminCheck4)
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addGap(10, 10, 10)
                .addComponent(adminCheck5)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
        jPanel4.setPreferredSize(new java.awt.Dimension(350, 400));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Vendedor");

        jLabel11.setBackground(new java.awt.Color(255, 204, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Acceso Bajo");
        jLabel11.setOpaque(true);

        quantitySellers.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        quantitySellers.setText("5 usuarios");

        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Activos mientras esté asignados");

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel14.setText("Permisos");

        adminCheck6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck6.setText("Inicia ventas");

        adminCheck7.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck7.setText("Busca productos por nombre o código");

        adminCheck8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck8.setText("Selecciona cantidades y registra ventas con precio estandar.");

        adminCheck9.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck9.setText("Consulta sus ventas de fecha actual.");

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setText("Restricciones");

        adminCheck11.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck11.setText("No puede consultar ventas de otros usuarios");

        adminCheck12.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck12.setText("No puede modificar ventas pasadas.");

        adminCheck13.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck13.setText("No puede ver reportes financieros completos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(iconSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(quantitySellers))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminCheck13)
                            .addComponent(adminCheck12)
                            .addComponent(adminCheck11)
                            .addComponent(jLabel15)
                            .addComponent(adminCheck9)
                            .addComponent(adminCheck8)
                            .addComponent(adminCheck7)
                            .addComponent(adminCheck6)
                            .addComponent(jLabel14))
                        .addGap(0, 43, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconSeller, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(quantitySellers)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addGap(10, 10, 10)
                .addComponent(adminCheck6)
                .addGap(10, 10, 10)
                .addComponent(adminCheck7)
                .addGap(10, 10, 10)
                .addComponent(adminCheck8)
                .addGap(10, 10, 10)
                .addComponent(adminCheck9)
                .addGap(20, 20, 20)
                .addComponent(jLabel15)
                .addGap(10, 10, 10)
                .addComponent(adminCheck11)
                .addGap(10, 10, 10)
                .addComponent(adminCheck12)
                .addGap(10, 10, 10)
                .addComponent(adminCheck13)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 400));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 51));
        jLabel16.setText("Supervisor");

        jLabel17.setBackground(new java.awt.Color(0, 153, 51));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Acceso Medio");
        jLabel17.setOpaque(true);

        quantitySupervisors.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        quantitySupervisors.setText("2 usuarios");

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Activos mientras esté asignados");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel20.setText("Permisos");

        adminCheck10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck10.setText("Visualiza reportes y consulta inventario ");

        adminCheck14.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck14.setText("Verifica compras y accede a menús");

        adminCheck15.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck15.setText("Consulta todas las ventas registradas");

        adminCheck16.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck16.setText("Revisa detalles de cada venta");

        adminCheck17.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck17.setText("Valida precios y detecta inconsistencias");

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel21.setText("Restricciones");

        adminCheck18.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck18.setText("No puede registrar nuevas ventas");

        adminCheck19.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        adminCheck19.setText("No puede modificar precios y ventas realizadas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(iconSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(quantitySupervisors))
                        .addContainerGap(106, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminCheck19)
                            .addComponent(adminCheck18)
                            .addComponent(jLabel21)
                            .addComponent(adminCheck17)
                            .addComponent(adminCheck16)
                            .addComponent(adminCheck15)
                            .addComponent(adminCheck14)
                            .addComponent(adminCheck10)
                            .addComponent(jLabel20))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(quantitySupervisors)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)))
                .addGap(20, 20, 20)
                .addComponent(jLabel20)
                .addGap(10, 10, 10)
                .addComponent(adminCheck10)
                .addGap(10, 10, 10)
                .addComponent(adminCheck14)
                .addGap(10, 10, 10)
                .addComponent(adminCheck15)
                .addGap(10, 10, 10)
                .addComponent(adminCheck16)
                .addGap(10, 10, 10)
                .addComponent(adminCheck17)
                .addGap(20, 20, 20)
                .addComponent(jLabel21)
                .addGap(10, 10, 10)
                .addComponent(adminCheck18)
                .addGap(10, 10, 10)
                .addComponent(adminCheck19)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/images/banner-blue.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setText("Roles del sistema");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("El rol asignado a cada usuario implica diversas acciones y permisos. ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(476, 476, 476)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoRH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(logoRH, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminCheck;
    private javax.swing.JLabel adminCheck1;
    private javax.swing.JLabel adminCheck10;
    private javax.swing.JLabel adminCheck11;
    private javax.swing.JLabel adminCheck12;
    private javax.swing.JLabel adminCheck13;
    private javax.swing.JLabel adminCheck14;
    private javax.swing.JLabel adminCheck15;
    private javax.swing.JLabel adminCheck16;
    private javax.swing.JLabel adminCheck17;
    private javax.swing.JLabel adminCheck18;
    private javax.swing.JLabel adminCheck19;
    private javax.swing.JLabel adminCheck2;
    private javax.swing.JLabel adminCheck3;
    private javax.swing.JLabel adminCheck4;
    private javax.swing.JLabel adminCheck5;
    private javax.swing.JLabel adminCheck6;
    private javax.swing.JLabel adminCheck7;
    private javax.swing.JLabel adminCheck8;
    private javax.swing.JLabel adminCheck9;
    public javax.swing.JLabel iconAdmin;
    public javax.swing.JLabel iconSeller;
    public javax.swing.JLabel iconSupervisor;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JLabel logoRH;
    public javax.swing.JLabel quantityAdmins;
    public javax.swing.JLabel quantitySellers;
    public javax.swing.JLabel quantitySupervisors;
    // End of variables declaration//GEN-END:variables
}
