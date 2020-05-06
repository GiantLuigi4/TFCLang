package Functional.Utils;

import Functional.Core.Function;
import Functional.Core.Protection;

import java.util.ArrayList;

public class MethodParser {
    int currentLine = 0;
    private String[] lines;

    private MethodParser(String[] lines) {
        this.lines = lines;
    }

    public static MethodParser createMethodParser(String[] lines) {
        return new MethodParser(lines).simplify();
    }

    private MethodParser simplify() {
//        try {
        int i;
        ArrayList<String> newLines = new ArrayList<>();
        String parsingLine = "";
        boolean readingClass = false;
        for (i = 0; i < lines.length; i++) {
            if (!readingClass) {
                for (Protection prot : Protection.values()) {
                    if (lines[i].startsWith(prot.toString())) {
                        readingClass = true;
                    }
                }
                if (!readingClass) {
                    newLines.add(lines[i]);
                }
            } else {
                if (!lines[i].contains(";")) {
                    parsingLine += lines[i];
                } else {
                    if (lines[i].contains(";")) {
                        for (String s : lines[i].split(";")) {
                            parsingLine += lines[i];
                            newLines.add(parsingLine);
                            parsingLine = "";
                        }
                    }
                }
            }
        }
        lines = new String[newLines.size()];
        String newString;
        boolean hitText;
        boolean hitComment;
        for (int c = 0; c < newLines.size(); c++) {
            hitText = false;
            hitComment = false;
            newString = "";
            char prevChar = ' ';
            for (char c2 : newLines.get(c).toCharArray()) {
                if (c2 == '\\') {
                    hitComment = !hitComment;
                }
                if (c2 != ' ' && !(hitComment || c2 == '\\')) {
                    hitText = true;
                }
                if (hitText && !(hitComment || c2 == '\\')) {
                    newString += c2;
                }
                if (c2 == prevChar && c2 == '\\' && !hitComment) {
                    newString += c2;
                }
                prevChar = c2;
            }
            lines[c] = newString;
//                lines[c]=newLines.get(c);
        }
//        Main.TLangDebug.print(Levels.Debug,lines.length);
//        } catch (Exception err) {}
        return this;
    }

    public Function nextLine() {
        Function func = new Function(lines[currentLine]);
        currentLine++;
        return func;
    }

    public boolean hasNext() {
        return currentLine < lines.length;
    }
}
