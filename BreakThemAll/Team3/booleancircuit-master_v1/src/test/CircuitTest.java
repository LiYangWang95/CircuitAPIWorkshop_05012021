import circuit.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircuitTest {

    @Test
    public void testX1andX2(){
        //construct the circuit
        Circuit c = new Circuit();
        Input x1 = c.createInput();
        Input x2 = c.createInput();
        c.createAndGate().setInput(x1, x2);

        //set the input connector
        x1.setValue(true);
        x2.setValue(false);
        assertEquals(false, c.getValue());

        //re-set the input connector
        x1.setValue(false);
        x2.setValue(false);
        assertEquals(false, c.getValue());

    }

    @Test
    public void testX1andX2orX3(){
        //construct the circuit
        Circuit c = new Circuit();

        Input x1 = c.createInput();
        Input x2 = c.createInput();
        Input x3 = c.createInput();
        And g1 = c.createAndGate();
        Or g2 = c.createOrGate();

        g1.setInput(x1, x2);
        g2.setInput(g1, x3);

        //set the input connector
        x1.setValue(false);
        x2.setValue(true);
        x3.setValue(false);
        assertEquals(false, c.getValue());

        //re-set the input connector
        x1.setValue(true);
        x2.setValue(false);
        x3.setValue(true);
        assertEquals(true, c.getValue());

    }

    @Test
    public void testAlwaysTrue(){
        Circuit c = new Circuit();
        Input x1 = c.createInput();
        Not not = c.createNotGate();

        not.setInput(x1);

        x1.setValue(false);

        assertEquals(true, c.getValue());
    }

    @Test
    public void testX1orX2orX3(){
        Circuit c = new Circuit();
        Input x1 = c.createInput();
        Input x2 = c.createInput();
        Input x3 = c.createInput();
        Or g1 = c.createOrGate();
        Or g2 =c.createOrGate();

        g1.setInput(x1, x2);
        g2.setInput(g1, x3);

        x1.setValue(true);
        x2.setValue(false);
        x3.setValue(true);

        assertEquals(true, c.getValue());
    }

    @Test
    public void testX1andX2andX3(){
        Circuit c = new Circuit();
        Input x1 = c.createInput();
        Input x2 = c.createInput();
        Input x3 = c.createInput();
        And g1 = c.createAndGate();
        And g2 = c.createAndGate();

        g1.setInput(x1, x2);
        g2.setInput(g1, x3);

        x1.setValue(true);
        x2.setValue(false);
        x3.setValue(true);

        assertEquals(false, c.getValue());
    }

    @Test
    public void testAlwaysFalse(){
        Circuit c = new Circuit();
        Input x1 = c.createInput();
        Not not = c.createNotGate();

        not.setInput(x1);

        x1.setValue(true);

        assertEquals(false, c.getValue());
    }

    // To break
    @Test
    public void toBreak1(){
        DualInput d = new DualInput() {
            @Override
            public void setInput(Component lhs, Component rhs) {

            }
        };

        assertFalse(d.getValue());
    }

    @Test
    public void toBreak2(){
        Component c = new Component() {
            @Override
            public boolean getValue() {
                return false;
            }
        };

        assertFalse(c.getValue());
    }
}
