package TLangFunctional.Functional.Core.Class;

import TLangFunctional.Errors.IllegalClassMergeException;
import TLangFunctional.Functional.ClassContext.CustomClasses;
import TLangFunctional.Functional.Core.Script.Method;
import TLangFunctional.Functional.Debug.Log.Log;
import TLangFunctional.Functional.Utils.VariableFinder;

import java.util.ArrayList;

public class Class {
    public boolean isJavaNative = false;
    public Method[] methods;
    public Method[] staticMethods;
    public java.lang.Class javaClassIfPresent;
    public Variable[] vars;
    public Variable[] staticVars;
    public String name;
    public Package pack;
    public Class[] inheritance;
    public String castedFrom = "";
    public ArrayList<Import> imports;

    public Class(boolean isJavaNative, Method[] methods, Method[] staticMethods, java.lang.Class javaClassIfPresent, Variable[] vars, Variable[] staticVars, String name, Package pack) {
        this.isJavaNative = isJavaNative;
        this.methods = methods;
        this.staticMethods = staticMethods;
        this.javaClassIfPresent = javaClassIfPresent;
        this.vars = vars;
        this.staticVars = staticVars;
        this.name = name;
        this.pack = pack;
    }

    public Class(boolean isJavaNative, Method[] methods, Method[] staticMethods, java.lang.Class javaClassIfPresent, Variable[] vars, Variable[] staticVars, String name, Package pack, Class... inheritance) {
        this(isJavaNative, methods, staticMethods, javaClassIfPresent, vars, staticVars, name, pack);
        ArrayList<Class> inherited = new ArrayList<>();
        for (Class inherit : inheritance) {
            inherited.add(inherit);
        }
        inherited.add(new Object());
        this.inheritance = (Class[]) inherited.toArray();
    }

    public Class(boolean isJavaNative, java.lang.Class javaClassIfPresent) {
        this.pack = new Package(javaClassIfPresent.toString());
        this.isJavaNative = isJavaNative;
        this.javaClassIfPresent = javaClassIfPresent;
    }

    public void setImports(ArrayList<Import> imports1) {
        imports = imports1;
    }

    public void addImport(Import import1) {
        imports.add(import1);
    }

    public Class() {
    }

    public static Log getLogForClass(Class T) {
        return Log.createLogger(new Package(T.name));
    }

    public Variable getVariableByName(String name) {
        return VariableFinder.findVar(name, vars);
    }

    public Variable getStaticVariableByName(String name) {
        return VariableFinder.findVar(name, staticVars);
    }

    public Variable setVariable(String name,Variable value) {
        for (int i=0;i<vars.length;i++) {
            if (vars[i].name.equals(name)) {
                if (!(vars[i].varClass.equals(value.varClass))) {
                    throw new RuntimeException(new ClassCastException("Could not cast:"+value.name+"to a:"+vars[i].varClass));
                }
                Variable old=vars[i];
                vars[i]=value;
                return old;
            }
        }
        throw new RuntimeException(new NullPointerException("Could not find a variable matching the name:"+value));
    }

    public Variable setStaticVariable(String name) {
        return VariableFinder.findVar(name, staticVars);
    }

    public boolean instanceOf(Class clazz) {
        boolean indirectlyExtended = false;
        for (Class clz : getClassesExtended()) {
            for (Class clz1 : clazz.getClassesExtended()) {
                if (clz.getName().equals(clz1.getName())) {
                    return true;
                }
            }
            indirectlyExtended = clz.instanceOf(clazz) || indirectlyExtended;
        }
        return indirectlyExtended;
    }

    public Class[] getClassesExtended() {
        return inheritance;
    }

    public Class cast(Object obj) {
        if (!(obj instanceof Object)) {
            throw new RuntimeException(new IllegalClassMergeException("Cannot cast non TLang class:" + obj.getClass() + " to:" + getName()));
        }
        Class clazz = CustomClasses.getClassByName(this.getName());
        if (!(instanceOf(clazz))) {
            throw new RuntimeException(new IllegalClassMergeException("Cannot cast class:" + clazz.getName() + " to:" + getName()));
        }
        return clazz.cast(getName(), staticVars);
    }

    public Class merge(java.lang.Object obj) {
        if (!(obj instanceof Object)) {
            throw new RuntimeException(new IllegalClassMergeException("Cannot merge class with non TLang class:" + obj.getClass()));
        }
        Class clazz = CustomClasses.getClassByName(this.getName());
        return clazz.merge(this.methods, this.staticMethods, this.vars, this.staticVars, getName());
    }

    private Class cast(String name, Variable[] staticVars) {
        return new Class(false, methods, staticMethods, null, vars, staticVars, name, new Package(""));
    }

    private Class merge(Method[] methods, Method[] staticMethods, Variable[] vars, Variable[] staticVars, String name) {
        ArrayList<Method> methods1 = new ArrayList<>();
        ArrayList<Method> staticMethods1 = new ArrayList<>();
        ArrayList<Variable> vars1 = new ArrayList<>();
        ArrayList<Variable> staticVars1 = new ArrayList<>();
        for (Method method : methods) {
            for (Method method1 : this.methods) {
                if (!method.name.equals(method1.name)) {
                    methods1.add(method);
                }
            }
        }
        for (Method method : staticMethods) {
            for (Method method1 : this.staticMethods) {
                if (!method.name.equals(method1.name)) {
                    staticMethods1.add(method);
                }
            }
        }
        for (Variable var : vars) {
            for (Variable var1 : this.vars) {
                if (!var.name.equals(var1.name)) {
                    vars1.add(var);
                }
            }
        }
        for (Variable var : staticVars) {
            for (Variable var1 : this.staticVars) {
                if (!var.name.equals(var1.name)) {
                    staticVars1.add(var);
                }
            }
        }
        return new Class(false, (Method[]) methods1.toArray(), (Method[]) staticMethods1.toArray(), null, (Variable[]) vars1.toArray(), (Variable[]) staticVars1.toArray(), getName() + name, new Package(""));
    }

    protected java.lang.Class getJavaClass() {
        return javaClassIfPresent;
    }

    public String getName() {
        return pack + name;
    }

    public String getUncastedClass() {
        return castedFrom;
    }

    public static class JavaNativeClass extends Class {
        public JavaNativeClass(java.lang.Class clazz) {
            super(true, clazz);
            isJavaNative = true;
        }

        public java.lang.Object cast(java.lang.Object obj) {
            return getJavaClass().cast(obj);
        }

        @Override
        public String getName() {
            return getJavaClass().toString();
        }

        public java.lang.Class getJavaNative() {
            return javaClassIfPresent;
        }
    }
}
