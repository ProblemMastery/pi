package DP;

import java.util.*;

public class WordBreak {

    /* REDO this prob
    https://leetcode.com/problems/word-break/

    Word = "IAMACE" can it be split into word such that each word is in dictionary
     */

    /*Solution : based on Tushr Roy DP Video, can be done in BFS as well.

    create a 2D array of size lXl l = word length.


     */
    public static String wordBreak(String s, List<String> wordDict) {

        int [][] T = new int [s.length()][s.length()];

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length ; j++){
                T[i][j] = -1; //-1 indicates string between i to j cannot be split
            }
        }

        for (int l = 1; l < s.length(); l++){
            for (int i = 0 ; i < s.length()-l+1; i++){
                int j = i + l -1;

                String str = s.substring(i, j+1);
                if (wordDict.contains(str)){
                    T[i][j] = i;
                    continue;
                }else{
                    for (int k = i+1 ; k <= j ; k++){

                        if(T[i][k-1] != -1 && T[k][j] != -1) {
                            T[i][j] = k;
                            break;
                        }
                    }

                }
            }
        }

        if(T[0][s.length()] == -1)
            return null;

        return "dummyStrig";// true it can be split


    }
    public static boolean wordBreakBFS(String s, List<String> wordDict) {

        Set<String> dictionary = new HashSet<>();

        dictionary.addAll(wordDict);
        Deque<Integer> queue = new LinkedList<>();
        int [] visited = new int [s.length()];


        queue.offer(0);

        while(!queue.isEmpty()){
            int start = queue.removeFirst();

            if (visited[start] != 1){

                for (int end = start+1; end < s.length(); end++){
                    if (dictionary.contains(s.substring(start, end))){
                        queue.offer(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start] = 1;
            }
        }
        return  false;
    }


}
