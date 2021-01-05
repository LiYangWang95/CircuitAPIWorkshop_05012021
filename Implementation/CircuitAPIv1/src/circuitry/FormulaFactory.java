package circuitry;
import circuitry.Operations.*;

public class FormulaFactory {
    public Formula getFormula(FormulaType type){
        if(type == FormulaType.Circuit){
            return new Circuit();
        }
        if(type == FormulaType.Constant){
            return new Constant();
        }
        if(type == FormulaType.And){
            return new And();
        }
        if(type == FormulaType.Or){
            return new Or();
        }
        if(type == FormulaType.Not){
            return new Negation();
        }
        return null;
    }
}
