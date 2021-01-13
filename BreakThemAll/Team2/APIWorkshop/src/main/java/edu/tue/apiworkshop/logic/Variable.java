package edu.tue.apiworkshop.logic;

public class Variable extends LogicFormula {

    private Boolean value;
    private String name;
    
    public Variable(String name) {
        this.name = name;
        this.value = null;
    }

    @Override
    public void setValue(String variableName, Boolean value) {
        if (variableName == name) {
            this.value = value;
        }
    }

    @Override
    public Boolean evaluate() {
        if(value==null)  {
            String message = "The value of variable " + name + " has not been set!";
            throw new IllegalStateException(message);
         }
         return value;
    } 

} 