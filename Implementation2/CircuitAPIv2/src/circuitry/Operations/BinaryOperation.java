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

    // Set the value of left hand side and right hand side
    public void setValue(Formula lf, Formula rf) {
        lhs = lf;
        rhs = rf;
    }
}
