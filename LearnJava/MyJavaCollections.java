package LearnJava;

import java.util.Deque;
import java.util.LinkedList;

public class MyJavaCollections {


    public static void testStack(){
        Deque<Integer> stack = new LinkedList<>();

        stack.push(10); // or stack.addFirst
        stack.push(9);
        stack.push(8);
        System.out.println(stack);

        System.out.println(stack.peek()); // or peekFirst
        stack.pop(); // removeFirst()
        System.out.println(stack);
        stack.removeFirst();
        System.out.println(stack);

        stack.addFirst(100);
        stack.addFirst(90);
        stack.addFirst(80);
        System.out.println(stack);

    }

    public static void testQueue(){

        Deque<Integer> queue = new LinkedList<>();

        queue.offer(10);

    }


    public static void testDeque(){
        Deque<String> deque = new LinkedList<String>();

        // We can add elements to the queue in various ways
        deque.add("Element 1 (Tail)"); // keep adding to tail
        deque.addFirst("Element 2 (Head)"); // add to head
        deque.addLast("Element 3 (Tail)"); //add to tail
        System.out.println(deque + "\n");
        //Pushes an element onto the stack represented by this deque
        // (in other words, at the head of this deque)
        deque.push("Element 4 (Head)");


        //Inserts the specified element into the queue represented by this deque
        // (in other words, at the tail of this deque) , return boolean
        deque.offer("Element 5 (Tail)");

        //Inserts the specified element at the front of this deque
        // unless it would violate capacity restrictions. return boolean
        deque.offerFirst("Element 6 (Head)");

        //Inserts the specified element at the end of this deque
        // unless it would violate capacity restrictions. return boolean
        deque.offerLast("Element 7 (Tail)");
        System.out.println(deque + "\n");

        // Retrieves and removes the first element of this deque.
        deque.removeFirst();
        deque.removeLast();

        //Retrieves and removes the first element of this deque, or returns null if this deque is empty.
        deque.pollFirst();

    }

    public static void main(String[] args) {
        testStack();

    }
}
