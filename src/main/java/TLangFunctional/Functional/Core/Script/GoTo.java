package TLangFunctional.Functional.Core.Script;

public class GoTo {
    public boolean shouldGoTo = false;
    public int line = 0;

    public GoTo() {
    }

    public GoTo(int line) {
        this.shouldGoTo = true;
        this.line = line;
    }
}
