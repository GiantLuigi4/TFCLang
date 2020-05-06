package Functional.Core;

import java.util.ArrayList;

public class Function {
    private String line;

    public Function(String line) {
        this.line = line;
    }

    public Variable[] Execute(Class staticRef, Class executor, Variable... vars) {
        ArrayList<Variable> vars1 = new ArrayList<>();
        for (Variable var : vars) {
            vars1.add(var);
        }
        return (Variable[]) vars1.toArray();
    }
}