package circuit;

public class Or extends DualInput {

    @Override
    public boolean getValue() {
        return lhs.getValue() || rhs.getValue();
    }

    @Override
    public void setInput(Component lhs, Component rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
