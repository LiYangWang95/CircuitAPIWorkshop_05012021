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
public abstract class BinaryOperation extends Formula{
    protected Formula rhs;
    protected Formula lhs;

    public void setValue(Formula lf, Formula rf) {
        lhs = lf;
        rhs = rf;
    }
    
}
