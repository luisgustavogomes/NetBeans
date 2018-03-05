package crud;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmProduto extends javax.swing.JFrame {
    
    public Produto produto = null;
    
    public FrmProduto() {
        initComponents();
        carregarTabela();
    }
    
    public void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-m-dd");
        
        String lista[] = new String[4];
        List<Produto> produtos = null;
        try { 
            produtos = ControladorProduto.retornarProdutos();
            Collections.sort(produtos);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        if (produtos != null) {
            
            for (Produto p : produtos) {
                lista[0] = String.valueOf(p.getId());
                lista[1] = p.getNome();
                lista[2] = (p.getPreco() + "").replace(",", ".");
                lista[3] = format.format(p.getData());
                modelo.addRow(lista);
            }
        }
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        lblPesquisa = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnPesquisa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "PRECO", "DATE"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        lblPesquisa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPesquisa.setText("Pesquisa:");

        txtPesquisa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnPesquisa.setText("Pesquisa");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPesquisa)
                                .addGap(18, 18, 18)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPesquisa)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        carregarTabela();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        FrmEditarProduto frmEditarProduto = new FrmEditarProduto();
        frmEditarProduto.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed

    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        SimpleDateFormat format = new SimpleDateFormat("yyyy-m-dd");
        try {
            produto = new Produto(Integer.parseInt(retornaStringLinhaColuna(rowIndex(), 0)),
                    retornaStringLinhaColuna(rowIndex(), 1),
                    Double.parseDouble(retornaStringLinhaColuna(rowIndex(), 2)),
                    format.parse(retornaStringLinhaColuna(rowIndex(), 3)));
        } catch (ParseException ex) {
            Logger.getLogger(FrmProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        FrmEditarProduto frmEditarProduto = new FrmEditarProduto(produto);
        frmEditarProduto.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int id = 0;
        id = Integer.parseInt(retornaStringLinhaColuna(rowIndex(), 0));
        if (id != 0) {
            boolean status = !ControladorProduto.excluirProduto(id);
            if (status) {
                    JOptionPane.showMessageDialog(this, "Produto excluido com sucesso!!!");
                    carregarTabela();
                } else {
                    JOptionPane.showMessageDialog(this, "Erro...");
                }
        } else {
            JOptionPane.showMessageDialog(this, "Erro...registro não selecionado!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        carregarTabela();
    }//GEN-LAST:event_formWindowActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPesquisa;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
