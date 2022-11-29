package View;

import Controller.ProductsDAO;
import Controller.TransactionsDAO;
import Model.Product;
import Model.Transaction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vinicius
 */
public class jifNewTransaction extends javax.swing.JDialog {

    /**
     * Creates new form jifNewTransaction
     */
    public jifNewTransaction(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        addProducts();
    }

    public void addProducts() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        ProductsDAO productsDAO = new ProductsDAO();

        jcProducts.setModel(model);

        productsDAO.getAll().forEach((Product product) -> {
            model.addElement(product.getName());

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcProducts = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jsQuantity = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jcTypeOfTransaction = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtValue = new javax.swing.JTextField();
        jbSaveTransaction = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Transação");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setText("Nome do Cliente");

        jtName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setText("Escolha o Produto");

        jcProducts.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jcProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel5.setText("Qtd");

        jsQuantity.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jsQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setText("Tipo de Transação (Entrada / Saída)");

        jcTypeOfTransaction.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jcTypeOfTransaction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Saída" }));
        jcTypeOfTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel7.setText("Valor");

        jtValue.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jbSaveTransaction.setBackground(new java.awt.Color(108, 92, 231));
        jbSaveTransaction.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jbSaveTransaction.setForeground(new java.awt.Color(223, 230, 233));
        jbSaveTransaction.setText("Salvar");
        jbSaveTransaction.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbSaveTransaction.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbSaveTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveTransactionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtName)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addGap(98, 98, 98))
                            .addComponent(jcProducts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                .addGap(131, 131, 131))
                            .addComponent(jsQuantity)))
                    .addComponent(jcTypeOfTransaction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtValue)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(63, 63, 63)))
                        .addGap(136, 136, 136))
                    .addComponent(jbSaveTransaction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtName, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcProducts)
                    .addComponent(jsQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcTypeOfTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtValue, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbSaveTransaction, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(510, 403));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbSaveTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveTransactionActionPerformed
        try {
            TransactionsDAO transactionDAO = new TransactionsDAO();
            Transaction transaction = new Transaction();

            transaction.setName(jtName.getText());
            transaction.setProductId((int) jcProducts.getSelectedItem());
            transaction.setQuantity((int) jsQuantity.getValue());
            transaction.setValue(Float.parseFloat(jtValue.getText()));
            transaction.setTypeOfTransaction((String) jcTypeOfTransaction.getSelectedItem());
            transactionDAO.save(transaction);

            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao salvar: " + ex.getMessage());
        }
    }//GEN-LAST:event_jbSaveTransactionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jifNewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jifNewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jifNewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jifNewTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jifNewTransaction dialog = new jifNewTransaction(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbSaveTransaction;
    private javax.swing.JComboBox<String> jcProducts;
    private javax.swing.JComboBox<String> jcTypeOfTransaction;
    private javax.swing.JSpinner jsQuantity;
    private javax.swing.JTextField jtName;
    private javax.swing.JTextField jtValue;
    // End of variables declaration//GEN-END:variables
}
