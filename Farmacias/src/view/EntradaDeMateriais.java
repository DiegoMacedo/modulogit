package view;

import dao.MaterialDao;
import entidade.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mb.MaterialMb;

/**
 *
 * @author macedo
 */
public class EntradaDeMateriais extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    Material material = new Material();
    MaterialMb mb = new MaterialMb();

    public EntradaDeMateriais() {
        initComponents();
        ordenarPorId(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        cmbListar = new javax.swing.JComboBox();
        lblOrdenar = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        txtValidade = new javax.swing.JTextField();
        btnAcrescentar = new javax.swing.JButton();
        txtQuantidadeOld = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        cmbListar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CÓDIGO", "NOME", "FORNECEDOR", "QUANTIDADE" }));
        cmbListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListarActionPerformed(evt);
            }
        });

        lblOrdenar.setText("ORDENAR POR: ");

        lblPesquisar.setText("PESQUISAR CÓDIGO: ");

        jLabel1.setText("Nome:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tabela, org.jdesktop.beansbinding.ELProperty.create("${name}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jLabel2.setText("Lote: ");

        jLabel3.setText("Validade: ");

        jLabel4.setText("Fornecedor: ");

        jLabel5.setText("Quantidade: ");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lupa-icon.jpg"))); // NOI18N
        btnPesquisar.setText("PESQUISAR");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAcrescentar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/list-add.png"))); // NOI18N
        btnAcrescentar.setText("ACRESCENTAR");
        btnAcrescentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcrescentarActionPerformed(evt);
            }
        });

        txtQuantidadeOld.setEditable(false);

        jLabel6.setText("Saldo:");

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
                        .addComponent(lblOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbListar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(lblPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(459, 459, 459)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(34, 34, 34)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtQuantidadeOld, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAcrescentar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVoltar))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblOrdenar)
                        .addComponent(cmbListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPesquisar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesquisar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantidadeOld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcrescentar)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListarActionPerformed
        // TODO add your handling code here:
        switch (cmbListar.getSelectedIndex()) {

            case 0:
                ordenarPorId(modelo);
                break;
            case 1:
                ordenarPorNome(modelo);
                break;
            case 2:
                ordenarPorFornecedor(modelo);
                break;
            case 3:
                ordenarPorQuantidade(modelo);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbListarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            if (txtCodigo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite um código");
            } else {
                pesquisarPorId();
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAcrescentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcrescentarActionPerformed
        try {
            if (txtQuantidade.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Coloque a quantidade a ser acrescida");
            } else {
                acrescentar();
                ordenarPorId(modelo);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }//GEN-LAST:event_btnAcrescentarActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        Integer linha = tabela.getSelectedRow();
        int codigo = (Integer) tabela.getValueAt(linha, 0);
        String nome = (String) tabela.getValueAt(linha, 1);
        String lote = (String) tabela.getValueAt(linha, 2);
        String validade = (String) tabela.getValueAt(linha, 3);
        String fornecedor = (String) tabela.getValueAt(linha, 4);
        int quantidade = (Integer) tabela.getValueAt(linha, 5);
        String rec = String.valueOf(codigo);
        String req = String.valueOf(quantidade);

        txtCodigo.setText(rec);
        txtNome.setText(nome);
        txtLote.setText(lote);
        txtValidade.setText(validade);
        txtFornecedor.setText(fornecedor);
        txtQuantidadeOld.setText(req);

        MaterialDao dao = new MaterialDao();
        codigo = Integer.parseInt(txtCodigo.getText());
        material.setId(codigo);
        List<Material> materiais;

        materiais = dao.listPesq("select m from Material m where id=" + material.getId());

        for (Material m : materiais) {

            txtNome.setText(m.getNome());
            txtLote.setText(m.getLote());
            txtValidade.setText(m.getValidade());
            txtFornecedor.setText(m.getFornecedor());
            txtQuantidadeOld.setText(String.valueOf(m.getQuantidade()));

        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        Menu mn = new Menu();
        mn.setLocationRelativeTo(null);
        mn.setVisible(true);
        mn.setResizable(false);
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void acrescentar() {
        Integer quantidadeOld;
        Integer quantidadeAtual;
        Integer soma;

        material.setFornecedor(txtFornecedor.getText().trim().toUpperCase());
        material.setLote(txtLote.getText().trim());
        material.setNome(txtNome.getText().trim().toUpperCase());
        material.setValidade(txtValidade.getText().trim());

        quantidadeOld = Integer.parseInt(txtQuantidadeOld.getText());
        quantidadeAtual = Integer.parseInt(txtQuantidade.getText());

        soma = quantidadeOld + quantidadeAtual;
        material.setQuantidade(soma);
        mb.alterar(material);
        txtQuantidade.setText("");
    }

    public void alterar() {
        try {
            if (converter() == true && material.getId() != null) {
                mb.alterar(material);
                String mensagem = "Material Alterado com sucesso!!!";
                JOptionPane.showMessageDialog(null, mensagem);
            } else {
                String mensagem = "Não foi possível alterar os dados do Material!!!";
                JOptionPane.showMessageDialog(null, mensagem);
            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    public void pesquisarPorId() {
        Integer codigo;

        MaterialDao dao = new MaterialDao();
        codigo = Integer.parseInt(txtCodigo.getText());
        material.setId(codigo);
        List<Material> materiais;

        materiais = dao.listPesq("select m from Material m where id=" + material.getId());

        for (Material m : materiais) {
            txtNome.setText(m.getNome());
            txtLote.setText(m.getLote());
            txtValidade.setText(m.getValidade());
            txtFornecedor.setText(m.getFornecedor());
            txtQuantidadeOld.setText(String.valueOf(m.getQuantidade()));

        }
    }

    public boolean converter() {
        Integer quantidadeAntiga;
        Integer quantidadeNova;
        material.setFornecedor(txtFornecedor.getText().trim().toUpperCase());
        material.setLote(txtLote.getText().trim());
        material.setNome(txtNome.getText().trim().toUpperCase());
        material.setValidade(txtValidade.getText().trim());

        quantidadeAntiga = Integer.parseInt(txtQuantidadeOld.getText());
        material.setQuantidade(quantidadeAntiga);

        quantidadeNova = Integer.parseInt(txtQuantidade.getText());
        material.setQuantidade(quantidadeNova);

        return true;
    }

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
            java.util.logging.Logger.getLogger(EntradaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaDeMateriais.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntradaDeMateriais().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcrescentar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrdenar;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtLote;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtQuantidadeOld;
    private javax.swing.JTextField txtValidade;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
