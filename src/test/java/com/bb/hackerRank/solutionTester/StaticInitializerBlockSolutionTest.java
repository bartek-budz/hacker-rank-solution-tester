package com.bb.hackerRank.solutionTester;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaticInitializerBlockSolutionTest {
    @Test
    public void testCase0() throws Exception {
        final String input = "1\n3";
        final String expected = "3";
        String actual = new HackerRankSolutionTester(StaticInitializerBlockSolution.class).testMain(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase1() throws Exception {
        final String input = "-1\n2";
        final String expected = "java.lang.Exception: Breadth and height must be positive";
        String actual = new HackerRankSolutionTester(StaticInitializerBlockSolution.class).testMain(input);
        assertEquals(expected, actual);
    }

}