package view;

import dao.MedicamentoDao;
import entidade.Medicamento;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mb.MedicamentoMb;

/**
 *
 * @author macedo
 */
public final class ListaDeMedicamentos extends javax.swing.JFrame {

    private final DefaultTableModel modelo = new DefaultTableModel();
    Medicamento medicamento = new Medicamento();
    MedicamentoMb mb = new MedicamentoMb();

    public ListaDeMedicamentos() {
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
                "Código", "Nome", "Lote", "Validade", "Unidade", "Fornecedor", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        cmbListar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--SELECIONE--", "CÓDIGO", "NOME", "LOTE", "FORNECEDOR", "QUANTIDADE" }));
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
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
                ordenarPorLote(modelo);
                break;
            case 4:
                ordenarPorFornecedor(modelo);
                break;
            case 5:
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
        MedicamentoDao dao = new MedicamentoDao();
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = dao.listPesq("select m from Medicamento m order by id");

        for (Medicamento m : medicamentos) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getUnidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorNome(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MedicamentoDao dao = new MedicamentoDao();
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = dao.listPesq("select m from Medicamento m order by nome");

        for (Medicamento m : medicamentos) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getUnidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorLote(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MedicamentoDao dao = new MedicamentoDao();
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = dao.listPesq("select m from Medicamento m order by lote");

        for (Medicamento m : medicamentos) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getUnidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorValidade(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MedicamentoDao dao = new MedicamentoDao();
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = dao.listPesq("select m from Medicamento m order by validade");

        for (Medicamento m : medicamentos) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getUnidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorFornecedor(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MedicamentoDao dao = new MedicamentoDao();
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = dao.listPesq("select m from Medicamento m order by fornecedor");

        for (Medicamento m : medicamentos) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getUnidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public void ordenarPorQuantidade(DefaultTableModel modelo) {
        modelo = (DefaultTableModel) tabela.getModel();
        modelo.setNumRows(0);
        MedicamentoDao dao = new MedicamentoDao();
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos = dao.listPesq("select m from Medicamento m order by quantidade");

        for (Medicamento m : medicamentos) {
            modelo.addRow(new Object[]{m.getId(), m.getNome(), m.getLote(), m.getValidade(), m.getUnidade(), m.getFornecedor(), m.getQuantidade()});
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeMedicamentos().setVisible(true);
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
