/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.tue.apiworkshop.circuitapi.Circuit;
import edu.tue.apiworkshop.circuitapi.CircuitContsructor;
import edu.tue.apiworkshop.logic.GTE;
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
public class AbolfazlTest {
    @Test
    public void testNPEDouble(){
        CircuitContsructor x1=CircuitContsructor.variable("x1");
        Circuit c=x1.and(x1.not()).gte(x1).build();
        
        assertThrows(IllegalArgumentException.class, ()->{
            c.setValueDouble("x1",null);
        });
        
        c.setValueDouble("x1",1.0);
        assert(c.evaluateDouble()==0.0);
        
        c.setValueDouble("x1",0.0);
        assert(c.evaluateDouble()==1.0);
    }
    
    @Test
    public void testNPEBoolean() {
          //Use CircuitConstructor to construct a blueprint. (this example: X1 and X2)
          CircuitContsructor cc=CircuitContsructor.variable("X1").and(CircuitContsructor.variable("X2"));
          //Once you are done, call build() method to obtain the Circuit object.
          Circuit c= cc.build();
          
          //Set up values for the inputs you specified.
          c.setValue("X1", null);
          c.setValue("X2", Boolean.TRUE);
          //Call evaluate on Circuit to get the output!
          assertThrows(IllegalStateException.class,()->{c.evaluate();});
          c.setValue("X1",Boolean.TRUE);
          c.setValue("X2", Boolean.TRUE);
          assert(c.evaluate()==Boolean.TRUE);
          
    }
    
    @Test
    public void testParanthesis(){
        //(x2 and x3) or (!x4) if all input false, output is true!
        
        CircuitContsructor x1=CircuitContsructor.variable("X1");
        CircuitContsructor x2=CircuitContsructor.variable("X2");
        CircuitContsructor x3=CircuitContsructor.variable("X3");
        CircuitContsructor x4=CircuitContsructor.variable("X4");
        
        Circuit c=x1.gte(x2.and(x3).or(x4.not())).build();
        c.setValueDouble("X1", 1.0);
        c.setValue("X2", Boolean.FALSE);
        c.setValue("X3", Boolean.FALSE);
        c.setValue("X4", Boolean.FALSE);
        assert(c.evaluate()==Boolean.TRUE);
        assert(c.evaluateDouble()==1.0);
    }
}
