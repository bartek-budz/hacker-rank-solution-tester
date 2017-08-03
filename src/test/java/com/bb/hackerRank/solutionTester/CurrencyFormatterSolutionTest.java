package com.bb.hackerRank.solutionTester;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CurrencyFormatterSolutionTest {
    private final static String INPUT = "12324.134";
    private final static String EXPECTED = "US: $12,324.13\nIndia: Rs.12,324.13\nChina: ￥12,324.13\nFrance: 12 324,13 €";

    @Test
    public void shouldReturnExpectedOutput() throws Exception {
        String actual = new HackerRankSolutionTester(CurrencyFormatterSolution.class).testMain(INPUT);
        assertEquals(EXPECTED, actual);
    }

    @Test
    void shouldFailAssertionDueToNonBreakingSpace() {
        HackerRankSolutionTester tester = new HackerRankSolutionTester(CurrencyFormatterSolution.class);
        tester.getOutputCleaner().setClearNonBreakingSpaces(false);
        String actualOutput = tester.testMain(INPUT);
        assertNotEquals(EXPECTED, actualOutput);
    }
}