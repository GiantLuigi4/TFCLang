package Functional.Core;

import java.util.ArrayList;

public class Variable extends Class {
    public String varName;
    public String varClass;
    public boolean hidden;

    public Variable(Class clazz, String name) {
        super(clazz.isJavaNative, clazz.methods, clazz.staticMethods, clazz.javaClassIfPresent, clazz.vars, clazz.staticVars, clazz.getName(), clazz.pack);
        this.varName = name;
        this.varClass = clazz.getName();
        staticMethods = (Method[]) new ArrayList<Method>().toArray();
        staticVars = (Variable[]) new ArrayList<Variable>().toArray();
    }
    public Variable(Class clazz, String name,boolean hidden) {
        super(clazz.isJavaNative, clazz.methods, clazz.staticMethods, clazz.javaClassIfPresent, clazz.vars, clazz.staticVars, clazz.getName(), clazz.pack);
        this.varName = name;
        this.varClass = clazz.getName();
        this.hidden=hidden;
        staticMethods = (Method[]) new ArrayList<Method>().toArray();
        staticVars = (Variable[]) new ArrayList<Variable>().toArray();
    }
}
