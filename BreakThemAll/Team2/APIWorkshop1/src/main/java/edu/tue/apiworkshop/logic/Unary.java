package edu.tue.apiworkshop.logic;

public abstract class Unary extends Operation {

    protected LogicFormula operand;

    protected Unary(LogicFormula operand) {
        this.operand = operand;
    }
      @Override
    public void setValue(String variableName, Boolean value) {
        operand.setValue(variableName, value);
    }
    

}