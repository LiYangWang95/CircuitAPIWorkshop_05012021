package edu.tue.apiworkshop.circuitapi;

import edu.tue.apiworkshop.logic.LogicFormula;

public class Circuit {

    private LogicFormula formula;

    protected Circuit(LogicFormula formula) {
        this.formula = formula;
    }

    public void setValue(String variableName, Boolean value) {
        formula.setValue(variableName, value);
    }

    public Boolean evaluate() {
        return formula.evaluate();
    }

} 