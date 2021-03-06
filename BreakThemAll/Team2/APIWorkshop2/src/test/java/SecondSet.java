/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.tue.apiworkshop.circuitapi.Circuit;
import edu.tue.apiworkshop.circuitapi.CircuitContsructor;
import edu.tue.apiworkshop.logic.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 20204913
 */
public class SecondSet {
    static Formula f1, f2;
    @BeforeAll
    public static void setUp(){
        f1 = new Formula() {
            @Override
            public Double evaluate() {
                return 0.0;
            }
        };
        f2 = new Formula() {
            @Override
            public Double evaluate() {
                return 0.0;
            }
        };
    }
    
    @Test
    public void testX1andX2orNotX3(){
        //(x1 and x2) or(!x1)
       
        CircuitContsructor x1=CircuitContsructor.variable("X1");
        CircuitContsructor x2=CircuitContsructor.variable("X2");
        
        Circuit c= x1.and(x2).or(x1.not()).build();
        
        c.setValue("X1", Boolean.FALSE);
        c.setValue("X2", Boolean.TRUE);
        assert(c.evaluate()==Boolean.TRUE);
        
        
        c.setValue("X1", Boolean.TRUE);
        c.setValue("X2", Boolean.FALSE);
        assert(c.evaluate()==Boolean.FALSE);
        
        c.setValueDouble("X1", 0.0);
        c.setValueDouble("X2", 1.0);
        assert(c.evaluateDouble()==1.0);
        

        c.setValueDouble("X1", 0.5);
        c.setValueDouble("X2", 0.5);
        assert(c.evaluateDouble()==0.625);
        
        
        c.setValueDouble("X1", 0.0);
     //   c.setValueDouble("X2", 2.0);
        assertThrows(IllegalArgumentException.class,()->{
            c.setValueDouble("X2",2.0);
        });
       
    }
    
    @Test
    public void testX1andNotX1GTEX1(){
        //(x1 and not(x1)) gte x1
        CircuitContsructor x1=CircuitContsructor.variable("x1");
        Circuit c=x1.and(x1.not()).gte(x1).build();
        
        c.setValueDouble("x1",0.5);
        assert(c.evaluateDouble()==0.0);
        
        c.setValueDouble("x1",1.0);
        assert(c.evaluateDouble()==0.0);
        
        c.setValueDouble("x1",0.0);
        assert(c.evaluateDouble()==1.0);
        
    }

    @Test
    public void testX1andX2() {
        //Use CircuitConstructor to construct a blueprint. (this example: X1 and X2)
        CircuitContsructor cc=CircuitContsructor.variable("X1").and(CircuitContsructor.variable("X2"));
        //Once you are done, call build() method to obtain the Circuit object.
        Circuit c= cc.build();

        //Set up values for the inputs you specified.
        c.setValue("X3", Boolean.FALSE);
        c.setValue("X2", Boolean.TRUE);
        //Call evaluate on Circuit to get the output!
        assert(c.evaluate()==Boolean.FALSE);
        c.setValue("X1",Boolean.TRUE);
        c.setValue("X2", Boolean.TRUE);
        assert(c.evaluate()==Boolean.TRUE);

    }

    @Test
    public void testX1andX2OrX3(){
        Circuit c=CircuitContsructor.variable("X3").or(CircuitContsructor.variable("X1").and(CircuitContsructor.variable("X2"))).build();
        c.setValue("X1", Boolean.FALSE);
        c.setValue("X2", Boolean.TRUE);
        c.setValue("X3",Boolean.FALSE);
        assert(c.evaluate()==Boolean.FALSE);

        c.setValue("X1",Boolean.TRUE);
        c.setValue("X2", Boolean.TRUE);
        c.setValue("X3",Boolean.FALSE);
        assert(c.evaluate()==Boolean.TRUE);
    }

    @Test
    public void testX1andX3orX3EasierWay(){
        CircuitContsructor x1 = CircuitContsructor.variable("X1");
        CircuitContsructor x2 = CircuitContsructor.variable("X2");
        CircuitContsructor x3 = CircuitContsructor.variable("X3");
        Circuit c = x1.and(x2).or(x3).build();

        c.setValue("X1", Boolean.FALSE);
        c.setValue("X2", Boolean.TRUE);
        c.setValue("X3",Boolean.FALSE);
        assert(c.evaluate()==Boolean.FALSE);

        c.setValue("X1",Boolean.TRUE);
        c.setValue("X2", Boolean.TRUE);
        c.setValue("X3",Boolean.FALSE);
        assert(c.evaluate()==Boolean.TRUE);
    }

    @Test
    public void testX1OrNotX1(){
        CircuitContsructor x1 = CircuitContsructor.variable("X1");

        Circuit c=x1.or(x1.not()).build();

        c.setValue("X1", Boolean.FALSE);
        assert(c.evaluate()==Boolean.TRUE);
        c.setValue("X1", Boolean.FALSE);
        assert(c.evaluate()==Boolean.TRUE);
    }

    @Test
    public void testX1orX1andNotX1(){
        CircuitContsructor x1 = CircuitContsructor.variable("X1");
        CircuitContsructor x2=x1.not();
        CircuitContsructor x3=x2.and(x1);
        CircuitContsructor x4=x1.or(x3);
        Circuit c2=x4.build();
        c2.setValue("X1", Boolean.FALSE);
        assert(c2.evaluate()==Boolean.FALSE);
        c2.setValue("X1", Boolean.TRUE);
        assert(c2.evaluate()==Boolean.TRUE);
    }

    // To break
    @Test
    public void testToBreak1(){
        LogicFormula f = new LogicFormula() {
            @Override
            public Boolean evaluate() {
                return true;
            }
        };

        Not not = new Not(f);

        assertFalse(not.evaluate());
    }

    @Test
    public void testToBreak2(){
        And and = new And(f1, f2);

        assertTrue(and.evaluate());
    }

    @Test
    public void testToBreak3(){
        Or or = new Or(f1, f2);

        assertTrue(or.evaluate());
    }

    @Test
    public void testToBreak4() {
        Not not = new Not(f1);

        assertFalse(not.evaluate());
    }

    @Test
    public void testToBreak5(){
        Binary bin = new Binary(f1, f2) {
            @Override
            public Double evaluate() {
                return 1.0;
            }
        };

        bin.setValue("x", true);
        assertTrue(bin.evaluate());
    }

    @Test
    public void testToBreak6(){
        Unary uni = new Unary(f1) {
            @Override
            public Double evaluate() {
                return 1.0;
            }
        };

        uni.setValue("x", true);
        assertTrue(uni.evaluate());
    }

    @Test
    public void testToBreak7(){
        Variable v = new Variable("v");

        v.setValue("v", true);
        assertTrue(v.evaluate());
    }
}
