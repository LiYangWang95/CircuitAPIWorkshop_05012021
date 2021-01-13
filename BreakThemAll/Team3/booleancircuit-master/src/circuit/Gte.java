package circuit;

public class Gte extends DualInput{

    @Override
    public boolean getValue() {
        return false;
    }

    @Override
    public double getDoubleValue() {
        return (lhs.getDoubleValue() >= rhs.getDoubleValue()) ? 1 : 0;
    }

    @Override
    public void setInput(Component lhs, Component rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
