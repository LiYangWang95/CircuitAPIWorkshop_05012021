package circuitry;
import circuitry.Operations.*;

public class FormulaFactory {
    // Return new Constant
    public Constant getConstant(Boolean f){
        Constant con = new Constant();
        con.setValue(f);
        return con;
    }

    // Return new And
    public And getAnd(Formula lhs, Formula rhs){
        And and = new And();
        and.setValue(lhs, rhs);
        return and;
    }

    // Return new Or
    public Or getOr(Formula lhs, Formula rhs){
        Or or = new Or();
        or.setValue(lhs, rhs);
        return or;
    }

    // Return new Negation
    public Negation getNot(Formula f){
        Negation not = new Negation();
        not.setValue(f);
        return not;
    }
}
