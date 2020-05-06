package TLangFunctional.Functional.Core.Class;

import TLangFunctional.Functional.ClassContext.JavaClasses;

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
        public boolean equals(java.lang.Object obj) {
            try {
                return obj.getClass().getField("name").get(obj).equals(name);
            } catch (Exception err) {
            }
            return this.name.equals(obj.toString());
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
