/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi.model;

/**
 *
 * @author Luis Gustavo
 */
public class Nota {

    private double n1;
    private double n2;
    private double subst;

    public Nota() {
        this.n1 = 0;
        this.n2 = 0;
        this.subst =0;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getSubst() {
        return subst;
    }

    public void setSubst(double subst) {
        this.subst = subst;
    }

    @Override
    public String toString() {
        return "{" + "n1=" + n1 + ", n2=" + n2 + ", subst=" + subst + '}';
    }

}
