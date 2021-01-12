package edu.tue.apiworkshop.logic;

public abstract class Unary extends Operation {

    protected Formula operand;

    protected Unary(Formula operand) {
        this.operand = operand;
    }
    
    @Override
    public void setValue(String variableName, Double value) {
        operand.setValue(variableName, value);
    }
    

}