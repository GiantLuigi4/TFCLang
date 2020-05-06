package TLangFunctional.Functional.Debug.Log;

public enum LogLevel {
    Generic(""),
    Debug(LogColor.BLUE),
    Init(LogColor.CYAN),
    Info(LogColor.GREEN),
    WARN(LogColor.RED_BRIGHT),
    ERROR(LogColor.RED);
    String color;

    LogLevel(String color) {
        this.color=color;
    }
}
