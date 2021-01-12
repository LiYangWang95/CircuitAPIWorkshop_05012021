# ooad-api

API for calculating boolean expressions containing:
 - operands, denoted as **X1**, **X2**, **X3** etc.
 - boolean expressions: **AND**, **OR**, **NOT**
 
To be calculated, a boolean expression must be input using prefix notation. Examples:

 - **X1 AND !(X2 OR X3)** will be written in prefix notation as: **(AND, X1, NOT, OR, X2, X3)**
 - **!X1 OR !X2** will be written as: **(OR, NOT, X1, NOT, X2)**


An example is given in the Main class, as well as in the test cases, on how to form an expression.
Once expression is given as input, run the program to see the output in the command line.


 ## Example Code

```
ArrayList<Formula> formula = new ArrayList<>();
FormulaBuilder formulaBuilder = new FormulaBuilder();
Formula x1=formulaBuilder.getFormula(Operator.OPERAND);
Formula x2=formulaBuilder.getFormula(Operator.OPERAND);
Formula x3=formulaBuilder.getFormula(Operator.OPERAND);
formula.add(formulaBuilder.getFormula(Operator.AND));
formula.add(x1);
formula.add(formulaBuilder.getFormula(Operator.OR));
formula.add(x2);
formula.add(x3);
Circuit c = new Circuit(formula);
x1.setValue(false);
x2.setValue(true);
x3.setValue(false);
System.out.println(c.getValue());
```