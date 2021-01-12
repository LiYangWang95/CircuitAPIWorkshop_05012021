package com.circuitapi;

public class Operand extends Formula {

    private boolean value;
    private double doubleValue;

    public boolean getValue() {
        return value;
    }

    @Override
    double getDoubleValue() {
        return doubleValue;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    void setValue(double value) throws CircuitInputException{
        if(value<0.0 && value>1.0) {
        throw new CircuitInputException("Out of Bound");
        }
        this.doubleValue = value;
    }

}
