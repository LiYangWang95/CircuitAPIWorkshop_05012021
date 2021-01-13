/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tue.apiworkshop.logic;

/**
 *
 * @author 20204913
 */
public class GTE extends Binary{
    
    //X1>=X2 ->GTE(X1,X2)
    //X2>=X1 ->GTE(X2,X1)
    
    public GTE(Formula lhs, Formula rhs) {
        super(lhs, rhs);
    }

    @Override
    public Double evaluate() {
        if(lhs.evaluate().compareTo(rhs.evaluate())<0) return 0.0;
        else return 1.0;
    }
    
}
