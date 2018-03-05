/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula4;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lg
 */
public class BanheiroTest {
    
    public BanheiroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of FazNumero1 method, of class Banheiro.
     */
    @Test
    public void testFazNumero1() {
        System.out.println("FazNumero1");
        Banheiro instance = new Banheiro();
        instance.FazNumero1();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FazNumero2 method, of class Banheiro.
     */
    @Test
    public void testFazNumero2() {
        System.out.println("FazNumero2");
        Banheiro instance = new Banheiro();
        instance.FazNumero2();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
