/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circuitry.Operations;

/**
 *
 * @author 20204909
 */
public class Negation extends UnaryOperation{

    // return the value
    @Override
    public boolean getValue() {
        return !uniVal.getValue();
    }

    @Override
    public double getDValue() {
        return 1.0 - uniVal.getDValue();
    }

}
