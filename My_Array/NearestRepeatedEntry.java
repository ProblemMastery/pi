package My_Array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestRepeatedEntry {
    /*
    Given a paragraph of words as array, find 2 entries that same and has the closest distance between them

     */

    public static int findNearestRepetition(List<String> paragraph){

        int d = Integer.MAX_VALUE;
        Map<String, Integer> wordToIndexMap = new HashMap<>();
        for(int i = 0 ; i < paragraph.size(); i++){
            String word = paragraph.get(i);
            if(wordToIndexMap.containsKey(word)){
                d = Math.min (i - wordToIndexMap.get(word), d);
            }
            wordToIndexMap.put(word, i);
        }
        return d != Integer.MAX_VALUE? -1: d;
    }
}
