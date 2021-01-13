package edu.tue.apiworkshop.circuitapi;

import edu.tue.apiworkshop.logic.Formula;

public class Circuit {

    private Formula formula;

    protected Circuit(Formula formula) {
        this.formula = formula;
    }

    public void setValue(String variableName, Boolean value) { 
        Double d=null;
        if(value!=null){
                    if(value.equals(Boolean.TRUE)) d=1.0;
                    else d=0.0;
        }
        formula.setValue(variableName, d);

    }
    
    public void setValueDouble(String variableName, Double value) {
        if(value==null) throw new IllegalArgumentException("the value can not be null!");
        if(value.compareTo(0.0)<0 || value.compareTo(1.0)>0) throw new IllegalArgumentException("The value must be beween 0.0 and 1.0!");
        formula.setValue(variableName, value);
    }


    public Boolean evaluate() {
       Double d=evaluateDouble();
       if(d.compareTo(0.0)==0) 
           return Boolean.FALSE;
       else if(d.compareTo(1.0)==0) 
           return Boolean.TRUE;
       
       throw new IllegalStateException("Illegal operation on Boolean!");
    }
    
    public Double evaluateDouble(){
        return formula.evaluate();
    }
} 