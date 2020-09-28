package view;

import entidade.Material;
import javax.swing.JOptionPane;
import mb.MaterialMb;

/**
 *
 * @author macedo
 */
public class InserirMaterial extends javax.swing.JFrame {

    Material material = new Material();
    MaterialMb mb = new MaterialMb();

    public InserirMaterial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblLote = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLote = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JTextField();
        txtValidade = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lblTitulo.setText("CADASTRO DE MATERIAL");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 12, -1, -1));

        lblNome.setText("Nome: ");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 90, -1, -1));

        lblLote.setText("Lote: ");
        jPanel1.add(lblLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 135, -1, -1));

        jLabel3.setText("Validade: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 135, -1, -1));

        lblFornecedor.setText("Fornecedor: ");
        jPanel1.add(lblFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 188, -1, -1));

        lblQuantidade.setText("Quantidade: ");
        jPanel1.add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 241, -1, -1));
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 85, 532, -1));
        jPanel1.add(txtLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 130, 137, -1));
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 236, 62, -1));
        jPanel1.add(txtFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 183, 492, -1));
        jPanel1.add(txtValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 130, 134, -1));

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        btnCadastrar.setText("CADASTRAR");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 277, 152, -1));

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/edit-clear.png"))); // NOI18N
        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 277, 136, -1));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/go-previous.png"))); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 277, 133, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Menu mn = new Menu();
        mn.setLocationRelativeTo(null);
        mn.setVisible(true);
        mn.setResizable(false);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        salvar();
    }//GEN-LAST:event_btnCadastrarActionPerformed
    public void salvar() {
        try {
            if (converter() == true) {
                mb.salvar(material);
                JOptionPane.showMessageDialog(null, "Material salvo com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar material");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Insira um material");
        }
    }

    public void limpar() {
        txtFornecedor.setText("");
        txtLote.setText("");
        txtNome.setText("");
        txtQuantidade.setText("");
        txtValidade.setText("");

    }

    public boolean converter() {
        Integer quantidade;

        material.setFornecedor(txtFornecedor.getText().trim().toUpperCase());
        material.setLote(txtLote.getText().trim());
        material.setNome(txtNome.getText().trim().toUpperCase());
        material.setValidade(txtValidade.getText().trim());

        quantidade = Integer.parseInt(txtQuantidade.getText());
        material.setQuantidade(quantidade);

        return true;
    }

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
            java.util.logging.Logger.getLogger(InserirMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InserirMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InserirMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InserirMaterial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InserirMaterial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblLote;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValidade;
    // End of variables declaration//GEN-END:variables
}
