package Functional.ClassContext;

public class JavaClasses {
    public static Class getClassByName(String name) {
        try {
            return Class.forName(name);
        } catch (Exception err) {
            return null;
        }
    }
    //TODO find all classes that include a set string.
}
