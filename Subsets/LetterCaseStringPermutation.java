package Subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {
    /**
     * Given a string, find all of its permutations preserving the character sequence but changing case.
     *
     * Example 1:
     *
     * Input: "ad52"
     * Output: "ad52", "Ad52", "aD52", "AD52"
     * Example 2:
     *
     * Input: "ab7c"
     * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
     *
     *  Time and space - O(N*2^N)
     * ​​
     */

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);

        for (int i = 0 ; i < str.length(); i++){
            int L = permutations.size();
            if (Character.isLetter(str.charAt(i))){
                for (int j = 0 ; j <= L ; j++){
                    char[] currentChar = permutations.get(j).toCharArray();
                    if (Character.isUpperCase(currentChar[i]))
                        currentChar[i] = Character.toLowerCase(currentChar[i]);
                   else
                        currentChar[i] = Character.toUpperCase(currentChar[i]);

                    permutations.add(String.valueOf(currentChar));
                }
            }
        }
        return permutations;
    }
    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
