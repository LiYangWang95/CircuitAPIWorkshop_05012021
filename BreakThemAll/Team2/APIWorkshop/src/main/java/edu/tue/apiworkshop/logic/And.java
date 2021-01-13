package edu.tue.apiworkshop.logic;

public class And extends Binary {

    public And(LogicFormula rhs, LogicFormula lhs) {
        super(rhs, lhs);
    }

    @Override
    public Boolean evaluate() {
        return rhs.evaluate() && lhs.evaluate();
    }
    
} 