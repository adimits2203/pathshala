package linkedlist;

import java.util.List;

public class LLMain {

    public static void main(String[] args) {

    }

    /**
     * https://leetcode.com/problems/linked-list-cycle-ii/
     *
     * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
     *
     * Do not modify the linked list.
     *
     * Idea is to loop through the cycle repeatedly till we get to a common node with head pointer moving ahead after each iteration.
     *
     * */
     public ListNode detectCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head,temp=null,curr=head;
         while(fast!=null && fast.next!=null) {
             slow = slow.next;
             fast = fast.next.next;
             if (slow == fast) {
                 temp = slow;
                 break;
             }
         }
         if(temp==null) return null;
         while(true){
             if(temp==curr){
                 return curr;
             }
             temp = temp.next;
             if(temp==slow){
                 curr = curr.next;
             }
             if(curr==null){
                 return null;
             }
         }
     }

    /**
     *https://leetcode.com/problems/linked-list-cycle/
     *
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * Idea is to use slow and fast pointers. If they meet we have a cycle.
     * */
     public boolean hasCycle(ListNode head) {
         ListNode slow = head;
         ListNode fast = head;
         while(fast!=null && fast.next!=null){
             slow = slow.next;
             fast = fast.next.next;
             if(slow==fast){
                 return true;
             }
         }
         return false;
     }

    /**
     * https://leetcode.com/problems/rotate-list/
     * 1 2 3 4 5
     *
     * */
     public ListNode rotateRight(ListNode head, int k) {
         int length = 0;
         ListNode curr= head, lastNode=null;
         while(curr!=null){
             length++;
             lastNode = curr;
             curr = curr.next;
         }

         if(length==0) return head;
         curr = head;
         int numOfRotations = k%length;
         int numOfMoves = length - numOfRotations;
         while (numOfMoves-- > 1){
             curr = curr.next;
         }
         lastNode.next = head;
         ListNode ans = curr.next;
         curr.next = null;
         return ans;
     }


    /**
     *https://leetcode.com/problems/palindrome-linked-list/
     *
     * Idea is to find the mid point(2nd in case of even length linkedlist)
     * reverse the linked list starting from mid point till the end
     * compare the two parts
     *
     *
     * 2nd approach
     * use stack to store the values
     * iterate thru the linkedlist and compare
     *
     * */
     public boolean isPalindrome(ListNode head) {
            ListNode currHead = head;
            ListNode midPointNode = middleNode(head);
            ListNode currTail = reverseList(midPointNode);

            while(currTail!=null && currHead!=null){
                if(currHead.val!= currTail.val){
                    return false;
                }
                currHead = currHead.next;
                currTail = currTail.next;
            }

            return true;

     }


    /**
     * https://leetcode.com/problems/reverse-linked-list/
     *
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     * */
     public static ListNode reverseList(ListNode head) {
            ListNode curr = head;
            ListNode prev = null;
            ListNode temp;
            while(curr!=null){
                temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return  prev;
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
