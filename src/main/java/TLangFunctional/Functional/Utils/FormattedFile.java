package TLangFunctional.Functional.Utils;

import TLangFunctional.Functional.Core.Generic.Protection;

import java.util.ArrayList;

public class FormattedFile {
    private String[] lines;

    private FormattedFile(String[] lines) {
        this.lines = lines;
    }

    public static FormattedFile createFormatter(String[] lines) {
        return new FormattedFile(lines).simplify();
    }

    private FormattedFile simplify() {
        int i;
        ArrayList<String> newLines = new ArrayList<>();
        ArrayList<String> newLines1 = new ArrayList<>();
        String parsingLine = "";
        boolean readingClass = false;
        for (i = 0; i < lines.length; i++) {
            if (!readingClass) {
                for (Protection prot : Protection.values()) {
                    if (lines[i].startsWith(prot.toString())) {
                        readingClass = true;
                        newLines1.add(lines[i]);
                    }
                }
                if (!readingClass) {
                    newLines1.add(lines[i]);
                }
            } else {
                if (!lines[i].contains(";")) {
                    parsingLine += lines[i];
                } else {
                    if (lines[i].contains(";")) {
                        for (String s : lines[i].split(";")) {
                            parsingLine += s;
                            newLines1.add(parsingLine);
                            parsingLine = "";
                        }
                    }
                }
            }
        }
        newLines1.add(parsingLine);
        for (String line : newLines1) {
            if (line.contains("{") || line.contains("}")) {
                String newLine = "";
                for (char c : line.toCharArray()) {
                    if (c != '{' && c != '}') {
                        newLine += c;
                    } else {
                        newLine += c;
                        newLines.add(newLine);
                        newLine = "";
                    }
                }
            } else {
                newLines.add(line);
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
        }
        return this;
    }

    @Override
    public String toString() {
        String strng = "";
        for (String string : lines) {
            strng += string + "\n";
        }
        return strng;
    }

    public String toSingleLine() {
        String strng = "";
        for (String string : lines) {
            strng += string;
        }
        return strng;
    }
}
