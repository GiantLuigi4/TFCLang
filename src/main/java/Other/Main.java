package Other;

import Functional.Core.Class;
import Functional.Core.Package;
import Functional.Debug.Colors;
import Functional.Debug.Levels;
import Functional.Debug.Log;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;

public class Main extends JComponent {
    public static Log TLangDebug=Log.createLogger(new Package("Java.TLang.Main"));
    public static void main(String[] args) {
        TLangDebug.print(Levels.Info,"All Debug Levels\n");
        TLangDebug.print(Levels.Generic,"generic");
        TLangDebug.print(Levels.Debug,"debug");
        TLangDebug.print(Levels.Init,"init");
        TLangDebug.print(Levels.Info,"info");
        TLangDebug.print(Levels.WARN,"warn");
        TLangDebug.print(Levels.ERROR,"error\n");
        while (true) {
        }
    }
}
