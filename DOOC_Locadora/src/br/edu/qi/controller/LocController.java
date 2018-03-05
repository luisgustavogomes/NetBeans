/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.LocadoraBO;
import br.edu.qi.utl.HelperNumbers;
import br.edu.qi.view.LocEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Gustavo
 */
public class LocController implements ActionListener {

    private LocEditView locEditView;
    private LocadoraBO locadora;

    public LocController(LocEditView locEditView) {
        this.locEditView = locEditView;
        this.locadora = new LocadoraBO();
        this.locEditView.getBtnCalcular().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            validation();
            this.locEditView.getTxtTotal().setText((String.valueOf(resultado())));
            JOptionPane.showMessageDialog(locEditView, "Calculo executado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(locEditView, ex.getMessage());
        }
    }
    
//    private void salvar() throws Exception{
//            if (locEditView.getTxtQtdeDiasAtraso().getText().isEmpty() && locEditView.getTxtMulta().getText().isEmpty()) {
//                this.locadora.save(new LocadoraVO(
//                        Integer.parseInt(locEditView.getTxtNroLocacao().getText()),
//                        locEditView.getCbVeiculo().getSelectedItem().toString(),
//                        Double.parseDouble(locEditView.getTxtValor().getText()),
//                        Integer.parseInt(locEditView.getTxtQtdeDias().getText())));
//            } else {
//                this.locadora.save(new LocadoraVO(
//                        Integer.parseInt(locEditView.getTxtNroLocacao().getText()),
//                        locEditView.getCbVeiculo().getSelectedItem().toString(),
//                        Double.parseDouble(locEditView.getTxtValor().getText()),
//                        Integer.parseInt(locEditView.getTxtQtdeDias().getText()),
//                        Double.parseDouble(locEditView.getTxtMulta().getText()),
//                        Integer.parseInt(locEditView.getTxtQtdeDiasAtraso().getText())));
//            }
//    }
   
    
    public double resultado() throws Exception {
        int qtdeDias = Integer.parseInt(locEditView.getTxtQtdeDias().getText());
        double valor = Double.parseDouble(locEditView.getTxtValor().getText());
        double total = qtdeDias * valor;
        double multa = 0;

        if (HelperNumbers.isNumeric(locEditView.getTxtQtdeDiasAtraso().getText()) && HelperNumbers.isNumeric(locEditView.getTxtMulta().getText())) {
            multa = Integer.parseInt(locEditView.getTxtQtdeDiasAtraso().getText()) * Double.parseDouble(locEditView.getTxtMulta().getText());
        }

        if (locEditView.getCkAvista().isSelected()) {
            return ((total + multa) - ((total + multa) * 0.1));
        } else {
            return (total + multa);
        }
    }

    private void validation() throws Exception {
        if (!HelperNumbers.isNumeric(locEditView.getTxtNroLocacao().getText()) || Integer.parseInt(locEditView.getTxtNroLocacao().getText()) <= 0) {
            throw new Exception("Informe um número de locação válido!");
        }
        if (locEditView.getCbVeiculo().getSelectedIndex() == 0) {
            throw new Exception("Selecione um veiculo!");
        }
        if (!HelperNumbers.isNumeric(locEditView.getTxtValor().getText()) || Double.parseDouble(locEditView.getTxtValor().getText()) <= 0) {
            throw new Exception("Informe um valor válido!");
        }
        if (!HelperNumbers.isNumeric(locEditView.getTxtQtdeDias().getText()) || Integer.parseInt(locEditView.getTxtQtdeDias().getText()) <= 0) {
            throw new Exception("Informe a quantidade de dias para locação!");
        }
        if (!locEditView.getTxtMulta().getText().isEmpty()) {
            if (!HelperNumbers.isNumeric(locEditView.getTxtMulta().getText()) || Double.parseDouble(locEditView.getTxtMulta().getText()) <= 0) {
                throw new Exception("Informe um valor válido para a multa!");
            }
        }
        if (!locEditView.getTxtQtdeDiasAtraso().getText().isEmpty()) {
            if (!HelperNumbers.isNumeric(locEditView.getTxtQtdeDiasAtraso().getText()) || Integer.parseInt(locEditView.getTxtQtdeDiasAtraso().getText()) <= 0) {
                throw new Exception("Informe um valor válido para a dias de atraso!");
            }
            if (Integer.parseInt(locEditView.getTxtQtdeDiasAtraso().getText()) >= 20) {
                throw new Exception("Não é permitido mais 20 dias atraso!");
            }
        }
        if (!locEditView.getTxtMulta().getText().isEmpty() && locEditView.getTxtQtdeDiasAtraso().getText().isEmpty()) {
            throw new Exception("Verificar o campo Dias de Atraso!");
        }
        if (locEditView.getTxtMulta().getText().isEmpty() && !locEditView.getTxtQtdeDiasAtraso().getText().isEmpty()) {
            throw new Exception("Verifica o campo Multa!");
        }

    }

}
