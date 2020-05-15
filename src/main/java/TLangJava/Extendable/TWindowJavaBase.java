package TLangJava.Extendable;

import TLangFunctional.Functional.Core.Class.Class;
import TLangFunctional.Functional.Utils.Interface.TLangExtendable;

import java.awt.*;

public class TWindowJavaBase extends java.awt.Frame implements TLangExtendable {
	public Class clazz = null;
	
	public TWindowJavaBase() throws HeadlessException {
	}
	
	public TWindowJavaBase(GraphicsConfiguration gc) {
		super(gc);
	}
	
	public TWindowJavaBase(String title) throws HeadlessException {
		super(title);
	}
	
	public TWindowJavaBase(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}
	
	@Override
	public Class getInstance() {
		return clazz;
	}
	
	@Override
	public Class setInstance(Class clazz) {
		this.clazz = clazz;
		return clazz;
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			TLangExtendable.execute("Draw", new Object[]{g}, new String[]{"g"}, this);
		} catch (Exception err) {
			super.paint(g);
		}
	}
}
