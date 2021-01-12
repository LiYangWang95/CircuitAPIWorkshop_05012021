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
    private Or or1, or2;
    private Negation not1;
    private Gte gte1;
    private FormulaFactory factory;
    private String expectedMessage, actualMessage;
    
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
        gte1 = factory.getGte(cons1, cons2);
        not1 = factory.getNot(cons3);
        and1 = factory.getAnd(cons1, cons2);
        or1 = factory.getOr(and1, not1);
        or2 = factory.getOr(and1, not1);
        and2 = factory.getAnd(and1, or1);

        expectedMessage = "out of bounds";
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

    // (x1 and x2) or (not(x1))
    @Test
    public void testFormula3(){
        and1 = factory.getAnd(cons1, cons2);
        not1 = factory.getNot(cons1);
        or1 = factory.getOr(and1, not1);

        cons1.setValue(true);
        cons2.setValue(false);

        assertFalse(or1.getValue());
    }

    @Test
    public void testFormula4(){
        and1 = factory.getAnd(cons1, cons2);
        not1 = factory.getNot(cons1);
        or1 = factory.getOr(and1, not1);

        cons1.setValue(false);
        cons2.setValue(true);

        assertTrue(or1.getValue());
    }

    @Test
    public void testFormula5() throws Exception {
        and1 = factory.getAnd(cons1, cons2);
        not1 = factory.getNot(cons1);
        or1 = factory.getOr(and1, not1);

        cons1.setDValue(0.0);
        cons2.setDValue(1.0);

        assertTrue(or1.getDValue() == 1.0);
    }

    @Test
    public void testFormula6() throws Exception {
        and1 = factory.getAnd(cons1, cons2);
        not1 = factory.getNot(cons1);
        or1 = factory.getOr(and1, not1);

        cons1.setDValue(0.5);
        cons2.setDValue(0.5);

        assertTrue(or1.getDValue() == 0.625);
    }

    @Test
    public void testFormula7() throws Exception {
        and1 = factory.getAnd(cons1, cons2);
        not1 = factory.getNot(cons1);
        or1 = factory.getOr(and1, not1);

        try {
            cons1.setDValue(0.0);
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        try {
            cons2.setDValue(2.0);
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        expectedMessage = "out of bounds";
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testFormula8() throws Exception {
        and1 = factory.getAnd(cons1, cons2);
        not1 = factory.getNot(cons1);
        or1 = factory.getOr(and1, not1);

        try {
            cons1.setDValue(0.0);
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        try {
            cons2.setDValue(-1.0);
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        expectedMessage = "out of bounds";
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Gte
    @Test
    public void testGte1() throws Exception {
        // x1 gte x2
        gte1.setValue(cons1, cons2);

        cons1.setDValue(1.0);
        cons2.setDValue(1.0);

        assertTrue(gte1.getDValue() == 1.0);
    }

    @Test
    public void testGte2() throws Exception {
        // x1 gte x2
        gte1.setValue(cons1, cons2);

        cons1.setDValue(0.0);
        cons2.setDValue(1.0);

        assertTrue(gte1.getDValue() == 0.0);
    }

    @Test
    public void testGte3() throws Exception {
        // x1 gte x2
        gte1.setValue(cons1, cons2);

        cons1.setDValue(1.0);
        cons2.setDValue(0.0);

        assertTrue(gte1.getDValue() == 1.0);
    }

    @Test
    public void testFormula9() throws Exception {
        // ((x1 and x2) or (not x1)) gte (x3 or x2)
        and1.setValue(cons1, cons2);
        not1.setValue(cons1);
        or1.setValue(cons3, cons2);
        or2.setValue(and1, not1);
        gte1.setValue(or2, or1);

        cons1.setDValue(1.0);
        cons2.setDValue(0.0);
        cons3.setDValue(1.0);

        assertTrue(gte1.getDValue() == 0.0);
    }

    @Test
    public void testFormula10() throws Exception {
        // x1 and x2 -> x1 = true , x2 = 1.0
        Constant consx = factory.getConstant(true);
        Constant consy = factory.getConstant(0.0);
        And andz = factory.getAnd(consx, consy);

        consx.setValue(true);
        consy.setDValue(0.5);

        andz.getDValue();
        andz.getValue();

        assertFalse(andz.getValue());
        assertTrue(andz.getDValue() == 0.5);
    }

    // Test constant
    @Test
    public void testConstant2() throws Exception {
        Constant consy = factory.getConstant(0.0);
        consy.setDValue(0.5);

        assertTrue(consy.getDValue() == 0.5);

    }

    @Test
    public void testFormula11() throws Exception {
        // x1 or x2 -> x1 = true , x2 = 0.5
        Constant consx = factory.getConstant(true);
        Constant consy = factory.getConstant(0.0);
        Or orz = factory.getOr(consx, consy);

        consx.setValue(true);
        consy.setDValue(0.5);

        orz.getDValue();
        orz.getValue();

        assertTrue(orz.getValue());
        assertTrue(orz.getDValue() == 1.0);
    }
}
