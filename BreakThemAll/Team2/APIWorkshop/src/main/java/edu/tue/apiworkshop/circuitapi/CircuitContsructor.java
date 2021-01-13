package edu.tue.apiworkshop.circuitapi;

import edu.tue.apiworkshop.logic.And;
import edu.tue.apiworkshop.logic.LogicFormula;
import edu.tue.apiworkshop.logic.Not;
import edu.tue.apiworkshop.logic.Or;
import edu.tue.apiworkshop.logic.Variable;

public class CircuitContsructor {

    private LogicFormula formula;

    private CircuitContsructor(LogicFormula formula) {
        this.formula = formula;
    }

    public static CircuitContsructor variable(String name) {
        assert(name != null);
        Variable variable = new Variable(name); 
        return new CircuitContsructor(variable);
    }

    public CircuitContsructor and(CircuitContsructor rhs) {
        return new CircuitContsructor(new And(this.formula, rhs.formula));
    }

    public CircuitContsructor or(CircuitContsructor rhs) {
        return new CircuitContsructor(new Or(this.formula, rhs.formula));
    }

    public CircuitContsructor not() {
        return new CircuitContsructor(new Not(this.formula));
    }

    public Circuit build() {
        return new Circuit(formula);
    }
}