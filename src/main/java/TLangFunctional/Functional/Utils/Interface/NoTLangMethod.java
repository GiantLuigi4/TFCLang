package TLangFunctional.Functional.Utils.Interface;

public class NoTLangMethod extends Exception {
	public NoTLangMethod() {
	}
	
	public NoTLangMethod(String message) {
		super(message);
	}
	
	public NoTLangMethod(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NoTLangMethod(Throwable cause) {
		super(cause);
	}
	
	public NoTLangMethod(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
