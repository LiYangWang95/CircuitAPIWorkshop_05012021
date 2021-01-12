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
    private double dValue;

    // return the value
    @Override
    public boolean getValue() {
        return value;
    }

    @Override
    public double getDValue() {
        return dValue;
    }

    // set the value
    public void setValue(boolean value) {
        this.value = value;
        if (this.value){
            dValue = 1.0;
        }else{
            dValue = 0.0;
        }
    }

    public void setDValue(double dval) throws Exception {
        if (dval >= 0.0 && dval <= 1.0){
            dValue = dval;
            if (dValue == 1.0){
                value = true;
            }
            else{
                value = false;
            }
        }
        else{
            throw new Exception("out of bounds: " + dval);
        }

    }
}
