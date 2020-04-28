package My_Array;

import java.util.*;
/*
EPI 13.9
 */
public class GroupRepeatedEntries {


    static Map<String, Integer> itemToCountMap = new HashMap<>();

    public static List<String> groupByCount(List<String> arr){
        for( String i : arr){
            itemToCountMap.put(i, itemToCountMap.getOrDefault(i,0)+1);
        }

        Map<String, Integer> countOffsetMap = new HashMap<>();
        int offset = 0;
        //populate map with item and offset
        for(Map.Entry<String, Integer> entry : itemToCountMap.entrySet()){
            countOffsetMap.put(entry.getKey(), offset);
            offset += entry.getValue();
        }

        while(!countOffsetMap.isEmpty()){
            Map.Entry<String, Integer> from = countOffsetMap.entrySet().iterator().next();
            String item = arr.get(from.getValue());
            int to = countOffsetMap.get(item);

            Collections.swap(arr, from.getValue(), to);
            int count = itemToCountMap.get(item)-1;
            itemToCountMap.put(item, count);

            if(count >0){
                countOffsetMap.put(item,to+1);
            }else{
                countOffsetMap.remove(item);
            }
        }
       return arr;
    }

    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>();
        l1.add("b");
        l1.add("a");
        l1.add("a");
        l1.add("b");
        l1.add("c");
        l1.add("d");
        l1.add("b");
        l1.add("d");

        List<String> res = groupByCount(l1);

        System.out.print(l1.toString());
    }
}
