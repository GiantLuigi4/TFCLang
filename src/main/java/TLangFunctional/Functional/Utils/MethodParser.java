package TLangFunctional.Functional.Utils;

import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Core.Generic.Protection;
import TLangFunctional.Functional.Core.Script.Function;
import TLangFunctional.Functional.Core.Script.Method;

import java.util.ArrayList;

public class MethodParser {
	String toParse;
	Class clazz = null;
	
	public MethodParser(String toParse) {
		this.toParse = toParse;
	}
	
	public MethodParser(String toParse, Class clazz) {
		this.toParse = toParse;
		this.clazz = clazz;
	}
	
	public Method parse() {
		ArrayList<Function> funcs = new ArrayList<>();
		String accessLevel = "";
		String name = "";
		boolean firstLine = true;
		for (String string : toParse.split("\n")) {
			for (Protection prot : Protection.values())
				if (string.startsWith(prot.toString())) {
					accessLevel = prot.toString();
				}
			if (firstLine) {
				String s = "";
				for (char c : string.toCharArray()) {
					if (c == '(') {
						name = s;
					}
					if (c != ' ') {
						s += c;
					} else {
						s = "";
					}
				}
				firstLine = false;
			} else {
				if (!string.equals("}")) {
					funcs.add(new Function(string));
				}
			}
		}
		return new Method(funcs, name, clazz);
	}
}
