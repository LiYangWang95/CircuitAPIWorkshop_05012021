package circuit;

public class Not extends SingleInput {

    @Override
    public boolean getValue() {
        return !component.getValue();
    }

    @Override
    public double getDoubleValue() throws CircuitInputException{
        return (1 - component.getDoubleValue());
    }

    @Override
    public void setInput(Component component) {
        this.component = component;
    }
}
