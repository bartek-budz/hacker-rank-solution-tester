package com.bb.hackerRank.solutionTester;

import java.io.OutputStream;

public class OutputCleaner {
    private static final String NON_BREAKING_SPACE = String.valueOf((char) 160);

    private static final boolean CLEAR_NON_BREAKING_SPACE = true;
    private static final boolean NORMALIZE_LINE_SEPARATORS_BY_DEFAULT = true;
    private static final boolean TRIM_OUTPUT_BY_DEFAULT = true;

    private boolean clearNonBreakingSpace = CLEAR_NON_BREAKING_SPACE;
    private boolean normalizeLineSeparators = NORMALIZE_LINE_SEPARATORS_BY_DEFAULT;
    private boolean trimOutput = TRIM_OUTPUT_BY_DEFAULT;

    public void setClearNonBreakingSpaces(boolean value) {
        this.clearNonBreakingSpace = value;
    }

    public void setNormalizeLineSeparators(boolean value) {
        this.normalizeLineSeparators = value;
    }

    public void setTrimOutput(boolean value) {
        this.trimOutput = value;
    }

    public String cleanOutput(OutputStream out) {
        String output = out.toString();
        if(clearNonBreakingSpace) output = output.replace(NON_BREAKING_SPACE, " ");
        if(normalizeLineSeparators) output = output.replaceAll("\\r\\n?", "\n");
        if(trimOutput) output = output.trim();
        return output;
    }
}
