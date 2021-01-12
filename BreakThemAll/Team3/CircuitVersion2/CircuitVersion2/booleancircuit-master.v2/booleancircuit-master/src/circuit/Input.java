package circuit;

public class Input implements Component{
    private boolean value;
    private double doubleValue;

    public void setValue(boolean value){
        this.value = value;
    }

    public void setValue(double doubleValue){
        if(doubleValue < 0 || doubleValue > 1){
            throw new CircuitInputException("Invalid input: The value should be in range 0 to 1");
        }
        this.doubleValue = doubleValue;
    }

    @Override
    public boolean getValue() {
        return value;
    }

    @Override
    public double getDoubleValue() {
        return doubleValue;
    }


}
