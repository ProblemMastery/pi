package LinkedList;

import java.util.Comparator;

public class DoublyLinkedList<T> {

    DoublyListNode<T> head;
    DoublyListNode<T> tail;
    //DoublyLinkedList constructor
   public  DoublyLinkedList(){
        head = new DoublyListNode<T>();
        tail = new DoublyListNode<T>();
        head.next = tail;
   }

   public DoublyListNode insert(T val) {

       DoublyListNode<T> node = tail.prev;

       DoublyListNode<T> newNode = new DoublyListNode<T>(val);
       node.next = newNode;
       newNode.prev = node;
       newNode.next = tail;
       tail.prev = newNode;
       return newNode;
   }

    public DoublyListNode remove(DoublyListNode node){

        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

   public T pop(){
        return (T) remove(tail.prev).val;
   }

   //peek
   public T getLastVal(){
        return tail.prev.val;
   }
    public class DoublyListNode<T> {
        T val;
        DoublyListNode<T> next;
        DoublyListNode<T> prev;

        DoublyListNode(T val) {
            this.val = val;
        }

        public DoublyListNode() {

        }

        public boolean equals(Object aNode) {
            DoublyListNode d = (DoublyListNode) aNode;
            return this.val.equals(((DoublyListNode) aNode).val);
        }

        public int hashCode() {
            return val.hashCode();
        }
    }


}
