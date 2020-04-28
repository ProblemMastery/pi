package StacksAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CicularQueue {
    // @include
    public static class Queue {
        private int head = 0, tail = 0, numQueueElements = 0;
        private static final int SCALE_FACTOR = 2;
        private Integer[] entries;

        public Queue(int capacity) {
            entries = new Integer[capacity];
        }

        public void enqueue(Integer x) {
            if (numQueueElements == entries.length) { // Need to resize.
                // Makes the queue elements appear consecutively.
                Collections.rotate(Arrays.asList(entries), -head);
                // Resets head and tail.
                head = 0;
                tail = numQueueElements;
                entries = Arrays.copyOf(entries, numQueueElements * SCALE_FACTOR);
            }

            entries[tail] = x;
            tail = (tail + 1) % entries.length;
            ++numQueueElements;
        }

        public Integer dequeue() {
            if (numQueueElements != 0) {
                --numQueueElements;
                Integer ret = entries[head];
                head = (head + 1) % entries.length;
                return ret;
            }
            throw new NoSuchElementException("Dequeue called on an empty queue.");
        }

        public int size() {
            return numQueueElements;
        }

        // @exclude

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Queue{").append("head =").append(head).append("tail").append(tail).append("entries")
                    .append(Arrays.toString(entries));
            return sb.toString();
        }
    }



    public static void main(String[] args) {
        Queue q = new Queue(8);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(10);
        q.enqueue(11);
        q.enqueue(14);
        q.enqueue(12);
        q.enqueue(13);
        q.enqueue(15);
        q.enqueue(16);

        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.enqueue(13);
        q.enqueue(15);
        q.enqueue(16);
        q.enqueue(17);
        q.enqueue(18);

        System.out.println("Circular queue "+q.toString());

    }
}
