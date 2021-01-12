package com.circuitapi;

public abstract class Formula {
    abstract boolean getValue();
    abstract double getDoubleValue();
    abstract void setValue(boolean value);
    abstract void setValue(double value) throws Exception;
}
