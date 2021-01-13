package circuit;

public abstract class DualInput implements Component{
    protected Component lhs;
    protected Component rhs;

    public abstract void setInput(Component lhs, Component rhs);
}
