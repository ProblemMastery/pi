package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
https://www.youtube.com/watch?v=W2DvQcDPD9A
 */
public class Hard_MinimumWindowSubsequence {


    public static String minWindow(String S, String T){
        String minwin = "";
        int min = S.length(); // first initializing "min" to max value it can have, which is S.

        int j = 0; // or the tpointer;

        for (int i = 0 ; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(j)) {
                j++;
            }

            if (j >= T.length()) {
                int endOfString = i + 1;
                j--;
                // move j backwards
                while (j >= 0) {
                    if (S.charAt(i) == T.charAt(j)) {
                        j--;
                    }
                    i--;
                }
                i++;// increase it since we went past first matching character of T
                j=0; // since j would be -1 , bringing it back to 0;
                if (endOfString - i < min) {
                    min = endOfString - i;
                    minwin = S.substring(i, endOfString);
                }
            }
        }
        return minwin;


    }
    public static void main(String[] args) {

        String S = "abcidebdde";
        String t = "bde";

        System.out.print(minWindow(S, t));
    }
}
