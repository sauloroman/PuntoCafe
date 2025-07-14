package views.warehouse;

import views.inits.WarehouseInit;

public class Warehouse extends javax.swing.JPanel {
    
    private final WarehouseInit styleView = new WarehouseInit(this); 
    
    public Warehouse(
            WarehouseCategories warehouseCategories, 
            WarehouseProducts warehouseProducts,
            WarehouseDishes warehouseDishes
    ) {
        initComponents();
        
        categoriesPane.add(warehouseCategories);
        productsPane.add(warehouseProducts);
        dishesPane.add(warehouseDishes);
        
        styleView.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navegationPane = new javax.swing.JTabbedPane();
        categoriesPane = new javax.swing.JPanel();
        productsPane = new javax.swing.JPanel();
        dishesPane = new javax.swing.JPanel();
        menusPane = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 900));

        navegationPane.setBackground(new java.awt.Color(255, 255, 255));
        navegationPane.setAlignmentX(1.0F);
        navegationPane.setAlignmentY(1.0F);
        navegationPane.setFocusable(false);

        categoriesPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout categoriesPaneLayout = new javax.swing.GroupLayout(categoriesPane);
        categoriesPane.setLayout(categoriesPaneLayout);
        categoriesPaneLayout.setHorizontalGroup(
            categoriesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1194, Short.MAX_VALUE)
        );
        categoriesPaneLayout.setVerticalGroup(
            categoriesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        navegationPane.addTab("Categorías", categoriesPane);

        productsPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout productsPaneLayout = new javax.swing.GroupLayout(productsPane);
        productsPane.setLayout(productsPaneLayout);
        productsPaneLayout.setHorizontalGroup(
            productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1194, Short.MAX_VALUE)
        );
        productsPaneLayout.setVerticalGroup(
            productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        navegationPane.addTab("Productos", productsPane);

        dishesPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dishesPaneLayout = new javax.swing.GroupLayout(dishesPane);
        dishesPane.setLayout(dishesPaneLayout);
        dishesPaneLayout.setHorizontalGroup(
            dishesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1194, Short.MAX_VALUE)
        );
        dishesPaneLayout.setVerticalGroup(
            dishesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        navegationPane.addTab("Platillos", dishesPane);

        javax.swing.GroupLayout menusPaneLayout = new javax.swing.GroupLayout(menusPane);
        menusPane.setLayout(menusPaneLayout);
        menusPaneLayout.setHorizontalGroup(
            menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1194, Short.MAX_VALUE)
        );
        menusPaneLayout.setVerticalGroup(
            menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 859, Short.MAX_VALUE)
        );

        navegationPane.addTab("Menús Semanales", menusPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(navegationPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navegationPane))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel categoriesPane;
    public javax.swing.JPanel dishesPane;
    public javax.swing.JPanel menusPane;
    public javax.swing.JTabbedPane navegationPane;
    public javax.swing.JPanel productsPane;
    // End of variables declaration//GEN-END:variables
}
