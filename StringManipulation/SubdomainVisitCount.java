package StringManipulation;

import java.util.*;

public class SubdomainVisitCount {


    public static List<String> getSubdomainCounts(String[] domainCounts){

        List<String> result = new LinkedList<String>();
        HashMap<String, Integer> map = new HashMap<>();

        for( String str : domainCounts){

            String [] countAndDomain = str.split(",");
            int count = Integer.parseInt(countAndDomain[0]);

            String [] domains = countAndDomain[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            String s = "";
            for(int i = domains.length-1 ; i > 0 ; i--){
                String temp = i == domains.length-1? "":".";
                s = domains[i]+temp+ s;

                count = count+(map.containsKey(s)? map.get(s): 0);
                map.put(s, count);
            }
        }

        for(String key: map.keySet()){
            StringBuilder s = new StringBuilder();

            result.add(s.append(map.get(key)).append(" ").append(key).toString());
        }
        return result;
    }

    public static void main(String[] args) {

        String [] arr = {"9001 discuss.leetcode.com"};
        //System.out.println(subdomainVisits(arr));
        System.out.println(2<<1);
    }
}
