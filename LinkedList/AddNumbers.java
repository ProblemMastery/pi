package LinkedList;
public class AddNumbers {
    //https://leetcode.com/problems/add-two-numbers/

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 != null && l2 != null){
                int l1size = getLength(l1);
                int l2size = getLength(l2);
                if(l1size > l2size)
                    l2 = padZero(l2, l1size-l2size);
                else
                    l1 = padZero(l1, l2size-l1size);
                ListNode head = sum(l1, l2, 0);
                return head;
            }

            else if(l1 == null)
                return l2;
            else
                return l1;

        }



        private ListNode sum(ListNode l1, ListNode l2, int carry){
            if(carry == 0 &&(l1 == null || l2 == null)){
                return null;
            }
            if( carry >0 && (l1 == null || l2 == null))
                return new ListNode(carry);
            int sum = l1.val + l2.val+ carry;
            if(sum >=10)
                carry = 1;
            else
                carry = 0;
            ListNode newNode = new ListNode(sum%10);
            newNode.next = sum(l1.next, l2.next, carry);
            return newNode;
        }

        private ListNode padZero(ListNode head, int numZeroes){

            ListNode current = head;
            while(current.next != null)
                current = current.next;
            while( numZeroes > 0){
                ListNode node = new ListNode(0);
                current.next = node;
                current = node;
                numZeroes--;
            }

            return head;

        }

        private int getLength(ListNode l1){

            int len = 0 ;
            while(l1 != null){
                len ++;
                l1 = l1.next;
            }
            return len;
        }
    }
