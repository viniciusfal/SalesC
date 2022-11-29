
package View;

import Controller.TransactionsDAO;
import Model.Transaction;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinicius
 */
public class jifTransactions extends javax.swing.JInternalFrame {

    /**
     * Creates new form jifTransactions
     */
    public jifTransactions() {
        initComponents();
    }

    public void readJTable() {
        DefaultTableModel model = (DefaultTableModel) jtTransactions.getModel();
        model.setRowCount(0);

        TransactionsDAO transactionsDAO = new TransactionsDAO();

        transactionsDAO.getAll().forEach((t) -> {
            model.addRow(new Object[]{
                t.getId(),
                t.getName(),
                t.getProductId(),
                t.getQuantity(),
                t.getTypeOfTransaction(),
                t.getValue(),
                t.getCreated_at()
            });

        });

    }

    public void readJTableForName(String name) {

        if (!jtTransactionsSearch.getText().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) jtTransactions.getModel();
            model.setRowCount(0);

            TransactionsDAO transactionsDAO = new TransactionsDAO();

            transactionsDAO.getForName(name).forEach((t) -> {
                model.addRow(new Object[]{
                    t.getId(),
                    t.getName(),
                    t.getProductId(),
                    t.getQuantity(),
                    t.getTypeOfTransaction(),
                    t.getValue(),
                    t.getCreated_at()
                });

            });

        } else {
            JOptionPane.showMessageDialog(null, "Digite o nome do cliente no "
                    + "campo 'Argumento' ");
        }

    }

    public void readJTableForType(String typeOfTransaction) {
        DefaultTableModel model = (DefaultTableModel) jtTransactions.getModel();
        model.setRowCount(0);

        TransactionsDAO transactionsDAO = new TransactionsDAO();

        transactionsDAO.getForType(typeOfTransaction).forEach((t) -> {
            model.addRow(new Object[]{
                t.getId(),
                t.getName(),
                t.getProductId(),
                t.getQuantity(),
                t.getTypeOfTransaction(),
                t.getValue(),
                t.getCreated_at()
            });

        });

    }

    public void removeInJTable() {
        TransactionsDAO transactionsDAO = new TransactionsDAO();
        DefaultTableModel model = (DefaultTableModel) jtTransactions.getModel();

        int row = jtTransactions.getSelectedRow();

//      Confirmar se o usuario deseja excluir a transação
        int dialogButton = JOptionPane.YES_NO_OPTION;  // 0 = YES.
        int dialogResult = JOptionPane.showConfirmDialog(this, "Tem certeza que "
                + "deseja excluir essa transação?", "Atenção", dialogButton);

        if (dialogResult == 0) {
//          Removo do banco
            transactionsDAO.removeById((int) model.getValueAt(row, 0));

//          carrego novamente (atualizo a busca)
            if (jcFilterTransactions.getModel().getSelectedItem().equals("Nome")) {
                readJTableForName(jtTransactionsSearch.getText());
            }

            if (jcFilterTransactions.getModel().getSelectedItem().equals("Entradas")) {
                readJTableForType("Entrada");
            }
            if (jcFilterTransactions.getModel().getSelectedItem().equals("Saidas")) {
                readJTableForType("Saída");
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jcFilterTransactions = new javax.swing.JComboBox<>();
        jtTransactionsSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTransactions = new javax.swing.JTable();
        jbSearch = new javax.swing.JButton();
        jbAllTransactions = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Transações");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Filtro:");

        jcFilterTransactions.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jcFilterTransactions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Entradas", "Saidas", " " }));
        jcFilterTransactions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 14))); // NOI18N

        jtTransactionsSearch.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jtTransactionsSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTransactionsSearchActionPerformed(evt);
            }
        });

        jtTransactions.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jtTransactions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome", "Produto", "Quantidade", "Tipo", "Valor", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTransactions);

        jbSearch.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbSearch.setText("Buscar");
        jbSearch.setToolTipText("Busque por filtro");
        jbSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jbAllTransactions.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbAllTransactions.setText("Listar Tudo");
        jbAllTransactions.setToolTipText("Liste todas as Transações");
        jbAllTransactions.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbAllTransactions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAllTransactionsActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setText("Argumento:");

        jbDelete.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbDelete.setText("Deletar");
        jbDelete.setToolTipText("Delete a transação Selecionada");
        jbDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcFilterTransactions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTransactionsSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(391, 391, 391))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jbAllTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jbExit, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jbDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtTransactionsSearch)
                    .addComponent(jcFilterTransactions, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAllTransactions, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        setBounds(210, 20, 992, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // Codigo para Maximizar a tela ao maximo

    }//GEN-LAST:event_formInternalFrameOpened

    private void jtTransactionsSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtTransactionsSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtTransactionsSearchActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        dispose();

    }//GEN-LAST:event_jbExitActionPerformed

    private void jbAllTransactionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAllTransactionsActionPerformed

        readJTable();

        jtTransactionsSearch.setText("");
    }//GEN-LAST:event_jbAllTransactionsActionPerformed

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed

        if (jcFilterTransactions.getModel().getSelectedItem().equals("Nome")) {
            readJTableForName(jtTransactionsSearch.getText());
        }

        if (jcFilterTransactions.getModel().getSelectedItem().equals("Entradas")) {
            readJTableForType("Entrada");
        }
        if (jcFilterTransactions.getModel().getSelectedItem().equals("Saidas")) {
            readJTableForType("Saída");
        }


    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        removeInJTable();
    }//GEN-LAST:event_jbDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAllTransactions;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbSearch;
    private javax.swing.JComboBox<String> jcFilterTransactions;
    private javax.swing.JTable jtTransactions;
    private javax.swing.JTextField jtTransactionsSearch;
    // End of variables declaration//GEN-END:variables
}
