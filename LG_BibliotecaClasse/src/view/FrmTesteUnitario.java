package view;

import bibliotecaclasse.Helper;
import javax.swing.JOptionPane;

public class FrmTesteUnitario extends javax.swing.JFrame {

    public FrmTesteUnitario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCampo = new javax.swing.JTextField();
        lblCampo = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        txtResultado = new javax.swing.JTextField();
        btnTeste = new javax.swing.JButton();
        cmbFormula = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCampo.setText("CAMPO:");

        lblResultado.setText("RESULTADO:");

        txtResultado.setEnabled(false);

        btnTeste.setText("Testar");
        btnTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesteActionPerformed(evt);
            }
        });

        cmbFormula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "numero", "nome completo de pessoa", "data de nascimento para um 18 anos", "numero primo", "multiplo de 3", "CPF", "CEP", "dominio de Internet", "URL de Internet", "email", "palindromo" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCampo)
                                    .addComponent(lblResultado))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(cmbFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCampo))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblResultado))
                .addGap(18, 18, 18)
                .addComponent(btnTeste)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTesteActionPerformed
        String funcao = cmbFormula.getSelectedItem().toString();
        if (funcao == "numero") {
            getResultado(Helper.isNumero(txtCampo.getText()));
        } else if (funcao == "nome completo de pessoa") {
            getResultado(Helper.isNomeCompleto(txtCampo.getText()));
        } else if (funcao == "data de nascimento para um 18 anos") {
            getResultado(Helper.isDate(txtCampo.getText()));
        } else if (funcao == "email") {
            getResultado(Helper.isEmail(txtCampo.getText()));
        } else if (funcao == "CEP") {
            getResultado(Helper.isCep(txtCampo.getText()));
        } else if (funcao =="numero primo"){
            getResultado(Helper.isPrimo(txtCampo.getText()));
        } else if (funcao == "palindromo"){
            getResultado(Helper.isPalindromo(txtCampo.getText()));
        } else if (funcao == "URL de Internet"){
            getResultado(Helper.isUrl(txtCampo.getText()));
        } else if (funcao == "multiplo de 3"){
            getResultado(Helper.isMultiploDeTres(txtCampo.getText()));
        } else if ( funcao == "CPF"){
            getResultado(Helper.isCPF(txtCampo.getText()));
        } else if ( funcao == "dominio de Internet"){
            getResultado(Helper.isDominio(txtCampo.getText()));
        }
        


    }//GEN-LAST:event_btnTesteActionPerformed

    private void getResultado(Boolean status) {
        if (status) {
            txtResultado.setText("True");
        } else {
            txtResultado.setText("False");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTeste;
    private javax.swing.JComboBox<String> cmbFormula;
    private javax.swing.JLabel lblCampo;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JTextField txtCampo;
    private javax.swing.JTextField txtResultado;
    // End of variables declaration//GEN-END:variables
}
