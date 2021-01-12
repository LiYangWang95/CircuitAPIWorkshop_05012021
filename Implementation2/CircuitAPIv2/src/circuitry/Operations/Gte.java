package circuitry.Operations;

public class Gte extends BinaryOperation{
    @Override
    public boolean getValue() {
        return false;
    }

    @Override
    public double getDValue() {
        if (lhs.getDValue() >= rhs.getDValue()){
            return 1.0;
        }
        else{
            return 0.0;
        }
    }


}
