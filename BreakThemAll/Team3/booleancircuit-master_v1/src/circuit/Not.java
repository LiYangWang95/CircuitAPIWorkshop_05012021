package circuit;

public class Not extends SingleInput {

    @Override
    public boolean getValue() {
        return !component.getValue();
    }

    @Override
    public void setInput(Component component) {
        this.component = component;
    }
}
