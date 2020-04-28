package StacksAndQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item> {

    private int size;
    private Node top;

    private class Node<Item> {
        private Item item;
        private Node next;
    }

    public LinkedStack() {
        top = null;
        size = 0;

    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Item item){
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        size++;
    }

    public Item pop(){
        Item itemOnTop = (Item) top.item;
        top = top.next;
        size--;
        return itemOnTop;
    }


    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     * @return an iterator to this stack that iterates through the items in LIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node current = top;
        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = (Item) current.item;
            current = current.next;
            return item;
        }
    }

    public String toString(){
        Node current = top;

        if(top == null){
            return "NULL";
        }

        StringBuilder sb = new StringBuilder();

        for(Item i : this ){
            sb.append(i);
            sb.append("\n");
        }
        return sb.toString();
    }
}
