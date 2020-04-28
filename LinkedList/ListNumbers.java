package LinkedList;

public class ListNumbers {
    /*
     Convert Binary Number in a Linked List to Integer
    */

    public static int getDecimalValue(ListNode head) {

        int sum = 0;
        int len =0;
        ListNode node = head;

        while(node.next != null){
            len++;
            node= node.next;
        }
        node = head;
        while ( node.next != null){
            sum = sum + (node.val *(int)Math.pow(2.0,len-1));
            node = node.next;
            len--;
        }
        return sum;
    }

    public int getDecimalValue2(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args){

        LinkedList l1 = new LinkedList();
        l1.insert(1);
        l1.insert(1);
        System.out.println(getDecimalValue(l1.head));
    }
}
