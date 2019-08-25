package org.flys.cg.util;

import java.util.ArrayList;
import java.util.List;

public class JujubeIde implements Ide {
    private List<String> lines;
    private boolean indent;

    public JujubeIde() {
        lines = new ArrayList<>();
    }

    @Override
    public String println(String code) {
        indentation(code);
        if (indent) {
            lines.add("\t");
        }

        return null;
    }

    private void indentation(String code) {
        if (code.endsWith("{")) {
            indent = true;
        } else {
            indent = false;
        }
    }
}
