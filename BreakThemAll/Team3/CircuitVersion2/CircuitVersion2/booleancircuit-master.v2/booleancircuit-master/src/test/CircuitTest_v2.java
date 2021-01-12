import circuit.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircuitTest_v2 {
    @Test
    public void testX1andX2orNotX1() {
        Circuit c = new Circuit();

        Input x1 = c.createInput();
        Input x2 = c.createInput();

        And g1 = c.createAndGate();
        Not g3 = c.createNotGate();
        Or g2 = c.createOrGate();

        //(x1 and x2) or not(x1)
        g1.setInput(x1, x2);
        g3.setInput(x1);
        g2.setInput(g1, g3);

        //-------------------------------------------------

        x1.setValue(true);
        x2.setValue(false);
        assertEquals(false, c.getValue());

        x1.setValue(0.5);
        x2.setValue(0.5);
        assertEquals(0.625, c.getDoubleValue());

        try{
            x1.setValue(0.0);
            x2.setValue(2.0);
            c.getDoubleValue();
        } catch (CircuitInputException e){
            System.out.println(e.toString());
        }

    }

    /** Ensure that one variable cannot be filled with two different values.
     * Create a circuit for x1 and x1. Make sure that for any usage of your
     * API that would not lead to x1 * x1 result, an exception is thrown.
     * For example if there was a way to feed the circuit with two different
     * values 0.3 and 0.5 an exception is thrown indicating that this is
     * improper use of the circuit.
     *
     * x1 = 1
     * x2 = 1
     * And(x1, x2) -> this is improper use
     *
     * x1
     * And(x1, x1) -> this is ok
     *
     */

    @Test
    public void testImproperUseOfTheCircuit() {
        // can it be done with your circuit?
    }

    @Test
    public void testGreaterThanElement() {
        Circuit c = new Circuit();
        Input x1 = c.createInput();

        Not g3 = c.createNotGate();
        And g2 = c.createAndGate();
        Gte g1 = c.createGte();

        //(x1 and not(x1)) gte x1
        g3.setInput(x1);
        g2.setInput(x1, g3);
        g1.setInput(g2, x1);

        try {
            x1.setValue(0.5);
        } catch(CircuitInputException e) {
            fail();
        }
        assertEquals(0.0, c.getDoubleValue(), 0.001);

        try {
            x1.setValue(1.0);
        } catch(CircuitInputException e) {
            fail();
        }
        assertEquals(0.0, c.getDoubleValue(), 0.001);

        try {
            x1.setValue(0.0);
        } catch(CircuitInputException e) {
            fail();
        }
        assertEquals(1.0,  c.getDoubleValue(), 0.001);

    }
}