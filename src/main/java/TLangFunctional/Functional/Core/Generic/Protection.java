package TLangFunctional.Functional.Core.Generic;

public enum Protection {
    PUBLIC("public");
    String level;

    Protection(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level;
    }
}
