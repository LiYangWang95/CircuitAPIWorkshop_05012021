package com.circuitapi;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        System.out.println(c.getDoubleValue());

    }
}
