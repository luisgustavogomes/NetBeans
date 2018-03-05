/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.Movimentacao;
import br.edu.qi.model.MovimentacaoBO;
import br.edu.qi.util.HelperNumbers;
import br.edu.qi.view.MovEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author lg
 */
public class MovEditController implements ActionListener {

    private MovEditView view;
    private MovimentacaoBO bo;

    public MovEditController(MovEditView movEditView) {
        this.view = movEditView;
        bo = MovimentacaoBO.getInstancia();
        this.view.getTxtLimiti().setText("1000");
        this.view.getTxtSaldo().setText("2000");
        this.view.getBtnSalvar().addActionListener(this);
    }

    public Movimentacao caregarMovimentacao() {
        Movimentacao mo = (new Movimentacao(
                Integer.parseInt(this.view.getTxtConta().getText()),
                Integer.parseInt(this.view.getTxtAgencia().getText()),
                Double.parseDouble(this.view.getTxtValor().getText()),
                Double.parseDouble(this.view.getTxtSaldo().getText()),
                Double.parseDouble(this.view.getTxtLimiti().getText()),
                this.view.getCbOperacao().getSelectedItem().toString()));
        return mo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            validation();
            if (this.view.getCbOperacao().getSelectedItem().toString().equalsIgnoreCase("Depositar")) {
                this.view.getTxtSaldo().setText(String.valueOf(bo.depositar(caregarMovimentacao())));
                JOptionPane.showMessageDialog(null, "Deposito efetuado com sucesso!");
            }
            if (this.view.getCbOperacao().getSelectedItem().toString().equalsIgnoreCase("Sacar")) {
                this.view.getTxtSaldo().setText(String.valueOf(bo.sacar(caregarMovimentacao())));
                JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void validation() throws Exception {
        if (!HelperNumbers.isNumericDouble(view.getTxtConta().getText()) || !HelperNumbers.isPositiv(view.getTxtConta().getText())) {
            throw new Exception("Informe uma conta valida!");
        }
        if (!HelperNumbers.isNumericDouble(view.getTxtAgencia().getText()) || !HelperNumbers.isPositiv(view.getTxtAgencia().getText())) {
            throw new Exception("Informe uma conta valida!");
        }
        if (!HelperNumbers.isNumericDouble(view.getTxtValor().getText()) || !HelperNumbers.isPositiv(view.getTxtValor().getText())) {
            throw new Exception("Informe uma conta valida!");
        }
        if (view.getCbOperacao().getSelectedIndex() == 0) {
            throw new Exception ("Informe a operação");
        }
    }

}
