/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import circuitry.*;
import circuitry.Operations.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.Normalizer;

import static org.junit.Assert.*;

/**
 *
 * @author 20204909
 */
public class CircuitJUnitTest {
    private Constant cons1, cons2, cons3, cons4;
    private And and1, and2;
    private Or or1;
    private Negation not1;
    private FormulaFactory factory;
    
    public CircuitJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // Initialize the elements of Formula before tests
    @Before
    public void setUp() {
        factory = new FormulaFactory();
        cons1 = factory.getConstant(true);
        cons2 = factory.getConstant(true);
        cons3 = factory.getConstant(true);
        cons4 = factory.getConstant(true);
        not1 = factory.getNot(cons3);
        and1 = factory.getAnd(cons1, cons2);
        or1 = factory.getOr(and1, not1);
        and2 = factory.getAnd(and1, or1);
    }
    
    @After
    public void tearDown() {
    }

    // Test type of Formula
    @Test
    public void testType() {

        assertTrue(cons1.getClass() == Constant.class);
        assertTrue(or1.getClass() == Or.class);
        assertTrue(and1.getClass() == And.class);
        assertTrue(not1.getClass() == Negation.class);
    }

    // Test constant
    @Test
    public void testConstant(){
        cons1.setValue(true);

        assertTrue(cons1.getValue());

    }

    // Test And with two true
    @Test
    public void testAnd1(){
        and1 = factory.getAnd(cons1, cons2);

        cons1.setValue(true);
        cons2.setValue(true);

        assertTrue(and1.getValue());

    }

    // Test And with 1 true 1 false
    @Test
    public void testAnd2(){
        and1 = factory.getAnd(cons1, cons2);

        cons1.setValue(true);
        cons2.setValue(false);

        assertFalse(and1.getValue());
    }

    // Test And with 2 false
    @Test
    public void testAnd3(){
        and1 = factory.getAnd(cons1, cons2);

        cons1.setValue(false);
        cons2.setValue(false);

        assertFalse(and1.getValue());
    }

    // Test Or with 2 true
    @Test
    public void testOr1(){
        or1 = factory.getOr(cons1, cons2);

        cons1.setValue(true);
        cons2.setValue(true);

        assertTrue(or1.getValue());
    }

    // Test Or with 1 true 1 false
    @Test
    public void testOr2(){
        or1 = factory.getOr(cons1, cons2);

        cons1.setValue(true);
        cons2.setValue(false);

        assertTrue(or1.getValue());
    }

    // Test Or with 2 false
    @Test
    public void testOr3(){
        or1 = factory.getOr(cons1, cons2);

        cons1.setValue(false);
        cons2.setValue(false);

        assertFalse(or1.getValue());
    }

    // Test not with true
    @Test
    public void testNot1(){
        not1 = factory.getNot(cons1);

        cons1.setValue(true);

        assertFalse(not1.getValue());
    }

    // Test not with false
    @Test
    public void testNot2(){
        not1 = factory.getNot(cons1);

        cons1.setValue(false);

        assertTrue(not1.getValue());
    }

    // Test (x1 and x2) and (not x3)
    @Test
    public void testFormula1(){
        // (x1 and x2) and (not x3)
        not1 = factory.getNot(cons3);
        and1 = factory.getAnd(cons1, cons2);
        and2 = factory.getAnd(and1, not1);

        cons1.setValue(true);
        cons2.setValue(true);
        cons3.setValue(true);

        assertFalse(and2.getValue());
    }

    // Test (x1 and x2) and ((not x3) or x4)
    @Test
    public void testFormula2(){
        // (x1 and x2) and ((not x3) or x4)
        not1 = factory.getNot(cons3);
        and1 = factory.getAnd(cons1, cons2);
        or1 = factory.getOr(and1, not1);
        and2 = factory.getAnd(and1, or1);


        cons1.setValue(true);
        cons2.setValue(true);
        cons3.setValue(true);
        cons4.setValue(true);

        assertTrue(and2.getValue());
    }
}
