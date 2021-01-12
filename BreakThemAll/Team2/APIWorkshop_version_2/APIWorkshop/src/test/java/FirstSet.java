/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.tue.apiworkshop.circuitapi.Circuit;
import edu.tue.apiworkshop.circuitapi.CircuitContsructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 20204913
 */
public class FirstSet {
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
}
