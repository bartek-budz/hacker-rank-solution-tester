package com.bb.hackerRank.solutionTester;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HelloWorldTest {
    private final String HELLO_WORLD_INPUT = "Welcome to 30 Days of Code!";
    private final String HELLO_WORLD_EXPECTED_OUTPUT = "Hello, World.\nWelcome to 30 Days of Code!";
    private HackerRankSolutionTester tester;

    @Test
    void shouldReturnExpectedOutput() {
        HackerRankSolutionTester tester = new HackerRankSolutionTester(HelloWorldSolution.class);
        String actualOutput = tester.testMain(HELLO_WORLD_INPUT);
        assertEquals(HELLO_WORLD_EXPECTED_OUTPUT, actualOutput);
    }

    @Test
    void shouldFailAssertionDueToNewLineAtTheEnd() {
        HackerRankSolutionTester tester = new HackerRankSolutionTester(HelloWorldSolution.class);
        tester.setTrimOutput(false);
        String actualOutput = tester.testMain(HELLO_WORLD_INPUT);
        assertNotEquals(HELLO_WORLD_EXPECTED_OUTPUT, actualOutput);
    }

    @Test
    void shouldFailAssertionDueToDiffInLineSeparators() {
        final String LINE_SEPARATOR_PROPERTY = "line.separator";
        HackerRankSolutionTester tester = new HackerRankSolutionTester(HelloWorldSolution.class);
        tester.setNormalizeLineSeparators(false);
        String lineSeparatorBackup = System.lineSeparator();
        try {
            System.setProperty(LINE_SEPARATOR_PROPERTY, "\r\n");
            String actualOutput = tester.testMain(normalizeLineSeparators(HELLO_WORLD_INPUT));
            assertNotEquals(normalizeLineSeparators(HELLO_WORLD_EXPECTED_OUTPUT), actualOutput);
            assertEquals(normalizeLineSeparators(HELLO_WORLD_EXPECTED_OUTPUT), normalizeLineSeparators(actualOutput));
        }
        finally {
            System.setProperty(LINE_SEPARATOR_PROPERTY, lineSeparatorBackup);
        }
    }

    private static String normalizeLineSeparators(String str) {
        return str.replaceAll("\\r\\n?", "\n");
    }
}