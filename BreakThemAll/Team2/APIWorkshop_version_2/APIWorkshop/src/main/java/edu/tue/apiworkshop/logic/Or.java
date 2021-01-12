package edu.tue.apiworkshop.logic;

public class Or extends Binary {

    public Or(Formula lhs, Formula rhs) {
        super(lhs, rhs);
    }

    @Override
    public Double evaluate() {
        return 1.0-(1.0-lhs.evaluate())*(1.0-rhs.evaluate());
    }

} 