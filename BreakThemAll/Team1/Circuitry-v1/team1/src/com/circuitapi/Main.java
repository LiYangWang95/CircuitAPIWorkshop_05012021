package com.circuitapi;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        System.out.println("API Started");
        System.out.println("Testing: x1 AND x2 OR x3 with x1 = false, x2 = true, x3 = false");
        System.out.println(c.getValue());
    }
}
