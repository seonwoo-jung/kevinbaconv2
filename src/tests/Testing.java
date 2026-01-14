package tests;

/*
A class for implementing simple test cases in other classes

Author: Owen Coyle, updated by Todd Meyer

Last Updated: 10/16/2014
*/

import java.util.Arrays;

public class Testing {

    // ASCII codes for formatting & colors to print to terminal
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String SET_PLAIN_TEXT = "\033[0;0m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";

    /**
     * Tests whether the output is equal to what was expected. Prints out a
     * descriptive test message
     * Ex.
     * testEquals("Test 1", 4.0, 3.0) -> "Test 1: result: 4.0, expected: 3.0
     * testEquals("Test 2", true, true) -> "Test 2: OK"
     * testEquals("Test 3", 1, 1.0) -> "Test 3: result 1, expected 1.0"
     *
     * @param caseID   String caseID: the ID of this test case, e.g. "Test 1"
     * @param result   Object result: the actual result of some function call
     * @param expected Object expected: the expected result of some function call
     */
    public static void testEquals(String caseID, Object result, Object expected) {

        if (expected == null && result == null) {
            System.out.println(TEXT_GREEN + caseID + ": OK" + ANSI_RESET);
            return;
        }

        else if (expected.getClass().isArray()) {
            if (result instanceof String[]) {
                String[] r = (String[]) result;
                String[] s = (String[]) expected;
                boolean isTrue = true;
                isTrue = r.length == s.length;
                if (r.length == s.length){
                    for (int i = 0; i < r.length; i++) {
                        if (!r[i].equals(s[i])){
                            isTrue = false;
                        }
                    }
                }
                if (isTrue) {
                    System.out.println(TEXT_GREEN + caseID + ": OK" + ANSI_RESET);
                }else{
                    System.out.println(TEXT_RED + caseID + ": result: " + Arrays.toString(r) + ", expected: " + Arrays.toString(s) + ANSI_RESET);
                }
                return;
            }
            else if (result instanceof int[]){
                boolean isTrue = true;
                if (result.getClass().getName().equals("String")){
                    System.out.println("String");
                }
                int[] r = (int[]) result;
                int[] s = (int[]) expected;
                // the object is an array, let's step through it:
                isTrue = r.length == s.length;
                if (r.length == s.length){
                    for (int i = 0; i < r.length; i++) {
                        if (r[i] != s[i]){
                            isTrue = false;
                        }
                    }
                }
                if (isTrue) {
                    System.out.println(TEXT_GREEN + caseID + ": OK" + ANSI_RESET);
                }else{
                    System.out.println(TEXT_RED + caseID + ": result: " + Arrays.toString(r) + ", expected: " + Arrays.toString(s) + ANSI_RESET);
                }
            }
            else {
                System.out.println(TEXT_RED + caseID + ": result: " + result + ", expected: " + expected + ANSI_RESET);
            }
        } else if (result.equals(expected)) {
            System.out.println(TEXT_GREEN + caseID + ": OK" + ANSI_RESET);
        } else {
            System.out.println(TEXT_RED + caseID + ": result: " + result + ", expected: " + expected + ANSI_RESET);
        }
    }


    /**
     * Tests whether the output is equal to what was expected. Prints out a
     * descriptive test message
     * Ex.
     * testEquals("Test 1", 4.0, 3.0) -> "Test 1: result: 4.0, expected: 3.0
     * testEquals("Test 2", true, true) -> "Test 2: OK"
     * testEquals("Test 3", 1, 1.0) -> "Test 3: result 1, expected 1.0"
     *
     * @param caseID   String caseID: the ID of this test case, e.g. "Test 1"
     * @param result   Object result: the actual result of some function call
     * @param expected Object expected: the expected result of some function call
     */
    public static void testEqualsDouble(String caseID, double result, double expected, double precision) {
        if (Math.abs(result - expected) <= precision) {
            System.out.println(TEXT_GREEN + caseID + ": OK" + ANSI_RESET);
        } else {
            System.out.println(TEXT_RED + caseID + ": result: " + result + ", expected: " + expected+ ANSI_RESET);
        }

    }

}
