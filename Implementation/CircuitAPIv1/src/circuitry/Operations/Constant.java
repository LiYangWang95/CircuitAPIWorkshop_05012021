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
    private String name;
    private boolean value;

    @Override
    public boolean getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Constant(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
    
    
    
}
