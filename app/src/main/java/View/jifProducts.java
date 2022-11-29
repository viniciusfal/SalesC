package View;

import Controller.ProductsDAO;
import Model.Product;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class jifProducts extends javax.swing.JInternalFrame {

    public jifProducts() {
        initComponents();

    }

//  Metodos Table //
    public void readJTable() {
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
        model.setRowCount(0);

        ProductsDAO productsDAO = new ProductsDAO();

        productsDAO.getAll().stream().forEach((p) -> {

            model.addRow(new Object[]{
                p.getId(),
                p.getName(),
                p.getSize(),
                p.getColor(),
                p.getCreated_at(),
                p.getUpdated_at()

            });
        });

    }

    public void readJTableForName(String name) {

        if (!jtSearch.getText().isEmpty()) {

            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
            model.setRowCount(0);

            ProductsDAO productsDAO = new ProductsDAO();

            productsDAO.getForName(name).stream().forEach((p) -> {

                model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getSize(),
                    p.getColor(),
                    p.getCreated_at(),
                    p.getUpdated_at()

                });
            });

        } else {
            JOptionPane.showMessageDialog(null, "Digite o nome de um produto no "
                    + "campo 'argumento' ");
        }

    }

    public void readJTableForColor(String color) {

        if (!jtSearch.getText().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
            model.setRowCount(0);

            ProductsDAO productsDAO = new ProductsDAO();

            productsDAO.getForColor(color).stream().forEach((p) -> {

                model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getSize(),
                    p.getColor(),
                    p.getCreated_at(),
                    p.getUpdated_at()

                });
            });
        } else {
            JOptionPane.showMessageDialog(null, "Digite a cor de um(uns) "
                    + "produto(s) no campo 'argumento'");
        }

    }

    public void readJTableForSize(int size) {

        if (!jtSearch.getText().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();
            model.setRowCount(0);

            ProductsDAO productsDAO = new ProductsDAO();

            productsDAO.getForSize(size).stream().forEach((p) -> {

                model.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getSize(),
                    p.getColor(),
                    p.getCreated_at(),
                    p.getUpdated_at()

                });
            });
        } else {
            JOptionPane.showMessageDialog(null, "Digite o tamanho do(s) calçado(s)"
                    + " no campo 'argumento'");
        }

    }

    public void removeProductInJTable() {
        ProductsDAO productsDAO = new ProductsDAO();
        DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();

//      Pego a linha selecionada da tabela
        int row = jTableProducts.getSelectedRow();

//      Confirmar se o usuario deseja excluir o Produto selecionado
        int dialogButton = JOptionPane.YES_NO_OPTION; // 0 = YES
        int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que "
                + "deseja excluir esse produto?", "Atenção", dialogButton);

        if (dialogResult == 0) {
//          Removo do banco e recarrego os produtos de acordo com o seu filtro
            productsDAO.removeById((int) model.getValueAt(row, 0));

            if (jcList.getModel().getSelectedItem().equals("Nome do produto")) {
                readJTableForName(jtSearch.getText());

            }
            if (jcList.getModel().getSelectedItem().equals("Cor")) {
                readJTableForColor(jtSearch.getText());
            } else {
                readJTableForSize(Integer.parseInt(jtSearch.getText()));
            }
        }

    }

    public void updateProduct() {
        if (jTableProducts.getSelectedRow() != -1) {
            ProductsDAO productsDAO = new ProductsDAO();
            Product product = new Product();
            DefaultTableModel model = (DefaultTableModel) jTableProducts.getModel();

            int row = jTableProducts.getSelectedRow();

            product.setName((String) model.getValueAt(row, 1));
            product.setSize((int) model.getValueAt(row, 2));
            product.setColor((String) model.getValueAt(row, 3));
            product.setCreated_at((Date) model.getValueAt(row, 4));
            product.setUpdated_at(product.getUpdated_at());

            product.setId((int) model.getValueAt(row, 0));

            productsDAO.update(product);

            JOptionPane.showMessageDialog(null, "Produto Atualizado com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "Escola um produto, altere a "
                    + "informação que deseja e clique em Atualizar");
        }

    }

//  Fim dos Metodos Table //
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcList = new javax.swing.JComboBox<>();
        jtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jsTable = new javax.swing.JScrollPane();
        jTableProducts = new javax.swing.JTable();
        jbSearch = new javax.swing.JButton();
        jbgetAll = new javax.swing.JButton();
        jbEditProduct = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Produtos");

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Filtro:");

        jcList.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jcList.setForeground(new java.awt.Color(99, 110, 114));
        jcList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome do produto", "Cor", "Tamanho" }));
        jcList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jtSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jtSearch.setForeground(new java.awt.Color(99, 110, 114));
        jtSearch.setToolTipText("");
        jtSearch.setSelectedTextColor(new java.awt.Color(99, 110, 114));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Argumento:");

        jTableProducts.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTableProducts.setForeground(new java.awt.Color(99, 110, 114));
        jTableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome Produto", "Tamanho", "Cor", "Data de inserção", "Data de atualização"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProducts.getTableHeader().setReorderingAllowed(false);
        jsTable.setViewportView(jTableProducts);

        jbSearch.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbSearch.setText("Buscar");
        jbSearch.setToolTipText("Realizar a busca pelo filtro");
        jbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbgetAll.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbgetAll.setText("Listar tudo");
        jbgetAll.setToolTipText("Listar todos os produtos");
        jbgetAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbgetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbgetAllActionPerformed(evt);
            }
        });

        jbEditProduct.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbEditProduct.setText("Atualizar");
        jbEditProduct.setToolTipText("Após alterar o(s) campo(s) que deseja, CLIQUE AQUI para efetuar a atualização no banco de dados");
        jbEditProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbEditProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditProductActionPerformed(evt);
            }
        });

        jbExit.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbExit.setText("Sair");
        jbExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setText("Deletar");
        jButton1.setToolTipText("Selecione e delete o produto");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jsTable, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jbgetAll, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jbEditProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtSearch)
                    .addComponent(jcList, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbgetAll, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEditProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        setBounds(210, 20, 945, 472);
    }// </editor-fold>//GEN-END:initComponents

    private void jbEditProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditProductActionPerformed
        updateProduct();

    }//GEN-LAST:event_jbEditProductActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        dispose();
    }//GEN-LAST:event_jbExitActionPerformed

    private void jbgetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbgetAllActionPerformed

        readJTable();
        jtSearch.setText("");
    }//GEN-LAST:event_jbgetAllActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed

        if (jcList.getModel().getSelectedItem().equals("Nome do produto")) {
            readJTableForName(jtSearch.getText());

        }
        if (jcList.getModel().getSelectedItem().equals("Cor")) {
            readJTableForColor(jtSearch.getText());
        } else {
            readJTableForSize(Integer.parseInt(jtSearch.getText()));
        }


    }//GEN-LAST:event_jbSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        removeProductInJTable();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jTableProducts;
    private javax.swing.JButton jbEditProduct;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbSearch;
    private javax.swing.JButton jbgetAll;
    private javax.swing.JComboBox<String> jcList;
    private javax.swing.JScrollPane jsTable;
    private javax.swing.JTextField jtSearch;
    // End of variables declaration//GEN-END:variables
}
