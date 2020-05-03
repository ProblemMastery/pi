package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Hard_FrequencyStack {

    /**
     *
     * Design a class that simulates a Stack data structure, implementing the following two operations:
     *
     * push(int num): Pushes the number ‘num’ on the stack.
     * pop(): Returns the most frequent number in the stack. If there is a tie, return the number which was pushed later.
     * After following push operations: push(1), push(2), push(3), push(2), push(1), push(2), push(5)
     *
     * 1. pop() should return 2, as it is the most frequent number
     * 2. Next pop() should return 1
     * 3. Next pop() should return 2
     */

    class StackEntry {

        int number;
        int frequency;
        int sequenceNumber;

        public StackEntry(int number, int frequency, int sequenceNumber){
            this.number = number;
            this.frequency = frequency;
            this.sequenceNumber = sequenceNumber;
        }
    }

    class StackEntryComparator implements Comparator<StackEntry> {

        @Override
        public int compare(StackEntry e1, StackEntry e2) {
            if (e1.frequency != e2.frequency)
                return e2.frequency - e1.frequency;

            //else if equal compare sequence number
            return e2.sequenceNumber- e1.sequenceNumber;
        }
    }
        private int sequenceNumber;
        private PriorityQueue<StackEntry> maxHeap;
        private Map<Integer, Integer> frequencyMap;

        public Hard_FrequencyStack() {
            sequenceNumber = 0;
            maxHeap = new PriorityQueue<StackEntry>(new StackEntryComparator());
            frequencyMap = new HashMap<>();
        }

        public void push(int num) {
            this.sequenceNumber++;
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
            maxHeap.add(new StackEntry(num, frequencyMap.get(num), this.sequenceNumber));
        }
        public int pop() {
            int num = maxHeap.poll().number;
            if (frequencyMap.get(num) > 1)
                frequencyMap.put(num, frequencyMap.get(num)-1);
            else
                frequencyMap.remove(num);
            return num;
        }

    }
