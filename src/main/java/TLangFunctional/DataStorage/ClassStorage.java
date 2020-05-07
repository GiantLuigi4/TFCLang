package TLangFunctional.DataStorage;

import TLangFunctional.Functional.Core.Class.Class;

import java.util.ArrayList;

public class ClassStorage {
    public static ArrayList<Class> classes = new ArrayList<>();
    
    public static void AddClass(Class clazz) {
        classes.add(clazz);
    }
}
