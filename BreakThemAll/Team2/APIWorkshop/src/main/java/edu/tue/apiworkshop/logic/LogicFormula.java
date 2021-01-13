package edu.tue.apiworkshop.logic;

public abstract class LogicFormula {
    public abstract Boolean evaluate();
    public void setValue(String variableName, Boolean value){}
} 