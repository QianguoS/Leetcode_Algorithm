package leetcode;

import java.util.List;

public class Swap_Nodes_in_Pairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null)return head;
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        ListNode curr = head;
        while(curr!=null && curr.next!=null){
            ListNode temp = curr.next.next;
            curr.next.next = curr;
            pre.next = curr.next;
            curr.next = temp;

            pre = curr;
            curr = curr.next;


        }
        return newHead.next;
    }
    public static void main(String[] args){


    }
}
