# Hacker Rank Solution Tester
Simple Java library for testing your HackerRank.com solutions in your favorite IDE

## Overview

For most of the HackerRank.com challenges, exercises and interview questions, the expected solution in Java is a class ```Solution```  that has the ```main``` method:

```
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString = scan.nextLine();
        scan.close();
        ...
        System.out.println(outputString);
    }
}
```

A typical test case is a pair of 2 strings:
* console input
* expected console output

However, this is not a typical approach for writing testable code in Java.

This library was created to let the developers who want to use their favorite IDE to easily test their solutions.

## Getting started

* Clone or download this repository
* Run ```gradlew build```
* Add the jar file from ```build\libs``` to the libraries of your project

## Usage

See the test files for the example usages.