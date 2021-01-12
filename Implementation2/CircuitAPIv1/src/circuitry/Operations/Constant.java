/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitry.Operations;

import circuitry.Operations.Formula;

/**
 *
 * @author 20204909
 */
public class Constant extends Formula{
    private boolean value;

    // return the value
    @Override
    public boolean getValue() {
        return value;
    }

    // set the value
    public void setValue(boolean value) {
        this.value = value;
    }
    
    
    
}
