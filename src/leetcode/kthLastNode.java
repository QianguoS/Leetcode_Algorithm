package leetcode;

public class kthLastNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int count = n+1;
        while (count>0 ){
            if(fast.next==null)return null;
            count--;
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow = slow.next.next;
        return head;

    }
    public static void main(String[] args){

    }
}
