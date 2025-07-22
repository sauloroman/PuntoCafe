package views.sales;

public class CreateSale extends javax.swing.JFrame {

    private final CreateSaleInit styles = new CreateSaleInit(this);
    
    public CreateSale() {
        initComponents();
        styles.init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        itemsInSale = new javax.swing.JPanel();
        btnSaveSale = new javax.swing.JButton();
        titleSale = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userSeller = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        saleCode = new javax.swing.JLabel();
        saleListParent = new javax.swing.JPanel();
        saleList = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        disccount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        saleDate = new javax.swing.JLabel();
        navigationPane = new javax.swing.JTabbedPane();
        productsPane = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        searchProductTxt = new javax.swing.JTextField();
        productsGrid = new javax.swing.JPanel();
        pageCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        dishesPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        itemsInSale.setBackground(new java.awt.Color(255, 255, 255));
        itemsInSale.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 221, 221)));

        btnSaveSale.setText("Guardar Venta");

        titleSale.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        titleSale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleSale.setText("Información de venta");
        titleSale.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Vendedor:");

        userSeller.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        userSeller.setForeground(new java.awt.Color(153, 153, 153));
        userSeller.setText("Saulo Román Santillán Nava");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("Código:");

        saleCode.setBackground(new java.awt.Color(255, 255, 255));
        saleCode.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        saleCode.setForeground(new java.awt.Color(255, 0, 0));
        saleCode.setText("ABC123");

        saleListParent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout saleListParentLayout = new javax.swing.GroupLayout(saleListParent);
        saleListParent.setLayout(saleListParentLayout);
        saleListParentLayout.setHorizontalGroup(
            saleListParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        saleListParentLayout.setVerticalGroup(
            saleListParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        saleList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout saleListLayout = new javax.swing.GroupLayout(saleList);
        saleList.setLayout(saleListLayout);
        saleListLayout.setHorizontalGroup(
            saleListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        saleListLayout.setVerticalGroup(
            saleListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Subtotal:");

        subtotal.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        subtotal.setForeground(new java.awt.Color(102, 102, 102));
        subtotal.setText("$0.00");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Descuento:");

        disccount.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        disccount.setForeground(new java.awt.Color(102, 102, 102));
        disccount.setText("$0.00");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        jLabel8.setText("Total:");

        total.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        total.setText("$0.00");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("Fecha:");

        saleDate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        saleDate.setForeground(new java.awt.Color(153, 153, 153));
        saleDate.setText("25/12/2025");

        javax.swing.GroupLayout itemsInSaleLayout = new javax.swing.GroupLayout(itemsInSale);
        itemsInSale.setLayout(itemsInSaleLayout);
        itemsInSaleLayout.setHorizontalGroup(
            itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(itemsInSaleLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(itemsInSaleLayout.createSequentialGroup()
                        .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saleListParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSaveSale, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                            .addGroup(itemsInSaleLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(itemsInSaleLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(userSeller))
                                    .addGroup(itemsInSaleLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saleCode)
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(saleDate)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsInSaleLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saleList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(itemsInSaleLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subtotal)
                        .addContainerGap())
                    .addGroup(itemsInSaleLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(disccount)
                        .addContainerGap())
                    .addGroup(itemsInSaleLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(total)
                        .addContainerGap())))
        );
        itemsInSaleLayout.setVerticalGroup(
            itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, itemsInSaleLayout.createSequentialGroup()
                .addComponent(titleSale, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userSeller))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(saleCode)
                    .addComponent(jLabel10)
                    .addComponent(saleDate))
                .addGap(10, 10, 10)
                .addComponent(saleList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(saleListParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(subtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(disccount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(itemsInSaleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveSale, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        navigationPane.setBackground(new java.awt.Color(255, 255, 255));
        navigationPane.setOpaque(true);

        productsPane.setBackground(new java.awt.Color(255, 255, 255));

        btnSearch.setText("Buscar");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        productsGrid.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout productsGridLayout = new javax.swing.GroupLayout(productsGrid);
        productsGrid.setLayout(productsGridLayout);
        productsGridLayout.setHorizontalGroup(
            productsGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1108, Short.MAX_VALUE)
        );
        productsGridLayout.setVerticalGroup(
            productsGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Página");

        javax.swing.GroupLayout productsPaneLayout = new javax.swing.GroupLayout(productsPane);
        productsPane.setLayout(productsPaneLayout);
        productsPaneLayout.setHorizontalGroup(
            productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productsGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productsPaneLayout.createSequentialGroup()
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(searchProductTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(pageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        productsPaneLayout.setVerticalGroup(
            productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productsPaneLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(productsPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchProductTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pageCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(20, 20, 20)
                .addComponent(productsGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        navigationPane.addTab("Productos", productsPane);

        dishesPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout dishesPaneLayout = new javax.swing.GroupLayout(dishesPane);
        dishesPane.setLayout(dishesPaneLayout);
        dishesPaneLayout.setHorizontalGroup(
            dishesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
        );
        dishesPaneLayout.setVerticalGroup(
            dishesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 686, Short.MAX_VALUE)
        );

        navigationPane.addTab("Platillos", dishesPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navigationPane)
                .addGap(0, 0, 0)
                .addComponent(itemsInSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(itemsInSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(navigationPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSaveSale;
    public javax.swing.JButton btnSearch;
    public javax.swing.JLabel disccount;
    public javax.swing.JPanel dishesPane;
    public javax.swing.JPanel itemsInSale;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JTabbedPane navigationPane;
    public javax.swing.JComboBox<String> pageCombo;
    public javax.swing.JPanel productsGrid;
    public javax.swing.JPanel productsPane;
    public javax.swing.JLabel saleCode;
    public javax.swing.JLabel saleDate;
    public javax.swing.JPanel saleList;
    public javax.swing.JPanel saleListParent;
    public javax.swing.JTextField searchProductTxt;
    public javax.swing.JLabel subtotal;
    public javax.swing.JLabel titleSale;
    public javax.swing.JLabel total;
    public javax.swing.JLabel userSeller;
    // End of variables declaration//GEN-END:variables
}
