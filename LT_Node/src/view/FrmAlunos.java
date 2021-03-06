/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import node.Aluno;
import node.Lista;

/**
 *
 * @author Luis Gustavo
 */
public class FrmAlunos extends javax.swing.JFrame {

    /**
     * Creates new form FrmAlunos
     */
    public FrmAlunos() {
        initComponents();
        carregarTabela();
    }

    public static int codigoAnterior;
    public static String nomeAnterior;
    public static String cursoAnterior;
    public static boolean controleEdicao;

    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        String alunos[] = new String[3];
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        Lista.alunos.forEach((Aluno a) -> {
            alunos[0] = String.valueOf(a.getCodigo());
            alunos[1] = a.getNome();
            alunos[2] = a.getCurso();
            modelo.addRow(alunos);
        });
    }

    /**
     * Retorna a String contida na matriz de Jtable, passando linha e coluna
     * como parametro.
     *
     * @param linha
     * @param coluna
     * @return
     */
    private String retornaStringLinhaColuna(int linha, int coluna) {
        try {
            return tabela.getValueAt(linha, coluna).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não encontrado!");
            return null;
        }
    }

    private int rowIndex() {
        return tabela.getSelectedRow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualização = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Curso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setMinWidth(60);
            tabela.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 429;
        gridBagConstraints.ipady = 137;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(17, 10, 0, 13);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 43;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 10, 11, 0);
        getContentPane().add(btnNovo, gridBagConstraints);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 39;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 16, 11, 0);
        getContentPane().add(btnEditar, gridBagConstraints);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 37;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 18, 11, 0);
        getContentPane().add(btnExcluir, gridBagConstraints);

        btnAtualização.setText("Atualização");
        btnAtualização.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaçãoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 18, 11, 13);
        getContentPane().add(btnAtualização, gridBagConstraints);

        lblTitulo.setFont(new java.awt.Font("Old English Text MT", 3, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Lista de Aluno");
        lblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 115;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 13);
        getContentPane().add(lblTitulo, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        controleEdicao = false;
        nomeAnterior = "";
        cursoAnterior = "";
        FrmEdicao frmEdicao = new FrmEdicao();
        frmEdicao.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAtualizaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaçãoActionPerformed
        carregarTabela();
    }//GEN-LAST:event_btnAtualizaçãoActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        codigoAnterior = Integer.parseInt(retornaStringLinhaColuna(rowIndex(), 0));
        nomeAnterior = retornaStringLinhaColuna(rowIndex(), 1);
        cursoAnterior = retornaStringLinhaColuna(rowIndex(), 2);
        controleEdicao = true;
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (controleEdicao) {
            FrmEdicao frmEdicao = new FrmEdicao();
            frmEdicao.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um registro");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (controleEdicao) {
            int controle = JOptionPane.showConfirmDialog(this, "Confirma a operação?", "Exclusão de Alunos", JOptionPane.OK_CANCEL_OPTION);
            switch (controle){
                case 0:
                    boolean status = Lista.isExclusaoAluno(codigoAnterior);
                    if (status) {
                        carregarTabela();
                        JOptionPane.showMessageDialog(this, "Aluno exluído com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(this, "Não foi possível excluir aluno");
                    }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um registro");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualização;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    public javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
