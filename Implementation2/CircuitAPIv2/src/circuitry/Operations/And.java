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
public class And extends BinaryOperation{
    // return value
      @Override
    public boolean getValue() {
        return lhs.getValue()&& rhs.getValue();
    }

    @Override
    public double getDValue() {
        return lhs.getDValue()* rhs.getDValue();
    }


}
