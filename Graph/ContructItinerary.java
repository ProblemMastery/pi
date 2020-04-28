package Graph;

import java.util.*;

/*
https://leetcode.com/problems/reconstruct-itinerary/solution/
 */
public class ContructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {

        Map<String, List<String>> map = new HashMap<>();
        Map<String, boolean[]> visitBitMap = new HashMap<>();
        List<String> result = new LinkedList<>();

        for (int i = 0 ; i < tickets.size(); i++){
            List<String> l = tickets.get(i);
            List<String> list = map.getOrDefault(l.get(0), new LinkedList<>());
            list.add(l.get(1));
            map.put(l.get(0),list);
        }

        for (String origin : map.keySet()){

            List<String> destnList = map.get(origin);
            Collections.sort(destnList);
            boolean[] v = new boolean[destnList.size()];
            Arrays.fill(v, Boolean.FALSE);
            visitBitMap.put(origin, v);
        }
        result.add("JFK");
        dfsHelper("JFK", map, visitBitMap, result);
        return result;
    }
    private static void dfsHelper(String currentLocation, Map<String, List<String>> map, Map<String,
            boolean []> visitBitMap, List<String> result){

        List<String> list;
        boolean [] visited;
        if  (map.containsKey(currentLocation)){
            list = map.get(currentLocation);
            visited = visitBitMap.get(currentLocation);
        }
        else
            return;

        if (list.isEmpty())
            return;

        for  (int i = 0 ; i < list.size() ; i++){
            String currDestn = list.get(i);
            if (! visited[i]) {
                result.add(currDestn);
                visited[i] = Boolean.TRUE;
                dfsHelper(currDestn, map, visitBitMap, result);
            }

        }

    }
    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();

        List<String> l1 = new ArrayList<>();
        l1.add("JFK");l1.add("SFO");
        tickets.add(l1);

        List<String> l2 = new ArrayList<>();
        l2.add("JFK");l2.add("ATL");
        tickets.add(l2);

        List<String> l3 = new ArrayList<>();
        l3.add("SFO");l3.add("ATL");
        tickets.add(l3);

        List<String> l4 = new ArrayList<>();
        l4.add("ATL");l4.add("JFK");
        tickets.add(l4);
        List<String> l5 = new ArrayList<>();
        l5.add("ATL");l5.add("SFO");
        tickets.add(l5);

        System.out.print(findItinerary(tickets));
    }

    }
