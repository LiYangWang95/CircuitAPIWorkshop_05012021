package circuit;

public abstract class DualInput implements Component{
    protected Component lhs;
    protected Component rhs;

    @Override
    public boolean getValue() {
        return false;
    }

    public abstract void setInput(Component lhs, Component rhs);
}
