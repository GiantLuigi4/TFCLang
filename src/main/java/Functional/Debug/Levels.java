package Functional.Debug;

public enum Levels {
    Generic(""),
    Debug(Colors.BLUE),
    Init(Colors.CYAN),
    Info(Colors.GREEN),
    WARN(Colors.RED_BRIGHT),
    ERROR(Colors.RED);
    String color;

    Levels(String color) {
        this.color=color;
    }
}
