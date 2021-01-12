package com.circuitapi;

public class DoubleFormulaBuilder extends AbstractFormulaBuilder {
    public Formula getFormula(Operator operator) {
        switch (operator) {
            case AND:
                return new BinaryExpression(Operator.AND);
            case OR:
                return new BinaryExpression(Operator.OR);
            case GTE:
                return new BinaryExpression(Operator.GTE);
            case NOT:
                return new UnaryExpression(Operator.NOT);
            case OPERAND:
                return new Operand();
            default:
                return null;
        }
    }

}
