package HashTable;
// done upload
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
LeetCode(https://leetcode.com/problems/time-based-key-value-store/)
 and Instacart
981. Time Based Key-Value Store
Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)

Stores the key and value, along with the given timestamp.
2. get(string key, int timestamp)

Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
If there are multiple such values, it returns the one with the largest timestamp_prev.
If there are no values, it returns the empty string ("").
 */
public class TimeBasedKeyValueStore {

    Map<String, TreeMap<Integer, String>> keyTimeMap;

    public  TimeBasedKeyValueStore(){
        keyTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timeStamp){

        if( !keyTimeMap.containsKey(key)){
            keyTimeMap.put(key, new TreeMap<>());
        }
        keyTimeMap.get(key).put(timeStamp, value);
    }

    public String get (String key){
        if( keyTimeMap.containsKey(key)){
            return "";
        }

        TreeMap<Integer, String > map = keyTimeMap.get(key);
        return map.get(map.lastKey());
    }

    public String get (String key, int timeStamp){
        if( keyTimeMap.containsKey(key)){
            return "";
        }

        TreeMap<Integer, String > map = keyTimeMap.get(key);
        return  map.get(timeStamp);
    }
}
