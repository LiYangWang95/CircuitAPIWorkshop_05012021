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
import static org.junit.Assert.*;

/**
 *
 * @author 20204909
 */
public class CircuitJUnitTest {
    
    public CircuitJUnitTest() {
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

    FormulaFactory factory;
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testType() {
        factory = new FormulaFactory();
        Formula cons = factory.getFormula(FormulaType.Constant);
        Formula orOp = factory.getFormula(FormulaType.Or);
        Formula andOp = factory.getFormula(FormulaType.And);
        Formula neg = factory.getFormula(FormulaType.Not);
        Formula cir = factory.getFormula(FormulaType.Circuit);

        assertTrue(cons.getClass() == Constant.class);
        assertTrue(orOp.getClass() == Or.class);
        assertTrue(andOp.getClass() == And.class);
        assertTrue(neg.getClass() == Negation.class);
        assertTrue(cir.getClass() == Circuit.class);
    }

    @Test
    public void testConstant(){
        factory = new FormulaFactory();
        Formula cons = factory.getFormula(FormulaType.Constant);

        ((Constant)cons).setValue(true);

        assertTrue(cons.getValue());

    }

    @Test
    public void testAnd1(){
        factory = new FormulaFactory();
        Formula cons1 = factory.getFormula(FormulaType.Constant);
        Formula cons2 = factory.getFormula(FormulaType.Constant);
        Formula and1 = factory.getFormula(FormulaType.And);

        ((Constant)cons1).setValue(true);
        ((Constant)cons2).setValue(true);
        ((And)and1).setValue(cons1, cons2);

        assertTrue(and1.getValue());

    }

    @Test
    public void testAnd2(){
        factory = new FormulaFactory();
        Formula cons1 = factory.getFormula(FormulaType.Constant);
        Formula cons2 = factory.getFormula(FormulaType.Constant);
        Formula and1 = factory.getFormula(FormulaType.And);

        ((Constant)cons1).setValue(true);
        ((Constant)cons2).setValue(false);
        ((And)and1).setValue(cons1, cons2);

        assertFalse(and1.getValue());
    }

    @Test
    public void testAnd3(){
        factory = new FormulaFactory();
        Formula cons1 = factory.getFormula(FormulaType.Constant);
        Formula cons2 = factory.getFormula(FormulaType.Constant);
        Formula and1 = factory.getFormula(FormulaType.And);

        ((Constant)cons1).setValue(false);
        ((Constant)cons2).setValue(false);
        ((And)and1).setValue(cons1, cons2);

        assertFalse(and1.getValue());
    }

    @Test
    public void testOr1(){
        factory = new FormulaFactory();
        Formula cons1 = factory.getFormula(FormulaType.Constant);
        Formula cons2 = factory.getFormula(FormulaType.Constant);
        Formula and1 = factory.getFormula(FormulaType.Or);

        ((Constant)cons1).setValue(true);
        ((Constant)cons2).setValue(true);
        ((Or)and1).setValue(cons1, cons2);

        assertTrue(and1.getValue());
    }
}
