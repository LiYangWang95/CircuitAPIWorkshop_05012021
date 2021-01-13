package edu.tue.apiworkshop.logic;

public class Variable extends Formula {

    private Double value;
    private String name;
    
    public Variable(String name) {
        this.name = name;
        this.value = null;
    }

    @Override
    public void setValue(String variableName, Double value) {
        if (variableName == name) {
               this.value=value;
        }
       
    }

    @Override
    public Double evaluate() {
        if(value==null)  {
            String message = "The value of variable " + name + " has not been set!";
            throw new IllegalStateException(message);
         }
         return value;    }
} 