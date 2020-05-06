package Other;

import Functional.Core.Package;
import Functional.Debug.Levels;
import Functional.Debug.Log;

import javax.swing.*;

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
        while (true) {
        }
    }
}
