package com.circuitapi;

public class FormulaBuilder {
    public Formula getFormula(Operator operator) {
        switch (operator) {
            case AND:
                return new BinaryExpression(Operator.AND);
            case OR:
                return new BinaryExpression(Operator.OR);
            case NOT:
                return new UnaryExpression(Operator.NOT);
            case OPERAND:
                return new Operand();
            default: return  null;
        }
    }

}
