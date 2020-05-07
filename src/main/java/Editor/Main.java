package Editor;

import TLangFunctional.Functional.Core.Class.Package;
import TLangFunctional.Functional.Debug.Log.Log;
import TLangFunctional.Functional.Debug.Log.LogLevel;
import TLangFunctional.Functional.Utils.FormattedFile;
import TLangFunctional.JarReader.Reader;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Component {
    public static Log TLangDebug = Log.createLogger(new Package("Java.TLang.Main"));
    public static File projectsDir = new File(System.getProperty("user.dir") + "\\projects");
    public static File libsDir = new File(projectsDir.getParent() + "\\" + "libs");

    public static void main(String[] args) {
        try {
            ArrayList<File> files1 = walk(libsDir, new ArrayList<>());
            for (File fi : files1) {
                Reader rdr = new Reader(fi);
                rdr.getAllFiles();
            }
            ArrayList<File> files = walk(projectsDir, new ArrayList<>());
            for (File fi : files) {
                Scanner sc = new Scanner(fi);
                ArrayList<String> strings = new ArrayList<>();
                while (sc.hasNextLine()) {
                    strings.add(sc.nextLine());
                }
                sc.close();
                String[] lines = new String[strings.size()];
                for (int i = 0; i < strings.size(); i++) {
                    lines[i] = strings.get(i);
                }
                FormattedFile formattedFile = FormattedFile.createFormatter(lines);
                TLangDebug.print(LogLevel.Init, formattedFile.toString());
            }
        } catch (Exception err) {
            projectsDir.mkdirs();
        }
    }

    public static ArrayList<File> walk(File dir, ArrayList<File> files) {
        for (File fi : dir.listFiles()) {
            TLangDebug.print(LogLevel.Init, fi.toString());
            if (!fi.isDirectory()) {
                if (fi.getPath().endsWith(".tclass")) {
                    files.add(fi);
                }
            } else {
                files = walk(fi, files);
            }
        }
        return files;
    }
}
