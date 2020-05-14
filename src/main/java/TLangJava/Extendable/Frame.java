package TLangJava.Extendable;

import TLangFunctional.Functional.Utils.Interface.TLangExtendable;

import java.awt.*;

public class Frame extends java.awt.Frame implements TLangExtendable {
	public Frame() throws HeadlessException {
	}
	
	public Frame(GraphicsConfiguration gc) {
		super(gc);
	}
	
	public Frame(String title) throws HeadlessException {
		super(title);
	}
	
	public Frame(String title, GraphicsConfiguration gc) {
		super(title, gc);
	}
	
	@Override
	public void paint(Graphics g) {
		try {
			TLangExtendable.execute("Draw", new Object[]{g}, new String[]{"g"}, this.getClass());
		} catch (Exception err) {
			super.paint(g);
		}
	}
}
