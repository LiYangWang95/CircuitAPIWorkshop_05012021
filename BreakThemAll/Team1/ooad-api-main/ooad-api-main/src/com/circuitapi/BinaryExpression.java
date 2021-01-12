package com.circuitapi;

public class BinaryExpression extends Expression {
    protected Formula rhs;
    private Operator operator;

    protected BinaryExpression(Operator operator) {
        this.operator = operator;
    }

    @Override
    public boolean getValue() {

        switch (operator) {
            case AND:
                return Boolean.logicalAnd(lhs.getValue(), rhs.getValue());
            case OR:
                return Boolean.logicalOr(lhs.getValue(), rhs.getValue());
            case GTE:
                return false;

        }
        return false;
    }

    @Override
    public double getDoubleValue() {

        switch (operator) {
            case AND:
                return (lhs.getDoubleValue() * rhs.getDoubleValue());
            case OR:
                return 1.0 - (1.0 - lhs.getDoubleValue()) * (1.0 - rhs.getDoubleValue());
            case GTE:
                return (lhs.getDoubleValue() >= rhs.getDoubleValue() ? 1.0 : 0.0);
        }
        return 0;
    }

    @Override
    public void setValue(boolean value) {
    }

    @Override
    void setValue(double value) {

    }
}
