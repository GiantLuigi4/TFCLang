package Functional.Utils;

import Functional.Variable;

public class VariableFinder {
    static int currentVar = 0;
    static String name;
    static private Variable[] vars;

    public static Variable findVar(String name1, Variable[] vars) {
        name = name1;
        while (hasNext()) {
            Variable var = nextVar();
            if (matches(var)) {
                return var;
            }
        }
        throw new RuntimeException(new NullPointerException("Provided variable list lacks a variable with the name:" + name1));
    }

    public static boolean matches(Variable var) {
        return var.varName.equals(name);
    }

    public static Variable nextVar() {
        Variable func = (vars[currentVar]);
        currentVar++;
        return func;
    }

    public static boolean hasNext() {
        return vars.length < currentVar;
    }
}
