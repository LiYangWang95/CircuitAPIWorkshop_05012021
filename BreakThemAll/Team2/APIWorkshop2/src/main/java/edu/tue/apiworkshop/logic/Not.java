package edu.tue.apiworkshop.logic;

public class Not extends Unary{

    public Not(Formula operand) {
        super(operand);
    }

    @Override
    public Double evaluate(){
        return 1.0-operand.evaluate();
    }
}
