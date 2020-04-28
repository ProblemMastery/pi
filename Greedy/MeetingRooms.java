package Greedy;

import java.util.*;
/*
Runtime: 8 ms, faster than 29.88% of Java online submissions for Meeting Rooms II.
Memory Usage: 42.7 MB, less than 5.12% of Java online submissions for Meeting Rooms II.
 */
public class MeetingRooms {

        private static class Interval {

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
            private boolean overlap(Interval b) {

                return this.start < b.end && b.start < this.end;
            }
            public String toString(){
                StringBuilder sb = new StringBuilder();
                return sb.append("["+this.start).append(","+this.end+"]").toString();
            }

        }
        private static class IntervalComparator implements Comparator<Interval> {
            @Override
           /*
        i.e if b is greater than a, return -1,
         if a == b return 0,
        if a is greater return 1
         */
            public int compare(Interval a, Interval b) {
                return a.start < b.start ? -1 : a.start == b.start ? 0:1;
            }
        }

        public static int minMeetingRooms(int[][] intervals) {

            if(intervals.length == 0)
                return 0;

            List<Interval> intervalList = new ArrayList<>();

            for  (int i = 0 ; i <intervals.length; i++){
                Interval t = new Interval(intervals[i][0], intervals[i][1]);
                intervalList.add(t);
            }

            Collections.sort(intervalList, new IntervalComparator());
            int meetingRooms = 1;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(Interval interval: intervalList) {
                if (minHeap.isEmpty()) {
                    minHeap.add(interval.end);
                    continue;
                }
                int minEndTime = minHeap.peek();
                if (minEndTime > interval.start) {// means does the current one starts before the earliest endTime
                    //if so they overlap, they cannot use the same meeting room
                    meetingRooms++;
                }else
                    minHeap.poll();
                minHeap.add(interval.end);
            }

            return meetingRooms;

        }
    public static void main(String[] args) {

            int [][] intervals = {{2,15},{36,45},{9,29},{16,23},{4,9}};
        System.out.println(minMeetingRooms(intervals));

    }
    }

