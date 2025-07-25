package views.purchases;

public class Purchases extends javax.swing.JPanel {

    private final PurchasesInit styleView = new PurchasesInit(this);
    
    public Purchases( PurchasesSuppliers purchasesSuppliers ) {
        initComponents();
        suppliersPane.add(purchasesSuppliers);
        styleView.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navegationPane = new javax.swing.JTabbedPane();
        suppliersPane = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 900));

        navegationPane.setBackground(new java.awt.Color(255, 255, 255));

        suppliersPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout suppliersPaneLayout = new javax.swing.GroupLayout(suppliersPane);
        suppliersPane.setLayout(suppliersPaneLayout);
        suppliersPaneLayout.setHorizontalGroup(
            suppliersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1331, Short.MAX_VALUE)
        );
        suppliersPaneLayout.setVerticalGroup(
            suppliersPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );

        navegationPane.addTab("Proveedores", suppliersPane);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1331, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );

        navegationPane.addTab("Compras Realizadas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(navegationPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navegationPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTabbedPane navegationPane;
    public javax.swing.JPanel suppliersPane;
    // End of variables declaration//GEN-END:variables
}
