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
public abstract class UnaryOperation extends Formula {
    protected Formula uniVal;

    public void setUniVal(Formula f){
        uniVal = f;
    }
    
}
