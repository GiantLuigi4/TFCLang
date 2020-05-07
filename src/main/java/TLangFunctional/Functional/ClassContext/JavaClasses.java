package TLangFunctional.Functional.ClassContext;

import TLangFunctional.Functional.Core.Class.Variable;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class JavaClasses {
    public static java.lang.Class getClassByName(String name) {
        try {
            return java.lang.Class.forName(name);
        } catch (Exception err) {
            return null;
        }
    }

    public static Object executeJavaFunction(java.lang.Class clazz, String method, Variable[] vars, Object executingObject) {
        ArrayList<Method> allMethods = new ArrayList<>();
        RuntimeException err1 = null;
        try {
            Method[] methods = clazz.getDeclaredMethods();
            allMethods.addAll(Arrays.asList(methods));
        } catch (Exception err) {
        }
        try {
            Method[] methods = clazz.getMethods();
            allMethods.addAll(Arrays.asList(methods));
        } catch (Exception err) {
        }
        try {
            Method[] methods = executingObject.getClass().getDeclaredMethods();
            allMethods.addAll(Arrays.asList(methods));
        } catch (Exception err) {
        }
        try {
            Method[] methods = executingObject.getClass().getMethods();
            allMethods.addAll(Arrays.asList(methods));
        } catch (Exception err) {
        }
        try {
            allMethods.add(clazz.getEnclosingMethod());
        } catch (Exception err) {
        }
        try {
            allMethods.add(executingObject.getClass().getEnclosingMethod());
        } catch (Exception err) {
        }
        for (Method method1 : allMethods) {
            boolean canBeCorrect = true;
            ArrayList<Object> objects = new ArrayList<>();
            try {
                if (method1.getName().equals(method)) {
                    int i = 0;
                    if (vars.length == method1.getParameterCount()) {
                        for (Variable var : vars) {
                            objects.add(var.JavaValue);
                            i++;
                        }
                    } else {
                        canBeCorrect = false;
                    }
                } else {
                    canBeCorrect = false;
                }
                if (canBeCorrect) {
                    try {
                        if (objects.size() == 0) {
                            return method1.invoke(executingObject);
                        }
                        return invoke(method1, objects, executingObject);
                    } catch (RuntimeException err) {
                        err1 = err;
                    } catch (Exception err) {
                        err1 = new RuntimeException(err);
                    }
                }
            } catch (Exception err) {
            }
        }
        throw err1;
    }

    public static Object invoke(Method method1, ArrayList<Object> objects, Object executingObject) {
        RuntimeException err1 = null;
        try {
            if (objects.size() == 1) {
                return method1.invoke(executingObject,
                        objects.get(0));
            } else if (objects.size() == 2) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1));
            } else if (objects.size() == 3) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1),
                        objects.get(2));
            } else if (objects.size() == 4) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1),
                        objects.get(2),
                        objects.get(3));
            } else if (objects.size() == 5) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1),
                        objects.get(2),
                        objects.get(3),
                        objects.get(4));
            } else if (objects.size() == 6) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1),
                        objects.get(2),
                        objects.get(3),
                        objects.get(4),
                        objects.get(5));
            } else if (objects.size() == 7) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1),
                        objects.get(2),
                        objects.get(3),
                        objects.get(4),
                        objects.get(5),
                        objects.get(6));
            } else if (objects.size() == 8) {
                return method1.invoke(executingObject,
                        objects.get(0),
                        objects.get(1),
                        objects.get(2),
                        objects.get(3),
                        objects.get(4),
                        objects.get(5),
                        objects.get(6),
                        objects.get(7));
            }
        } catch (Exception err) {
            try {
                return method1.invoke(executingObject, null);
            } catch (Exception err2) {
                err1 = new RuntimeException(err);
            }
        }
        throw err1;
    }
    //TODO find all classes that include a set string.
}
