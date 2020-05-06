package Functional.ClassContext;

import DataStorage.ClassStorage;
import Functional.Core.Class;

import java.util.ArrayList;

public class CustomClasses {
    private static String currentName;
    private static int currentIndex;
    private static boolean shouldCheckFully;
    private static Class[] classesReading;

    public static Class[] getClasses() {
        return (Class[]) ClassStorage.classes.toArray();
    }

    public static Class[] getClassesByName(String name) {
        ArrayList<Class> classesMatching = new ArrayList<>();
        if (checkFirst((Class[]) ClassStorage.classes.toArray(), name, false)) {
            classesMatching.add(getClassFromIndex(currentIndex - 1));
        }
        while (hasNext()) {
            if (checkNext()) {
                classesMatching.add(getClassFromIndex(currentIndex - 1));
            }
        }
        return (Class[]) classesMatching.toArray();
    }

    public static Class getClassByName(String name) {
        ArrayList<Class> classesMatching = new ArrayList<>();
        if (checkFirst((Class[]) ClassStorage.classes.toArray(), name, true)) {
            classesMatching.add(getClassFromIndex(currentIndex - 1));
        }
        while (hasNext()) {
            if (checkNext()) {
                classesMatching.add(getClassFromIndex(currentIndex - 1));
            }
        }
        return classesMatching.get(0);
    }

    private static Boolean checkFirst(Class[] classes, String name, Boolean mustBeEqual) {
        classesReading = classes;
        currentName = name;
        currentIndex = 1;
        shouldCheckFully = mustBeEqual;
        return !shouldCheckFully ? classesReading[0].getName().contains(currentName) : classesReading[0].getName().equals(currentName);
    }

    private static Boolean checkNext() {
        Boolean returnValue = !shouldCheckFully ? classesReading[currentIndex].getName().contains(currentName) : classesReading[currentIndex].getName().equals(currentName);
        currentIndex += 1;
        return returnValue;
    }

    public static Class getClassFromIndex(int index) {
        return ClassStorage.classes.get(index);
    }

    private static boolean hasNext() {
        return currentIndex < classesReading.length;
    }
}
