package HashTable;
//done Upload

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a
letter in pattern and a non-empty word in str.
 */
public class WordPattern {


    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> wordSet = new HashSet<>();

        String[] words = str.split("\\s");
        if(pattern.length() != words.length){
            return false;
        }
        int i = 0 ;
        for(Character c : pattern.toCharArray()){

            if(!map.containsKey(c) && !wordSet.contains(words[i])){
                map.put(c, words[i]);
                wordSet.add(words[i]);
            }
            else {
                String currentWord = map.get(c);
                if(currentWord != words[i]){
                    return  false;
                }
            }
            i++;
        }

        return true;
    }
    public static void main (String [] args){

        System.out.print(wordPattern("abba", "dog dog dog dog"));
    }
}
