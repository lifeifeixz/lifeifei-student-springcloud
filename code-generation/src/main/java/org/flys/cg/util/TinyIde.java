package org.flys.cg.util;

public class TinyIde {
    private String context;

    public TinyIde() {
        this.context = "";
    }

    public String append(String str) {
        return this.context += str;
    }

    public String appendLine(String line) {
        context = context + line + "\n";
        return context;
    }

    public String appendLineEnd(String line) {
        context = context + line + ";\n";
        return context;
    }

    @Override
    public String toString() {
        return context;
    }
}
