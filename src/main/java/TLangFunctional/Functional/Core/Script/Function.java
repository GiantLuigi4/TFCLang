package TLangFunctional.Functional.Core.Script;

import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Core.Class.Import;
import TLangFunctional.Functional.Core.Class.Variable;

import java.util.ArrayList;

public class Function {
    public String line;
    public boolean Marker = false;
    public boolean GOTO = false;
    public Variable var = null;
    public Function(String line) {
        Marker = line.equals("markGoTo;");
        GOTO = line.equals("GoTo;");
        this.line = line;
    }

    public Variable[] Execute(Class staticRef, Class executor, ArrayList<Import> imports, Variable[] vars, Variable[] methodVars) {
        ArrayList<Variable> vars1 = new ArrayList<>();
        for (Variable var : vars) {
            vars1.add(var);
        }
        var = null;
        return (Variable[]) vars1.toArray();
    }
}