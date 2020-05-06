package Functional.Utils;

import Functional.Core.Function;

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
        int i;
        ArrayList<String> newLines = new ArrayList<>();
        String parsingLine = "";
        for (i = 0; i < lines.length; i++) {
            if (!lines[i].contains(";")) {
                parsingLine += lines[i];
            } else {
                for (String s : lines[i].split(";")) {
                    parsingLine += lines[i];
                    newLines.add(parsingLine);
                    parsingLine = "";
                }
            }
        }
        String[] newLinesArray = (String[]) newLines.toArray();
        return this;
    }

    public Function nextLine() {
        Function func = new Function(lines[currentLine]);
        currentLine++;
        return func;
    }

    public boolean hasNext() {
        return lines.length < currentLine;
    }
}
