package views.access;

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

        navegationPanel = new javax.swing.JTabbedPane();
        usersPane = new javax.swing.JPanel();
        rolesPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 900));

        navegationPanel.setBackground(new java.awt.Color(255, 255, 255));

        usersPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout usersPaneLayout = new javax.swing.GroupLayout(usersPane);
        usersPane.setLayout(usersPaneLayout);
        usersPaneLayout.setHorizontalGroup(
            usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1331, Short.MAX_VALUE)
        );
        usersPaneLayout.setVerticalGroup(
            usersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        navegationPanel.addTab("Usuarios", usersPane);

        rolesPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout rolesPaneLayout = new javax.swing.GroupLayout(rolesPane);
        rolesPane.setLayout(rolesPaneLayout);
        rolesPaneLayout.setHorizontalGroup(
            rolesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1331, Short.MAX_VALUE)
        );
        rolesPaneLayout.setVerticalGroup(
            rolesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        navegationPanel.addTab("Información de roles", rolesPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navegationPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(navegationPanel)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTabbedPane navegationPanel;
    public javax.swing.JPanel rolesPane;
    public javax.swing.JPanel usersPane;
    // End of variables declaration//GEN-END:variables
}