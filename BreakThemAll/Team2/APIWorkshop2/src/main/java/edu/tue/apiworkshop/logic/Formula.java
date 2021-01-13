package edu.tue.apiworkshop.logic;

public abstract class Formula {
    public abstract Double evaluate();
    public void setValue(String variableName,Double value){}
} 