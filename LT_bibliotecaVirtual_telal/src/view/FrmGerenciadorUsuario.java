/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bibliotecavirtual.GerenciadorBibliotecaVirtual;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import usuario.GerenciadorUsuario;

/**
 *
 * @author Luis Gustavo
 */
public class FrmGerenciadorUsuario extends javax.swing.JFrame {

    /**
     * Creates new form frmGerenciadorUsuario
     */
    public FrmGerenciadorUsuario() {
        initComponents();
        carregarTabela();

    }
    
    /**
     * Construtor
     */
    private void carregarTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaUsuarios.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String lista[] = new String[3];
        GerenciadorBibliotecaVirtual.usuarios.forEach((GerenciadorUsuario u) -> {
            lista[0] = u.getNome();
            lista[1] = u.getLogin();
            lista[2] = u.getSenha();
            modelo.addRow(lista);
        });
    }

    private void limparCampos() {
        txtNome.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
    }

    private int rowIndex() {
        return tabelaUsuarios.getSelectedRow();
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
            return tabelaUsuarios.getValueAt(linha, coluna).toString();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Não encontrado!");
            return null;
        }
    }

    /**
     * Novo Usuário Para ativar o JOptionPane passe o valor 1 para sim e 2 não
     *
     * @param controlador 1 = Sim 0 = não
     */
    private void novoUsuario(int controlador) {
        if (txtNome.getText().isEmpty() || txtLogin.getText().isEmpty() || txtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Erro!\nPor favor, preencha todos os campos!");
        } else {
            boolean status = GerenciadorBibliotecaVirtual.isCadastrarArquivoUsuario(txtNome.getText(), txtLogin.getText(), txtSenha.getText());
            if (status) {
                carregarTabela();
                limparCampos();
                switch (controlador) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "Usuário Cadastrado com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuário já cadastrado!"
                        + "\nOu senha não tem 3 caracteres!");
            }
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        btnNovoUsuario = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluirUsuario = new javax.swing.JButton();
        btnAtualizarUsuario = new javax.swing.JButton();
        btnVoltarUsuario = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciado Usuários");
        setResizable(false);

        tabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Login", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaUsuarios);

        btnNovoUsuario.setText("Novo");
        btnNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuarioActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluirUsuario.setText("Excluir");
        btnExcluirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirUsuarioActionPerformed(evt);
            }
        });

        btnAtualizarUsuario.setText("Atualizar");
        btnAtualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarUsuarioActionPerformed(evt);
            }
        });

        btnVoltarUsuario.setText("Voltar");
        btnVoltarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarUsuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Senha");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtNome))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnExcluirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnAtualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(14, 14, 14)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtLogin)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnVoltarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizarUsuario)
                    .addComponent(btnExcluirUsuario)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovoUsuario))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarUsuarioActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarUsuarioActionPerformed

    private void btnAtualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarUsuarioActionPerformed
        carregarTabela();
        limparCampos();
    }//GEN-LAST:event_btnAtualizarUsuarioActionPerformed

    private void btnNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuarioActionPerformed
        novoUsuario(1);
    }//GEN-LAST:event_btnNovoUsuarioActionPerformed

    private void btnExcluirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirUsuarioActionPerformed
        if (tabelaUsuarios.getSelectedRow() >= 0) {
            GerenciadorUsuario gerenciadorUsuario = new GerenciadorUsuario(retornaStringLinhaColuna(rowIndex(), 0), retornaStringLinhaColuna(rowIndex(), 1), retornaStringLinhaColuna(rowIndex(), 2));
            ((DefaultTableModel) tabelaUsuarios.getModel()).removeRow(tabelaUsuarios.getSelectedRow());
            boolean status = GerenciadorBibliotecaVirtual.isExclusaoUsuario(gerenciadorUsuario);
            if (status) {
                carregarTabela();
                limparCampos();
                JOptionPane.showMessageDialog(this, "Usuário excluido com sucesso!");
            }
        } else {
            carregarTabela();
            limparCampos();
            JOptionPane.showMessageDialog(this, "Erro!");
        }
    }//GEN-LAST:event_btnExcluirUsuarioActionPerformed

    private void tabelaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaUsuariosMouseClicked
        txtNome.setText(retornaStringLinhaColuna(rowIndex(), 0));
        txtLogin.setText(retornaStringLinhaColuna(rowIndex(), 1));
        txtSenha.setText(retornaStringLinhaColuna(rowIndex(), 2));
    }//GEN-LAST:event_tabelaUsuariosMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        GerenciadorUsuario usuarioAnterior = new GerenciadorUsuario(retornaStringLinhaColuna(rowIndex(), 0), retornaStringLinhaColuna(rowIndex(), 1), retornaStringLinhaColuna(rowIndex(), 2));
        GerenciadorUsuario usuarioAtual = new GerenciadorUsuario(txtNome.getText(), txtLogin.getText(), txtSenha.getText());
        if (!usuarioAtual.equals(usuarioAnterior)) {
            novoUsuario(0);
            GerenciadorBibliotecaVirtual.isExclusaoUsuario(usuarioAnterior);
            limparCampos();
            carregarTabela();
            JOptionPane.showMessageDialog(this, "Usuário alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro!");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarUsuario;
    private javax.swing.JButton btnExcluirUsuario;
    private javax.swing.JButton btnNovoUsuario;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables

}