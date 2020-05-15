package TLangFunctional.Functional.Core.Script;

import TLangFunctional.Functional.ClassContext.CustomClasses;
import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Core.Class.Object;
import TLangFunctional.Functional.Core.Class.Variable;

import java.util.ArrayList;

public class Method {
    public ArrayList<Integer> gotos = new ArrayList<>();
    Class containingClass;
    public ArrayList<Integer> usedGotos = new ArrayList<>();
    public String name;
    ArrayList<Function> functions;
    ArrayList<Variable> methodVars;
    
    public Variable Run(Class executor, Class containingInstance) {
        for (int i = 0; i < functions.size(); i++) {
            GoTo gt = execute(executor, i, containingInstance);
            if (gt.shouldGoTo) {
                i = gt.line;
            }
        }
        return null;
    }
    
    public Method(ArrayList<Function> functions, String name, Class container) {
        this.functions = functions;
        this.name = name;
        this.containingClass = container;
    }

    public GoTo execute(Class executor, int line, Class containingInstance) {
        Object staticReference = (Object) executor;
        if (executor instanceof Variable) {
            staticReference = ((Object) CustomClasses.getClassByName(((Variable) executor).varName));
        }
        Function function = functions.get(line);
        containingInstance.vars = function.Execute(staticReference, executor, containingInstance.imports, containingInstance.vars, (Variable[]) methodVars.toArray());
        if (!(function.var.equals(null))) {
            methodVars.add(function.var);
        }
        if (function.Marker) {
            gotos.add(line);
        } else if (function.GOTO) {
            if (!usedGotos.contains(line)) {
                usedGotos.add(line);
                return new GoTo(gotos.get(gotos.size() - 1));
            }
        } else if (function.setLineTo != -1) {
            return new GoTo(function.setLineTo);
        }
        return new GoTo();
    }

    public void finish() {
        usedGotos.clear();
        gotos.clear();
        methodVars.clear();
    }
    
    @Override
    public String toString() {
        String functions = "";
        for (Function func : this.functions) {
            functions += "\n" + func.toString();
        }
        try {
            return "Method{" +
                    "containingClass=" + containingClass.toString() +
                    ", name='" + name + '\'' +
                    ", functions=" + functions + "\n" +
                    '}';
        } catch (Exception err) {
            return "Method{" +
                    "containingClass=" + "null" +
                    ", name='" + name + '\'' +
                    ", functions=" + functions + "\n" +
                    '}';
        }
    }
}
