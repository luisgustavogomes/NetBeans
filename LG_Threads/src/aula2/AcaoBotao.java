/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author lg
 */
public class AcaoBotao implements ActionListener {

    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

    public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        TarefaMultiplicacao tarefa = new TarefaMultiplicacao(primeiro, segundo, resultado);
        Thread threadCalculo = new Thread(tarefa, "Thread Calculadora");
        threadCalculo.start();

    }
}
