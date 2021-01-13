package circuit;

import java.util.ArrayList;

public class Circuit implements Component {
    ArrayList<Component> components;

    public Circuit(){
        components = new ArrayList<>();
    }

    public Input createInput(){
        Input input = new Input();
        return input;
    }

    //possibility to refactor these method using Factory or Builder pattern------
    public And createAndGate(){
        And and = new And();
        components.add(and);
        return and;
    }

    public Or createOrGate(){
        Or or = new Or();
        components.add(or);
        return or;
    }

    public Not createNotGate() {
        Not not = new Not();
        components.add(not);
        return not;
    }

    public Gte createGte() {
        Gte gte = new Gte();
        components.add(gte);
        return gte;
    }
    //----------------------------------------------------------------------------

    @Override
    public boolean getValue() {
        boolean result = false;
        for(Component comp: components){
            result = comp.getValue();
        }
        return result;
    }

    @Override
    public double getDoubleValue() {
        double result = 0;
        for(Component comp: components){
            result = comp.getDoubleValue();
        }

        return result;
    }

}
