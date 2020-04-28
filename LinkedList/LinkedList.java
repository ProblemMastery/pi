package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList {
    public ListNode head;
    private int length = 0;


    public LinkedList(){
        head = new ListNode(0);
    }

    public boolean isEmpty() {

        return head == null;
    }

    public int size() {

        return length;
    }

    //insert
    public void insert(int item){
        ListNode newNode = new ListNode(item);
        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = newNode;
        length++;
    }

    //remove
    public ListNode remove(int item){
        ListNode current = head;

        while (current.next != null && current.next.val != item){
            current = current.next;
        }
        ListNode temp = current.next;
        current.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList{");
        ListNode current = head.next;
        while (current != null){
            sb.append(current.val).append("->");
            current = current.next;
        }
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args){

        LinkedList l1 = new LinkedList();
        for(int i =0; i<5; i++){
            l1.insert(i);
        }
        System.out.println(l1.length);

        System.out.println(l1.toString());
    }
}
