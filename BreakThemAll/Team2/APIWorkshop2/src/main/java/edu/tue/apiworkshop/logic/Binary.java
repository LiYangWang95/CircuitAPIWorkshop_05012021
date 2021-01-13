package edu.tue.apiworkshop.logic;

public abstract class Binary extends Operation {

    protected Formula rhs;
    protected Formula lhs;

    protected Binary(Formula lhs, Formula rhs) {
        this.rhs = rhs;
        this.lhs = lhs;
    }
    
    @Override
    public void setValue(String variableName, Double value) {
        rhs.setValue(variableName, value);
        lhs.setValue(variableName, value);
    }
} 