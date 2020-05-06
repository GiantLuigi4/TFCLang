package Functional.Core;

import Functional.ClassContext.JavaClasses;

public class Import extends Package {
    public Import(String space) {
        super(space);
    }

    public class SubImport extends Import {
        String name;

        public SubImport(String space, String name) {
            super(space);
            this.name = name;
        }

        @Override
        public String toString() {
            return super.toString() + "." + name;
        }

        public java.lang.Class getJavaClass() {
            return JavaClasses.getClassByName(this.toString());
        }
    }
}
