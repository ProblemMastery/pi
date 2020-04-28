package StacksAndQueue;
//dU
import LinkedList.DoublyLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
we are making use of TreeMp Data structure, which has the lastKey() method that returns the highest key in the map
 */
public class MaxStack<Integer> {

    TreeMap<Integer, List<DoublyLinkedList.DoublyListNode>> valueToNodeMap;
    DoublyLinkedList<Integer> dll;

    public MaxStack() {
        valueToNodeMap = new TreeMap<Integer,List<DoublyLinkedList.DoublyListNode> >();
         dll = new DoublyLinkedList<Integer>();
    }

    public void push(Integer x) {
        DoublyLinkedList.DoublyListNode node = dll.insert(x);
        List<DoublyLinkedList.DoublyListNode> l;
        if (! valueToNodeMap.containsKey(x)) {
            l = new ArrayList<>();

        }else {
            l = valueToNodeMap.get(x);
        }
        l.add(node);
        valueToNodeMap.put(x,l);
    }

    public Integer pop() {
        Integer val = dll.pop();
        List<DoublyLinkedList.DoublyListNode> l = valueToNodeMap.get(val);
        l.remove(l.size()-1);
        if(l.isEmpty())
            valueToNodeMap.remove(val);
        return val;
    }

    public int top() {
        return (int) dll.getLastVal();
    }

    public int peekMax() {
        return (int) valueToNodeMap.lastKey();
    }

    public int popMax() {
        int max = peekMax();
        List<DoublyLinkedList.DoublyListNode> l = valueToNodeMap.get(max);
        DoublyLinkedList.DoublyListNode node = l.get(l.size()-1);
        dll.remove(node);
        if(l.isEmpty())
            valueToNodeMap.remove(max);
        return max;
    }
}
