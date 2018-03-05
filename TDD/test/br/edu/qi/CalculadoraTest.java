/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.qi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lg
 */
public class CalculadoraTest {

    public CalculadoraTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of somar method, of class Calculadora.
     */
    @Test
    public void testSomar() {
//        System.out.println("somar");
//        double num1 = 10;
//        double num2 = 30;
//        Calculadora instance = new Calculadora();
//        double expResult = 30;
//        double result = instance.somar(num1, num2);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
        Calculadora calc = new Calculadora();
        assertEquals(40, calc.somar(10, 30), 0);
    }

    /**
     * Test of subtritrar method, of class Calculadora.
     */
    @Test
    public void testSubtritrar() {
        System.out.println("subtritrar");
        double num1 = 10;
        double num2 = 2;
        Calculadora instance = new Calculadora();
        double expResult = 8;
        double result = instance.subtritrar(num1, num2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplicar method, of class Calculadora.
     */
    @Test
    public void testMultiplicar() {
        System.out.println("multiplicar");
        double num1 = 2;
        double num2 = 2;
        Calculadora instance = new Calculadora();
        double expResult = 4;
        double result = instance.multiplicar(num1, num2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of dividir method, of class Calculadora.
     */
    @Test
    public void testDividir() {
        System.out.println("dividir");
        double num1 = 100;
        double num2 = 50;
        Calculadora instance = new Calculadora();
        double expResult = 2;
        double result = instance.dividir(num1, num2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
