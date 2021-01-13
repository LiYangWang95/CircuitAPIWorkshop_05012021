package com.circuitapi;

public class BinaryExpression extends Expression{
    protected Formula rhs;
    private Operator operator;

    protected BinaryExpression(Operator operator ) {
        this.operator = operator;
    }

    @Override
    public boolean getValue() {
        switch (operator) {
            case AND:
                return Boolean.logicalAnd(lhs.getValue(), rhs.getValue());
            case OR:
                return Boolean.logicalOr(lhs.getValue(), rhs.getValue());
        }
        return false;
    }

    @Override
    public void setValue(boolean value) {}
}
