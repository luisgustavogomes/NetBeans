/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.controller;

import br.edu.qi.model.ProfessorBO;
import br.edu.qi.model.ProfessorVO;
import br.edu.qi.util.HelperNumbers;
import br.edu.qi.view.CadEditView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author lg
 */
public class CadEditController implements ActionListener {

    private CadEditView view;
    private ProfessorBO bo;
    

    public CadEditController(CadEditView view) {
        this.view = view;
        bo = ProfessorBO.getIntancia();
        this.view.getBtnCalcular().addActionListener(this);
    }

    private ProfessorVO getProfessor() {
        float formacao = 0f;
        switch (view.getCbFormacao().getSelectedIndex()) {
            case 1:
                formacao = 100;
                break;
            case 2:
                formacao = 200;
                break;
            case 3:
                formacao = 300;
                break;
            case 4:
                formacao = 500;
                break;
        }
        ProfessorVO professorVO = new ProfessorVO(
                Integer.parseInt(view.getTxtNroProfessor().getText()),
                Float.parseFloat(view.getTxtSalario().getText()),
                formacao,
                view.getCkEmAndamento().isSelected());

        return professorVO;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            validation();
            if (e.getSource() == view.getBtnCalcular()) {
                ProfessorVO professorVO = getProfessor();
                bo.save(professorVO);
                JOptionPane.showMessageDialog(view, professorVO
                        + "\nFormação: " + view.getCbFormacao().getSelectedItem().toString()
                        + "\nBonus: " + bo.bonus(professorVO)
                        + "\n-------------------------------------"
                        + "\nTotal: " + bo.total(professorVO));
                JOptionPane.showMessageDialog(view, "Dados Salvo com sucesso!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void validation() throws Exception {
        if (!HelperNumbers.isPositiv(view.getTxtNroProfessor().getText())) {
            throw new Exception("Digite um Nro de Professor valido!");
        }
        if (!HelperNumbers.isPositiv(view.getTxtSalario().getText()) || Float.parseFloat(view.getTxtSalario().getText()) < 1000) {
            throw new Exception("Digite um Salário valido! \nOu um Salário maior que o valor de R$ 1000!");
        }
        if (view.getCbFormacao().getSelectedIndex() == 0) {
            throw new Exception("Selecione uma formação!");
        }
    }

}
