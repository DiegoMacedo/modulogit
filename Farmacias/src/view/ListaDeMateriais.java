package view;

import dao.MaterialDao;
import entidade.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mb.MaterialMb;

/**
 *
 * @author macedo
 */
public final class ListaDeMateriais extends javax.swing.JFrame {

    private final DefaultTableModel modelo = new DefaultTableModel();
    Material material = new Material();
    MaterialMb mb = new MaterialMb();

    public ListaDeMateriais() {
        initComponents();
        ordenarPorId(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        cmbListar = new javax.swing.JComboBox();
        lblOrdenar = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Lote", "Validade", "Fornecedor", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        cmbListar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECIONE--", "CÓDIGO", "NOME", "FORNECEDOR", "QUANTIDADE" }));
        cmbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListarActionPerformed(evt);
            }
        });

        lblOrdenar.setText("ORDENAR POR: ");

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/go-previous.png"))); // NOI18N
        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(32, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbListar, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrdenar)
                    .addComponent(cmbListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListarActionPerformed
        // TODO add your handling code here:
        switch (cmbListar.getSelectedIndex()) {

            case 1:
                ordenarPorId(modelo);
                break;
            case 2:
                ordenarPorNome(modelo);
                break;
            case 3:
                ordenarPorFornecedor(modelo);
                break;
            case 4:
                ordenarPorQuantidade(modelo);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbListarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Menu mn = new Menu();
        mn.setLocationRelativeTo(null);
        mn.setVisible(true);
        mn.setResizable(false);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void ordenarPorId(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MaterialDao dao = new MaterialDao();
        List<Material> materiais = new ArrayList<>();
        materiais = dao.listPesq("select m from Material m order by id");

        for (Material m : materiais) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorNome(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MaterialDao dao = new MaterialDao();
        List<Material> materiais = new ArrayList<>();
        materiais = dao.listPesq("select m from Material m order by nome");

        for (Material m : materiais) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorFornecedor(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MaterialDao dao = new MaterialDao();
        List<Material> materiais = new ArrayList<>();
        materiais = dao.listPesq("select m from Material m order by fornecedor");

        for (Material m : materiais) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorQuantidade(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MaterialDao dao = new MaterialDao();
        List<Material> materiais = new ArrayList<>();
        materiais = dao.listPesq("select m from Material m order by quantidade");

        for (Material m : materiais) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

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
            java.util.logging.Logger.getLogger(ListaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeMateriais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbListar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrdenar;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
