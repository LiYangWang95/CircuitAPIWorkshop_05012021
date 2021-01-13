package circuit;

public class Input implements Component{
    boolean value;

    public void setValue(boolean value){
        this.value = value;
    }

    @Override
    public boolean getValue() {
        return value;
    }

}
