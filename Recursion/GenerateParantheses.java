package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {

    // write a program that takes input a number and
    // returns all the Strings with that number of matched pairs of parens.
    //i.e k = 2, return  <"()", "(())">

    public static List<String> generateParantheses(int numPairs) {
        List<String> result = new ArrayList<>();
        helper(numPairs, numPairs, " ", result);
        return  result;
    }

    private static void helper(int leftParenNeeded, int rightParenNeeded, String partialValidPrefix, List<String> result) {

        if (rightParenNeeded == 0){
            result.add(partialValidPrefix);
            return;
        }

        if ( leftParenNeeded > 0 ) {
            // means that I can still enter left paren
            helper(leftParenNeeded-1, rightParenNeeded, partialValidPrefix+"(", result);
        }
        if(rightParenNeeded > leftParenNeeded){
            //means we can still enter right paren
            helper(leftParenNeeded, rightParenNeeded-1, partialValidPrefix+")", result);
        }
    }
    public static void main(String[] args) {
        List<String> result = generateParantheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

       // result = generateParantheses(3);
        //System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
