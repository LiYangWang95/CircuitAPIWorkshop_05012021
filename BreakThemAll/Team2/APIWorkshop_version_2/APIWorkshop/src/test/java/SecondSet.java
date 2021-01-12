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
public class SecondSet {
    
    
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
    
}
