package Functional.Core;

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
