package com.bb.hackerRank.solutionTester;

import java.util.Scanner;

public class StaticInitializerBlockSolution {
    private static boolean flag;
    private static int B;
    private static int H;

    static {
        try {
            parseInput();
            validateInput();
        } catch (Exception e) {
            System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
        }
    }

    private static void parseInput() {
        Scanner scanner = new Scanner(System.in);
        B = scanner.nextInt();
        H = scanner.nextInt();
    }

    private static void validateInput() throws Exception {
        if (B > 0 && H > 0) {
            flag = true;
        } else {
            throw new Exception("Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
