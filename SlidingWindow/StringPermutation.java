package SlidingWindow;
import java.util.*;

public class StringPermutation {


        public static boolean findPermutation(String str, String pattern) {
            return false;
        }

        public static void main(String[] args) {
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
            System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacib", "abc"));
        }
    }

