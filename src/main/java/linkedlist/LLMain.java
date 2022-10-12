package linkedlist;

import java.util.List;

public class LLMain {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * Given the head of a linked list, remove the nth node from the end of the list and return its head.
     * Idea is to have a window if two pointers separated by 'n', move them and when 2nd pointer reaches the end first would be at the end -n
     *
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head;
        ListNode second = head;
        int count =0;
        while(count < n){
            second = second.next;
            count++;
        }

        if(second==null){
            return head.next;
        }

        while(second.next!=null){
            second = second.next;
            first = first.next;
        }

        ListNode temp = first.next.next;
        first.next = temp;

        return head;

    }

    /**
     * https://leetcode.com/problems/middle-of-the-linked-list/
     *
     * Given the head of a singly linked list, return the middle node of the linked list.
     *
     * If there are two middle nodes, return the second middle node.
     * */
    public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }

    class ListNode {
      int val;
     ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


}
