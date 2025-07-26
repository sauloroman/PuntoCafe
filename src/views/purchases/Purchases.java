package views.purchases;

public class Purchases extends javax.swing.JPanel {

    private final PurchasesInit styleView = new PurchasesInit(this);
    
    public Purchases( PurchasesSuppliers purchasesSuppliers, PurchasesBuy purchasesBuy ) {
        initComponents();
        suppliersPane.add(purchasesSuppliers);
        buyPanel.add(purchasesBuy);
        styleView.init();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navegationPane = new javax.swing.JTabbedPane();
        buyPanel = new javax.swing.JPanel();
        suppliersPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 900));

        navegationPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout buyPanelLayout = new javax.swing.GroupLayout(buyPanel);
        buyPanel.setLayout(buyPanelLayout);
        buyPanelLayout.setHorizontalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1331, Short.MAX_VALUE)
        );
        buyPanelLayout.setVerticalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 865, Short.MAX_VALUE)
        );

        navegationPane.addTab("Compras Realizadas", buyPanel);

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
    public javax.swing.JPanel buyPanel;
    public javax.swing.JTabbedPane navegationPane;
    public javax.swing.JPanel suppliersPane;
    // End of variables declaration//GEN-END:variables
}
