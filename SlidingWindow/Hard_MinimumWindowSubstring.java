package SlidingWindow;
/*
Given a string S and a string T,
find the minimum window in S which will contain all the characters in T in complexity O(n).
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
 */


import javafx.util.Pair;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hard_MinimumWindowSubstring {

    public static String minWindow(String s, String t){

        if (s.length() == 0 || t.length() == 0){
            return null;
        }

        Map<Character, Integer> charToCountMapForT = new HashMap<>();

        //poplulate dictionary of T char with its count
        for (char c: t.toCharArray()) {
            int count = charToCountMapForT.getOrDefault(c, 0);
            charToCountMapForT.put(c, count + 1);
        }
        int requiredCharsToMatch = charToCountMapForT.size();

        //create List of pair, where key is index, value is char in T that occurs in S

        List<Pair<Integer, Character>> filteredS = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charToCountMapForT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        Map<Character, Integer> windowCharacterCount = new HashMap<>();
        int [] ans = {-1, 0, 0};

        int l = 0 , r = 0;
        int charMatchedInWindow = 0 ;

        while (r < filteredS.size()){

            char c = filteredS.get(r).getValue();

            int count = windowCharacterCount.getOrDefault(c, 0);
            windowCharacterCount.put(c, count+1);

            //check if the current char is in T and it contributes to the number of times it appears T
            if (charToCountMapForT.containsKey(c)
                    && windowCharacterCount.get(c).intValue() == charToCountMapForT.get(c).intValue()){
                charMatchedInWindow++;
            }

            // once our characterRequired to match is done, we decraese the window sixe by incrementing l pointer.
            // if left pointer is less than right and charMatchd == required match, strt shrinking the window
            while (l <= r && charMatchedInWindow == requiredCharsToMatch){

                // before we contract, store the current window size,
                // along with its strt and end pointer to get the substring later.
                int start = filteredS.get(l).getKey();
                int end = filteredS.get(r).getKey();
                //if the new window is better than old values stored, make the change
                if (ans [0] == -1 || end - start +1 < ans[0] ) {
                    ans[0] = end - start +1;
                    ans [1] = start;
                    ans[2] = end;
                }
                // now we need to shrink the window, to do that remove the char from window map
                // and also check if if the char removed contributes to T
                char currCharPointedinL = filteredS.get(l).getValue();
                int windowCount = windowCharacterCount.get(currCharPointedinL);
                windowCharacterCount.put(currCharPointedinL, windowCount-1);

                if (charToCountMapForT.containsKey(currCharPointedinL)
                        && windowCharacterCount.get(currCharPointedinL).intValue() < charToCountMapForT.get(currCharPointedinL).intValue()){
                    // if true, decrease the character formed so far in thw window, since have noww shrinked it.
                    charMatchedInWindow--;
                }
                // increase the left pointer to shrink the window
                l++;
            }
            // increase the right pointer to expannd the window.
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }

    public static void main(String[] args) {

        String S = "ADOBECODEBANC";
        String t = "ABC";

        System.out.print(minWindow(S, t));
    }

}
