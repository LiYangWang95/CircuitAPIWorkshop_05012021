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
    }

    public void setDValue(double dval) throws Exception {
        if (dval >= 0.0 && dval <= 1.0){
            dValue = dval;
        }
        else{
            throw new Exception("out of bounds");
        }

    }

//    public void setDValue(double dval) {
//        try {
//            check(dval);
//            dValue = dval;
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    private void check(double dval) throws Exception{
//        if (dval < 0.0 || dval > 1.0){
//            throw new Exception("out of bounds");
//        }
//    }
    
    
}
