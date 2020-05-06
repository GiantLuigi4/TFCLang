package Functional;

import Functional.ClassContext.CustomClasses;

import java.util.ArrayList;

public class Method {
    ArrayList<Function> functions = new ArrayList<>();
    Class containingClass;
    public String name;

    public Method(ArrayList<Function> functions, String name, Class container) {
        this.functions = functions;
        this.name = name;
        this.containingClass = container;
    }

    public void execute(Class executor) {
        Object staticReference = (Object) executor;
        if (executor instanceof Variable) {
            staticReference = ((Object) CustomClasses.getClassByName(((Variable) executor).varName));
        }
    }
}
