package edu.tue.apiworkshop.logic;

public abstract class Binary extends Operation {

    protected LogicFormula rhs;
    protected LogicFormula lhs;

    protected Binary(LogicFormula rhs, LogicFormula lhs) {
        this.rhs = rhs;
        this.lhs = lhs;
    }
    
    @Override
    public void setValue(String variableName, Boolean value) {
        rhs.setValue(variableName, value);
        lhs.setValue(variableName, value);
    }
} 