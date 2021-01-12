package com.circuitapi;

public class UnaryExpression extends Expression{
    private Operator operator;

    protected UnaryExpression(Operator operator) {
        this.operator = operator;
    }

    @Override
    public boolean getValue() {
        return !lhs.getValue();
    }

    @Override
    double getDoubleValue() {
        return 1.0-lhs.getDoubleValue() ;
    }

    @Override
    public void setValue(boolean value) {}

    @Override
    void setValue(double value) {

    }
}
