package edu.tue.apiworkshop.logic;

public class And extends Binary {

    public And(Formula lhs, Formula rhs) {
        super(lhs, rhs);
    }

    @Override
    public Double evaluate() {
        return lhs.evaluate() * rhs.evaluate();
    }

} 