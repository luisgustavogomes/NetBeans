/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.MatriculaBO;
import br.edu.qi.model.MatriculaVO;
import br.edu.qi.utl.HelperNumbers;
import br.edu.qi.view.CadastroMatriculaEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Luis Gustavo
 */
public class MatriculaController implements ActionListener, ItemListener, DocumentListener {

    private CadastroMatriculaEditView cadView;
    private MatriculaBO matricula;
   

    public MatriculaController(CadastroMatriculaEditView cadastroMatriculaEditView) {
        this.cadView = cadastroMatriculaEditView;
        this.cadView.getTxtDesconto().setText("0");
        this.matricula = new MatriculaBO();
        this.cadView.getBtnGravar().addActionListener(this);
        this.cadView.getTxtDesconto().getDocument().addDocumentListener(this);
        this.cadView.getCbDisciplina().addItemListener(this);
    }

    private void validation() throws Exception {
        if (!HelperNumbers.isNumeric(cadView.getTxtNroMatricula().getText())
                || Integer.parseInt(cadView.getTxtNroMatricula().getText()) <= 0) {
            throw new Exception("Nro Matrícula inválido!");
        }
        if (cadView.getCbDisciplina().getSelectedIndex() == 0) {
            throw new Exception("Matrícula inválida!");
        }
        if (!HelperNumbers.isNumeric(cadView.getTxtDesconto().getText())) {
            throw new Exception("Desconto inválido!");
        }
        if (Integer.parseInt(cadView.getTxtDesconto().getText()) < 0
                || Integer.parseInt(cadView.getTxtDesconto().getText()) >= 100) {
            throw new Exception("Faixa de percentual de desconto inválido!");
        }
    }

    public MatriculaVO buscaMatriculaVO() {
        return new MatriculaVO(
                Integer.parseInt(cadView.getTxtNroMatricula().getText()),
                cadView.getCbDisciplina().getSelectedItem().toString(),
                !cadView.getTxtDesconto().getText().isEmpty() ? Double.parseDouble(cadView.getTxtDesconto().getText()) : 0);
    }

    public void limparDados() {
        cadView.getTxtNroMatricula().setText("");
        cadView.getCbDisciplina().setSelectedIndex(0);
        //cadView.getTxtDesconto().setText("0");
        cadView.getTxtTotal().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == this.cadView.getBtnGravar()) {
                validation();
                MatriculaVO matriculaView = buscaMatriculaVO();
                matricula.calcularValor(matriculaView);
                matricula.save(matriculaView);
                cadView.getTxtTotal().setText(NumberFormat.getCurrencyInstance().format(matriculaView.getValor() + matricula.findValor(buscaMatriculaVO())));
                JOptionPane.showMessageDialog(null, "Matricula salva com sucesso!"
                        + "\nTotal: " + NumberFormat.getCurrencyInstance().format(matriculaView.getValor() + matricula.findValor(buscaMatriculaVO())));
                limparDados();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (cadView.getCbDisciplina().getSelectedIndex() != 0) {
            MatriculaVO matriculaView = buscaMatriculaVO();
            matricula.calcularValor(matriculaView);
            cadView.getTxtTotal().setText(NumberFormat.getCurrencyInstance().format(matriculaView.getValor() + matricula.findValor(buscaMatriculaVO())));
        } else {
            cadView.getTxtTotal().setText("0");
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        MatriculaVO matriculaView = buscaMatriculaVO();
        matricula.calcularValor(matriculaView);
        cadView.getTxtTotal().setText(matricula.findValor(buscaMatriculaVO())+"");
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        MatriculaVO matriculaView = buscaMatriculaVO();
        matricula.calcularValor(matriculaView);
        cadView.getTxtTotal().setText((matriculaView.getValor() + matricula.findValor(buscaMatriculaVO())) + "");
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        MatriculaVO matriculaView = buscaMatriculaVO();
        matricula.calcularValor(matriculaView);
        cadView.getTxtTotal().setText((matriculaView.getValor() + matricula.findValor(buscaMatriculaVO())) + "");
    }

}
