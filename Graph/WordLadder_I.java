package Graph;

import javafx.util.Pair;

import java.util.*;

public class WordLadder_I {

    /*
    Given two words (beginWord and endWord), and a dictionary's word list,
     find the length of shortest transformation sequence from beginWord to endWord, such that:
    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5
     */

    public static int ladderLength(String beginWord, String endWord, List<String> dictionaryList){

        /** preprocessing step:
         * we change one letter a time and verify if its in the dictionary.
         * One way to do it is  imagine it as a graph where HIT -> HOT ->DOT->LOT..
         * i.e HIT and HOT are nbrs , i.e inr our data structure, H*T, where * repreasents any character,
         * would yield us  HOT and HIT, similary, *OT -> <HOT, DOT, LOT>
         */
        int L = beginWord.length();
        Map<String, List<String>> dictMap = new HashMap<>();
        // iterate on every word in dictionaryList,
        for (String word : dictionaryList) {

            // create a new word with *in every position of the word.
            for (int i = 0; i < L; i++) {

                String comboWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
                List<String> wordList = dictMap.getOrDefault(comboWord, new ArrayList<>());
                wordList.add(word);
                dictMap.put(comboWord, wordList); // H*T -> <HOT, HIT>
            }
        }

            Queue<Pair<String, Integer>> q = new LinkedList<>();
            Set<String> visited = new HashSet<>();

            q.add(new Pair(beginWord, 1));
            visited.add(beginWord);

            while (!q.isEmpty()){
                Pair<String, Integer> pair = q.poll();

                String currentWord = pair.getKey();
                int distance = pair.getValue();

                for (int i = 0 ; i < L ; i++){
                    String comboWord = currentWord.substring(0, i)+"*"+currentWord.substring(i+1,L);

                    List<String> allPossibleWords = dictMap.get(comboWord);

                    for (String eachPossibleWord : allPossibleWords){

                        if (eachPossibleWord.equals(endWord))
                            return distance+1;

                        if (! visited.contains(eachPossibleWord)){
                            q.offer(new Pair(eachPossibleWord, distance+1));
                            visited.add(eachPossibleWord);
                        }
                    }
                }
            }


        return 0;
    }
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>();

        list.add(beginWord);
        list.add(endWord);
        list.add("dot");
        list.add("lot");
        list.add("dog");
        list.add("log");
        list.add("hot");

        System.out.print(ladderLength(beginWord, endWord, list));

    }
}
