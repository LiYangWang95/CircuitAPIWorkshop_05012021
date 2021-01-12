package com.circuitapi;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Circuit {
    private Formula root;

    public Circuit(ArrayList<Formula> formulas) {
        if (!formulas.isEmpty() && (formulas.get(formulas.size()-1) instanceof Operand)) {
            root = formulas.get(0);
            formCircuit(formulas);
        } else {
            System.err.println("No formulas found!");
            System.exit(0);
        }
    }

    public boolean getValue() {
        return root.getValue();
    }
    public double getDoubleValue() {

        return root.getDoubleValue();
    }

    private Formula formCircuit(ArrayList<Formula> formulas) {
        if (formulas.isEmpty()) return null;
        Formula firstElement = formulas.remove(0);
        if(firstElement instanceof Operand) {
            return firstElement;
        } else {
            if(firstElement instanceof UnaryExpression) {
                ((UnaryExpression) firstElement).lhs = formCircuit(formulas);
                return firstElement;
            } else if(firstElement instanceof BinaryExpression) {
                ((BinaryExpression) firstElement).lhs = formCircuit(formulas);
                ((BinaryExpression) firstElement).rhs = formCircuit(formulas);
                return firstElement;
            }
        }
        return null;
    }

}
