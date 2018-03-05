/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author lg
 */
public enum Cargo {
    ANALISTA {
        @Override
        public float calcularSalario(IFuncionario func) {
            return func.calcularSalario();
        }
    }, DESENVOLVEDOR {
        @Override
        public float calcularSalario(IFuncionario func) {
            return func.calcularSalario();
        }
    }, VENDEDOR {
        @Override
        public float calcularSalario(IFuncionario func) {
            return func.calcularSalario();
        }
    }, GERENTE {
        @Override
        public float calcularSalario(IFuncionario func) {
            return func.calcularSalario();
        }
    }, CONSULTOR {
        @Override
        public float calcularSalario(IFuncionario func) {
            return func.calcularSalario();
        }
    };

    public abstract float calcularSalario(IFuncionario func);
}
