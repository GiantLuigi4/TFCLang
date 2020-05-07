package Editor;

import TLangFunctional.Functional.ClassContext.JavaClasses;
import TLangFunctional.Functional.Core.Class.Variable;
import TLangFunctional.Functional.Debug.Log.LogLevel;

import javax.swing.*;
import java.awt.*;

import static Editor.Main.TLangDebug;

public class test extends Component {
    public Variable i = new Variable(JavaClasses.getClassByName("java.lang.Double"), "i", false, 0d);

    public static void main(String[] args) {
        TLangDebug.print(LogLevel.Info, "All Debug Levels\n");
        TLangDebug.print(LogLevel.Generic, "generic");
        TLangDebug.print(LogLevel.Debug, "debug");
        TLangDebug.print(LogLevel.Init, "init");
        TLangDebug.print(LogLevel.Info, "info");
        TLangDebug.print(LogLevel.WARN, "warn");
        TLangDebug.print(LogLevel.ERROR, "error\n");
        Frame frame = new JFrame();
        Variable[] vars = new Variable[]{
                new Variable(Integer.class, "x", false, 200),
                new Variable(Integer.class, "y", false, 200)
        };
        Variable[] vars2 = new Variable[]{
                new Variable(Boolean.class, "shown", false, true)
        };
        Variable[] vars3 = new Variable[]{
                new Variable(Float.class, "opacity", false, 1)
        };
        Variable[] vars6 = new Variable[]{
                new Variable(test.class, "component", false, new test())
        };
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setSize", vars, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setUndecorated", vars2, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setOpacity", vars3, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "add", vars6, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setVisible", vars2, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "move", vars, frame);
        Variable[] vars4 = new Variable[]{
        };
        Variable[] vars7 = new Variable[]{
                new Variable(Integer.class, "time", false, 100)
        };
        while ((boolean) JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "isVisible", vars4, frame)) {
            JavaClasses.executeJavaFunction(JavaClasses.getClassByName(vars6[0].varClass), "repaint", vars4, vars6[0].JavaValue);
            JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.lang.Thread"), "sleep", vars7, null);
        }
        Variable[] vars5 = new Variable[]{
                new Variable(Integer.class, "code", false, 0)
        };
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.lang.Runtime"), "exit", vars5, JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.lang.Runtime"), "getRuntime", vars4, null));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Variable[] vars = new Variable[]{
                new Variable(String.class, "text", false, "Close to end task."),
                new Variable(Integer.class, "x", false, 2),
                new Variable(Integer.class, "y", false, 15)
        };
        Variable[] vars2 = new Variable[]{
                new Variable(String.class, "text", false, "(Click this then press Alt+F4)"),
                new Variable(Integer.class, "x", false, 2),
                new Variable(Integer.class, "y", false, 30)
        };
        g.setColor(new Color(0x969696));
        Variable[] vars3 = new Variable[]{
                new Variable(int.class, "x1", false, Math.abs((int) (Math.cos((double) i.JavaValue) * 200))),
                new Variable(int.class, "y1", false, 0),
                new Variable(int.class, "x2", false, Math.abs((int) (Math.sin((double) i.JavaValue) * 200))),
                new Variable(int.class, "y2", false, 200)
        };
        Variable[] vars4 = new Variable[]{
                new Variable(int.class, "x1", false, Math.abs((int) (Math.cos(((double) i.JavaValue) - 0.01) * 200))),
                new Variable(int.class, "y1", false, 0),
                new Variable(int.class, "x2", false, Math.abs((int) (Math.sin(((double) i.JavaValue) - 0.01) * 200))),
                new Variable(int.class, "y2", false, 200)
        };
        Variable[] vars5 = new Variable[]{
                new Variable(int.class, "x1", false, Math.abs((int) (Math.cos(((double) i.JavaValue) + 0.01) * 200))),
                new Variable(int.class, "y1", false, 0),
                new Variable(int.class, "x2", false, Math.abs((int) (Math.sin(((double) i.JavaValue) + 0.01) * 200))),
                new Variable(int.class, "y2", false, 200)
        };
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawLine", vars3, g);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawLine", vars4, g);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawLine", vars5, g);
        g.setColor(new Color(0));
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawString", vars, g);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawString", vars2, g);
        i.JavaValue = ((Double) i.JavaValue) + 0.01D;
    }
}
