package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySortCharsWithPosition {

    static class Element {
        char c;
        int frequency;
        int sequenceNumber;

        public Element(char c, int frequency, int sequenceNumber) {
            this.c = c;
            this.frequency = frequency;
            this.sequenceNumber = sequenceNumber;
        }
    }

    static class ElementComparator implements Comparator<Element> {
        @Override
        public int compare(Element e1, Element e2) {
            if (e1.frequency != e2.frequency)
                return e2.frequency - e1.frequency;
            return e1.sequenceNumber - e2.sequenceNumber;
        }
    }

    public static String sortString(String input){

        Map<Character, Element> map = new HashMap<>();
        PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());

        for (int i = 0 ; i < input.length(); i++){
            char c = input.charAt(i);
            if (map.containsKey(c)){
                int freq = map.get(c).frequency+1;
                int seqNo = map.get(c).sequenceNumber;
                map.put(c, new Element(c, freq,seqNo));
            }else {
                map.put(c, new Element(c, 1, i));
            }
        }

        maxHeap.addAll(map.values());
        StringBuilder sb = new StringBuilder();

        while ((!maxHeap.isEmpty())){
            Element e = maxHeap.poll();
            char c = e.c;
            int freq = e.frequency;
            for (int i = 0 ; i <freq; i++ ){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String result = sortString("abcaabca");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }
}
