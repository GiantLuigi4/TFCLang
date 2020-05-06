package TLangFunctional.Functional.Core.Script;

public class GoTo {
    boolean shouldGoTo = false;
    int line = 0;

    public GoTo() {
    }

    public GoTo(int line) {
        this.shouldGoTo = true;
        this.line = line;
    }
}
