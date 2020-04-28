package SortingAndSearching;

import java.util.*;

public class Interval {

    int start;
    int end;

    public Interval() {
        start = 0; end = 0;
    }
    public Interval(int s, int e)
    {
        start = s; end = e;
    }

    // return whether two intervals overlap (inclusive)
    private static boolean overlap(Interval a, Interval b) {

        return a.start <= b.end && b.start <= a.end;
    }
    private static class IntervalComparator implements Comparator<Interval> {
        @Override
           /*
        i.e if b is greater than a, return -1,
         if a == b return 0,
        if a is greater return 1
         */
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("["+this.start).append(","+this.end+"]").toString();
    }



    public static List<Interval> mergeIntervals(List<Interval> intervalList){

        //sort intervals based on starting time
        Collections.sort(intervalList, new IntervalComparator() );

        LinkedList<Interval> merged = new LinkedList<>();

        for (Interval interval : intervalList) {

            if(merged.isEmpty()){
                merged.add(interval);
            }
            Interval recent = merged.getLast();
            if(overlap(recent, interval)){
                recent.end = Math.max(recent.end, interval.end);
            }else
                merged.add(interval);

        }

        return merged;

    }

    public static void main (String [] args){

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        List<Interval> intervalLinkedList = new LinkedList<>();
        for(int i = 0 ; i < intervals.length; i++){
                Interval e = new Interval(intervals[i][0], intervals[i][1]);
                intervalLinkedList.add(e);
            }

        List<Interval> mergedIntervals = mergeIntervals(intervalLinkedList);

        Iterator<Interval> itr = mergedIntervals.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

}
