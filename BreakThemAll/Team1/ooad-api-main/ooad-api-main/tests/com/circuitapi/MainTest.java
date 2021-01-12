package com.circuitapi;

import junit.framework.TestCase;

import java.util.ArrayList;

public class MainTest extends TestCase {

    public void testX1andX2() {
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder = new FormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(x1);
        formula.add(x2);
        Circuit c = new Circuit(formula);
        x1.setValue(false);
        x2.setValue(true);
        assertFalse(c.getValue());
        x1.setValue(true);
        x2.setValue(true);
        assertTrue(c.getValue());
    }

    public void testX1andX2orX3() {
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder = new FormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x3=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(x1);
        formula.add(formulaBuilder.getFormula(Operator.OR));
        formula.add(x2);
        formula.add(x3);
        Circuit c = new Circuit(formula);
        x1.setValue(false);
        x2.setValue(true);
        x3.setValue(false);
        assertFalse(c.getValue());
        x1.setValue(true);
        x2.setValue(false);
        x2.setValue(true);
        assertTrue(c.getValue());
    }

    public void testAlwaysTrue(){
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder = new FormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.OR));
        formula.add(x1);
        formula.add(formulaBuilder.getFormula(Operator.NOT));
        formula.add(x1);
        Circuit c = new Circuit(formula);
        x1.setValue(false);
        assertTrue(c.getValue());
        x1.setValue(true);
        assertTrue(c.getValue());
    }

    // x1 & !(x2 | x3)
    public void testX1andNotPX2orX3P() {
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder = new FormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x3=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(x1);
        formula.add(formulaBuilder.getFormula(Operator.NOT));
        formula.add(formulaBuilder.getFormula(Operator.OR));
        formula.add(x2);
        formula.add(x3);
        Circuit c = new Circuit(formula);
        x1.setValue(false);
        x2.setValue(false);
        x3.setValue(false);
        assertFalse(c.getValue());
        x1.setValue(false);
        x2.setValue(true);
        x3.setValue(true);
        assertFalse(c.getValue());
        x1.setValue(true);
        x2.setValue(false);
        x3.setValue(false);
        assertTrue(c.getValue());
    }

    // !x1 & !x2
    public void testNotX1andNotX2() {
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder = new FormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(formulaBuilder.getFormula(Operator.NOT));
        formula.add(x1);
        formula.add(formulaBuilder.getFormula(Operator.NOT));
        formula.add(x2);
        Circuit c = new Circuit(formula);
        x1.setValue(true);
        x2.setValue(true);
        assertFalse(c.getValue());
        x1.setValue(false);
        x2.setValue(true);
        assertFalse(c.getValue());
        x1.setValue(false);
        x2.setValue(false);
        assertTrue(c.getValue());
    }
    public void testX1andX2orNotX1() {
        ArrayList<Formula> formula = new ArrayList<>();
        AbstractFormulaBuilder formulaBuilder  = new DoubleFormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.OR));
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(x1);
        formula.add(x2);
        formula.add(formulaBuilder.getFormula(Operator.NOT));
        formula.add(x1);
        Circuit c = new Circuit(formula);
        x1.setValue(true);
        x2.setValue(false);
        assertFalse(c.getValue());
        try {
            x1.setValue(0.1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            x2.setValue(0.3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(c.getDoubleValue(),1.0,0.001);
    }
    public void testGreaterThanElement() {
        ArrayList<Formula> formula = new ArrayList<>();
        AbstractFormulaBuilder formulaBuilder  = new DoubleFormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.GTE));
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(x1);
        formula.add(formulaBuilder.getFormula(Operator.NOT));
        formula.add(x1);
        formula.add(x1);
        Circuit c = new Circuit(formula);
        try {
            x1.setValue(0.5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(c.getDoubleValue(),0.0);
        try {
            x1.setValue(1.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(c.getDoubleValue(),0.0,0.001);
        try {
            x1.setValue(0.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(c.getDoubleValue(),1.0,0.001);
    }

}