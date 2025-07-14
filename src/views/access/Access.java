package views.access;

import views.inits.AccessInit;

public class Access extends javax.swing.JPanel {
    
    private final AccessInit styleView = new AccessInit(this);
    
    public Access(AccessRoles accessRoles, AccessUsers accessUsers) {
        initComponents();
        
        rolesPane.add(accessRoles);
        usersPane.add(accessUsers);
        
        styleView.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        navegationPanel = new javax.swing.JTabbedPane();
        rolesPane = new javax.swing.JPanel();
        usersPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 900));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(55, 123, 76));
        jLabel1.setText("Control de usuarios del sistema");

        navegationPanel.setBackground(new java.awt.Color(255, 255, 255));

        rolesPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout rolesPaneLayout = new javax.swing.GroupLayout(rolesPane);
        rolesPane.setLayout(rolesPaneLayout);
        rolesPaneLayout.setHorizontalGroup(
            rolesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        rolesPaneLayout.setVerticalGroup(
            rolesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );

        navegationPanel.addTab("Roles", rolesPane);

        usersPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout usersPaneLayout = new javax.swing.GroupLayout(usersPane);
        usersPane.setLayout(usersPaneLayout);
        usersPaneLayout.setHorizontalGroup(
            usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        usersPaneLayout.setVerticalGroup(
            usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );

        navegationPanel.addTab("Usuarios", usersPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(navegationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(navegationPanel)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JTabbedPane navegationPanel;
    public javax.swing.JPanel rolesPane;
    public javax.swing.JPanel usersPane;
    // End of variables declaration//GEN-END:variables
}
