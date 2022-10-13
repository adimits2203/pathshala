package linkedlist;

public class GfgLinkedList {


    class Node
    {
        int data;
        Node next;

        Node(int key)
        {
            data = key;
            next = null;
        }
    }

    // 1 2 3 4 5 6

    public static int nknode(Node head, int k)
    {
        Node first = head;
        Node second = head;
        while(second!=null){

            for (int i = 0; i < k && second!=null ; i++) {
                second = second.next;
            }
            first = first.next;
            if(second==null){
                return first.data;
            }

        }
        return first.data;
    }
}
