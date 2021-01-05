/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitry;

import circuitry.Operations.Formula;

/**
 *
 * @author 20204909
 */
public class Circuit extends Formula{
    private boolean value;
    private Formula formula;

    @Override
    public boolean getValue() {
       return value;
    }
    
    private void calculateCircuit(Formula f){
        formula=f;
        value = formula.getValue();
                 
    }
    
}
