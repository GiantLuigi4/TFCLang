package Other;

import Functional.ClassContext.JavaClasses;
import Functional.Core.Package;
import Functional.Core.Variable;
import Functional.Debug.Levels;
import Functional.Debug.Log;

import javax.swing.*;
import java.awt.*;

public class Main extends Component {
    public static Log TLangDebug = Log.createLogger(new Package("Java.TLang.Main"));

    public Variable i = new Variable(JavaClasses.getClassByName("java.lang.Double"), "i", false, 0d);

    public static void main(String[] args) {
        TLangDebug.print(Levels.Info,"All Debug Levels\n");
        TLangDebug.print(Levels.Generic,"generic");
        TLangDebug.print(Levels.Debug,"debug");
        TLangDebug.print(Levels.Init,"init");
        TLangDebug.print(Levels.Info,"info");
        TLangDebug.print(Levels.WARN,"warn");
        TLangDebug.print(Levels.ERROR,"error\n");
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
                new Variable(Main.class, "component", false, new Main())
        };
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setSize", vars, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setUndecorated", vars2, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setOpacity", vars3, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "add", vars6, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "setVisible", vars2, frame);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.JFrame"), "move", vars, frame);
//        try {
//            Scanner sc=new Scanner(new File([DirectoryHere]));
//            ArrayList<String> strings = new ArrayList<>();
//            while (sc.hasNext()) {
//                strings.add(sc.nextLine());
//            }
//            String[] strings1=new String[strings.size()];
//            for (int i=0;i<strings.size();i++) {
//                strings1[i]=strings.get(i);
//            }
//            MethodParser parser=
//                    MethodParser
//                    .createMethodParser(
//                            strings1
//                    );
//            TLangDebug.print(Levels.Debug,""+strings1.length);
//            TLangDebug.print(Levels.Debug,""+parser.hasNext());
//            while (parser.hasNext()) {
//                TLangDebug.print(Levels.Debug,parser.nextLine().line);
//            }
//        } catch (Exception err) {
//            err.printStackTrace();
//            String stackTrace=err.getCause()+"\n";
//            for (StackTraceElement element:err.getStackTrace()) {
//                stackTrace+=element+"\n";
//            }
//            TLangDebug.print(Levels.ERROR,stackTrace);
//        }
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
//        g.fillRect((int)vars3[0].JavaValue,(int)vars3[1].JavaValue,(int)vars3[2].JavaValue,(int)vars3[3].JavaValue);
        g.setColor(new Color(0));
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawString", vars, g);
        JavaClasses.executeJavaFunction(JavaClasses.getClassByName("java.awt.Graphics"), "drawString", vars2, g);
        i.JavaValue = ((Double) i.JavaValue) + 0.01D;
    }
}
