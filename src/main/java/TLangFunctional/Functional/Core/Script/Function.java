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
    public int setLineTo = -1;
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
        if (line.startsWith("SetLine")) {
            setLineTo = Integer.parseInt(line.substring(("SetLine").length() + 1, line.length() - 1));
        }
        var = null;
        return (Variable[]) vars1.toArray();
    }
    
    @Override
    public String toString() {
        try {
            Execute(null, null, null, null, null);
        } catch (Exception err) {
        }
        return "Function{" +
                "line='" + line + '\'' +
                ", Marker=" + Marker +
                ", GOTO=" + GOTO +
                ", var=" + var +
                '}';
    }
}