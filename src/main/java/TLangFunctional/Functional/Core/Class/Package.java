package TLangFunctional.Functional.Core.Class;

public class Package {
    private String space;

    public Package(String space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return space;
    }

    public static Package parsePackage(String namespace,String import1) {
        return new Package(namespace.substring(1)+import1.substring("import:".length()));
    }
}
