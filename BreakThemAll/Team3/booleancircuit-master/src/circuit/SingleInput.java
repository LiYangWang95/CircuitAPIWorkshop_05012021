package circuit;

public abstract class SingleInput implements Component{
    Component component;

    public abstract void setInput(Component component);
}
