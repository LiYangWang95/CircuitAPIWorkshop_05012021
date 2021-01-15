package edu.tue.apiworkshop.logic;

public class Or extends Binary {

    public Or(LogicFormula rhs, LogicFormula lhs) {
        super(rhs, lhs);
    }

    @Override
    public Boolean evaluate() {
        return rhs.evaluate() || lhs.evaluate();
    }

} 