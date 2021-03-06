/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bibliotecavirtual.GerenciadorBibliotecaVirtual;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Gustavo
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        usuarioLogado();
        acessoMenu();
        
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                        lblRelogio.setText(new Date().toString());
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    private void acessoMenu() {
        if (!lblUsuarioLogado.getText().equals("admin")) {
            itemMenuUsuarioGerenciador.setVisible(false);
        }
    }

    private void usuarioLogado() {
        lblUsuarioLogado.setText(GerenciadorBibliotecaVirtual.USUARIOLOGADO.getLogin());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblInformativo = new javax.swing.JLabel();
        lblUsuarioLogado = new javax.swing.JLabel();
        lblRelogio = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuSistema = new javax.swing.JMenu();
        itemMenuSistemaLogout = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();
        MenuCadastro = new javax.swing.JMenu();
        itemMenuLivro = new javax.swing.JMenuItem();
        MenuUsuario = new javax.swing.JMenu();
        itemMenuUsuarioGerenciador = new javax.swing.JMenuItem();
        itemMenuUsuarioAlterarSenha = new javax.swing.JMenuItem();
        MenuOpcao = new javax.swing.JMenu();
        itemMenuAjuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca Virtual");
        setResizable(false);

        painelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/folder/telaPrincipal.png"))); // NOI18N

        javax.swing.GroupLayout painelPrincipalLayout = new javax.swing.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        lblInformativo.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblInformativo.setForeground(new java.awt.Color(0, 204, 51));
        lblInformativo.setText("Usuario Logado:");

        lblUsuarioLogado.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblUsuarioLogado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MenuSistema.setText("Sistema");

        itemMenuSistemaLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuSistemaLogout.setText("Login\\Logout");
        itemMenuSistemaLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSistemaLogoutActionPerformed(evt);
            }
        });
        MenuSistema.add(itemMenuSistemaLogout);

        itemMenuSair.setText("Sair");
        itemMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSairActionPerformed(evt);
            }
        });
        MenuSistema.add(itemMenuSair);

        jMenuBar1.add(MenuSistema);

        MenuCadastro.setText("Cadastro");

        itemMenuLivro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuLivro.setText("Livro");
        itemMenuLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuLivroActionPerformed(evt);
            }
        });
        MenuCadastro.add(itemMenuLivro);

        jMenuBar1.add(MenuCadastro);

        MenuUsuario.setText("Usuário");

        itemMenuUsuarioGerenciador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuUsuarioGerenciador.setText("Gerenciador");
        itemMenuUsuarioGerenciador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuUsuarioGerenciadorActionPerformed(evt);
            }
        });
        MenuUsuario.add(itemMenuUsuarioGerenciador);

        itemMenuUsuarioAlterarSenha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuUsuarioAlterarSenha.setText("Alterar senha");
        itemMenuUsuarioAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuUsuarioAlterarSenhaActionPerformed(evt);
            }
        });
        MenuUsuario.add(itemMenuUsuarioAlterarSenha);

        jMenuBar1.add(MenuUsuario);

        MenuOpcao.setText("Opcão");

        itemMenuAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuAjuda.setText("Ajuda");
        itemMenuAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAjudaActionPerformed(evt);
            }
        });
        MenuOpcao.add(itemMenuAjuda);

        jMenuBar1.add(MenuOpcao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInformativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblRelogio, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInformativo, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(lblUsuarioLogado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRelogio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSairActionPerformed
        int controle = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Saindo...", JOptionPane.OK_CANCEL_OPTION);
        switch (controle) {
            case 0:
                System.exit(controle);
        }
    }//GEN-LAST:event_itemMenuSairActionPerformed

    private void itemMenuSistemaLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSistemaLogoutActionPerformed
        int controle = JOptionPane.showConfirmDialog(this, "Deseja fazer Logout ?", "Logout...", JOptionPane.OK_CANCEL_OPTION);
        switch (controle) {
            case 0:
                FrmLogin frmlogin = new FrmLogin();
                frmlogin.setVisible(true);
                GerenciadorBibliotecaVirtual.USUARIOLOGADO.setLogin(null);
                dispose();
        }
    }//GEN-LAST:event_itemMenuSistemaLogoutActionPerformed

    private void itemMenuAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAjudaActionPerformed
        FrmAjuda frmAjuda = new FrmAjuda();
        frmAjuda.setVisible(true);
    }//GEN-LAST:event_itemMenuAjudaActionPerformed

    private void itemMenuLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuLivroActionPerformed
        FrmLivro frmLivro = new FrmLivro();
        frmLivro.setVisible(true);
    }//GEN-LAST:event_itemMenuLivroActionPerformed

    private void itemMenuUsuarioGerenciadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuUsuarioGerenciadorActionPerformed
        FrmGerenciadorUsuario frmGerenciadorUsuario = new FrmGerenciadorUsuario();
        frmGerenciadorUsuario.setVisible(true);
    }//GEN-LAST:event_itemMenuUsuarioGerenciadorActionPerformed

    private void itemMenuUsuarioAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuUsuarioAlterarSenhaActionPerformed
        FrmAlterarSenha frmAlterarSenha = new FrmAlterarSenha();
        frmAlterarSenha.setVisible(true);
    }//GEN-LAST:event_itemMenuUsuarioAlterarSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenu MenuOpcao;
    private javax.swing.JMenu MenuSistema;
    private javax.swing.JMenu MenuUsuario;
    private javax.swing.JMenuItem itemMenuAjuda;
    private javax.swing.JMenuItem itemMenuLivro;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JMenuItem itemMenuSistemaLogout;
    private javax.swing.JMenuItem itemMenuUsuarioAlterarSenha;
    private javax.swing.JMenuItem itemMenuUsuarioGerenciador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblInformativo;
    private javax.swing.JLabel lblRelogio;
    private javax.swing.JLabel lblUsuarioLogado;
    private javax.swing.JPanel painelPrincipal;
    // End of variables declaration//GEN-END:variables
}
