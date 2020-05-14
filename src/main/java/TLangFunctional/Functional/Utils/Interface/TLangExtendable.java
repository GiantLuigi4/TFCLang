package TLangFunctional.Functional.Utils.Interface;

import TLangFunctional.Functional.ClassContext.CustomClasses;
import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Core.Class.Variable;

public interface TLangExtendable {
	static Object execute(String name, Object[] args, String[] argsNames, java.lang.Class clazz) {
		Variable[] vars = new Variable[args.length];
		int i = 0;
		for (Object arg : args) {
			vars[i] = new Variable(arg.getClass(), argsNames[i], false, arg);
			i++;
		}
		try {
			return CustomClasses.executeMethod(
					new Class(true, clazz),
					new Variable(new Class(true, clazz), clazz.getName()),
					vars,
					name).JavaValue;
		} catch (Exception err) {
			throw new RuntimeException(new NoTLangMethod("Could not find a TLang Method by name:" + name));
		}
	}
}
