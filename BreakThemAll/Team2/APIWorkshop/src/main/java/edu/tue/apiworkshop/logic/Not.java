package edu.tue.apiworkshop.logic;

public class Not extends Unary{

    public Not(LogicFormula operand) {
        super(operand);
    }

    @Override
    public Boolean evaluate(){
        return !operand.evaluate();
    }
}
