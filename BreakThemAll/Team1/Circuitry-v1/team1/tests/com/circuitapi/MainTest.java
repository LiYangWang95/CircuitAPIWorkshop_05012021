package com.circuitapi;

import junit.framework.TestCase;

import java.util.ArrayList;

public class MainTest extends TestCase {

    // x1 and x2
    public void testX1andX2() {
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder = new FormulaBuilder();
        Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
        Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
        formula.add(formulaBuilder.getFormula(Operator.AND));
        formula.add(x1);
        formula.add(x2);
        Circuit c = new Circuit(formula);
        // x1 = false, x2= true
        x1.setValue(false);
        x2.setValue(true);
        assertFalse(c.getValue());
        // x1 = true, x2 = true
        x1.setValue(true);
        x2.setValue(true);
        assertTrue(c.getValue());
        // Added: x1 = false, x2 = false
        x1.setValue(false);
        x2.setValue(false);
        assertFalse(c.getValue());
    }

    // x1 and x2 or x3
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

    // true
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

    // x1 and x2 or not x1
    public void testX1andX2orNotX1() {
        ArrayList<Formula> formula = new ArrayList<>();
        FormulaBuilder formulaBuilder  = new FormulaBuilder();
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
    }

    // Test to break
    public void testToBreak() {
        Formula x1 = new Formula() {
            @Override
            boolean getValue() {
                return false;
            }

            @Override
            void setValue(boolean value) {

            }
        };
        assertTrue(x1.getValue());
    }

}