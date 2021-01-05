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
      @Override
    public boolean getValue() {
        return lhs.getValue()&& rhs.getValue();
    }


}
