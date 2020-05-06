package TLangFunctional.Errors;

import java.io.PrintStream;
import java.io.PrintWriter;

public class IllegalClassMergeException extends Exception {
    public IllegalClassMergeException() {
    }

    public IllegalClassMergeException(String message) {
        super(message);
    }

    public IllegalClassMergeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalClassMergeException(Throwable cause) {
        super(cause);
    }

    public IllegalClassMergeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        super.setStackTrace(stackTrace);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return super.fillInStackTrace();
    }
}
