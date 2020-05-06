package Functional.Core;

import java.util.ArrayList;

public class Variable extends Class {
    public String varName;
    public String varClass;
    public boolean hidden;
    public Class source;
    public java.lang.Object JavaValue;

    public Variable(Class clazz, String name) {
        super(clazz.isJavaNative, clazz.methods, clazz.staticMethods, clazz.javaClassIfPresent, clazz.vars, clazz.staticVars, clazz.getName(), clazz.pack);
        this.varName = name;
        this.varClass = clazz.getName();
        this.source = clazz;
        staticMethods = (Method[]) new ArrayList<Method>().toArray();
        staticVars = (Variable[]) new ArrayList<Variable>().toArray();
    }
    public Variable(Class clazz, String name,boolean hidden) {
        this(clazz, name);
        this.hidden=hidden;
    }

    public Variable(java.lang.Class clazz, String name, boolean hidden, java.lang.Object javaValue) {
        super(true, clazz);
        this.source = new JavaNativeClass(clazz);
        this.varName = name;
        this.hidden = hidden;
        JavaValue = javaValue;
    }
}
