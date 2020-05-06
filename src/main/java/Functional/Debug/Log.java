package Functional.Debug;

import Functional.Core.Package;

import java.util.Date;

public class Log {
    String pref;
    String suf;
    boolean printTime;
    private Log(String prefix,boolean logTime,String suffix) {
        pref=prefix;
        printTime=logTime;
        suf=suffix;
    }
    public static Log createLogger(Package pack) {
        return new Log("+["+pack+"]:",true,"||");
    }
    public static Log createTimelessLogger(Package pack) {
        return new Log("+["+pack+"]:[",false,"]||");
    }
    public void print(Levels level,String message) {
        Date dte=new Date();
        System.out.println(level.color+pref+(dte.getMonth()+"/"+dte.getDate()+"/"+dte.getYear()+"|"+dte.getHours()+":"+dte.getMinutes()+":"+dte.getSeconds())+suf+message);
    }
    public void print(String color,String message) {
        Date dte=new Date();
        System.out.println(color+pref+(dte.getMonth()+"/"+dte.getDate()+"/"+dte.getYear()+"|"+dte.getHours()+":"+dte.getMinutes()+":"+dte.getSeconds())+suf+message);
    }
}
