package Functional;

public class Variable extends Class {
    public String varName;

    public Variable(Class clazz, String name) {
        super(clazz.isJavaNative, clazz.methods, clazz.staticMethods, clazz.javaClassIfPresent, clazz.vars, clazz.staticVars, clazz.getName(), clazz.pack);
        this.varName = name;
    }
}
