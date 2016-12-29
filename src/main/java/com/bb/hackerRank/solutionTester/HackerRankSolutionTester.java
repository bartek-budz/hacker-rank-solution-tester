package com.bb.hackerRank.solutionTester;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class HackerRankSolutionTester {
    private static final String MAIN_METHOD = "main";
    private static final String[] NO_ARGUMENTS = {};
    private static final boolean NORMALIZE_LINE_SEPARATORS_BY_DEFAULT = true;
    private static final boolean TRIM_OUTPUT_BY_DEFAULT = true;

    private Class solution;
    private boolean normalizeLineSeparators = NORMALIZE_LINE_SEPARATORS_BY_DEFAULT;
    private boolean trimOutput = TRIM_OUTPUT_BY_DEFAULT;

    public HackerRankSolutionTester(Class solution) {
        this.solution = solution;
    }

    public void setTrimOutput(boolean value) {
        this.trimOutput = value;
    }

    public void setNormalizeLineSeparators(boolean normalizeLineSeparators) {
        this.normalizeLineSeparators = normalizeLineSeparators;
    }

    /**
     * Executes the main method from the tested class
     * Simulates the user input and reads the console output
     *
     * @param input user input to be passed to System.in
     * @return system output read from System.out
     * @exception  UnsupportedOperationException if the class does not have the main method
     * @exception UndeclaredThrowableException if the main method throws an exception
     */
    public String testMain(String input) {
        return testMain(input, NO_ARGUMENTS);
    }

    public String testMain(String input, String[] args)
    {
        try {
            OutputStream out = setCustomIO(input);
            invokeMain(args);
            return getSystemOutput(out);
        }
        finally {
            restoreSystemIO();
        }
    }

    private OutputStream setCustomIO(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        return out;
    }

    private Object invokeMain(String[] args) {
        try {
            Method main = solution.getMethod(MAIN_METHOD, String[].class);
            return main.invoke(null, (Object) args);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new UnsupportedOperationException(e);
        }
        catch (InvocationTargetException e)
        {
            throw new UndeclaredThrowableException(e);
        }
    }

    private String getSystemOutput(OutputStream out) {
        String output = out.toString();
        if(normalizeLineSeparators) output = output.replaceAll("\\r\\n?", "\n");
        if(trimOutput) output = output.trim();
        return output;
    }

    private void restoreSystemIO() {
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
