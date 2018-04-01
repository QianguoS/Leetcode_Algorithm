package leetcode;
/**
 * A linked list is given such that each node contains
 * an additional random pointer which could point to
 * any node in the list or null.

 Return a deep copy of the list.*/
public class linkCopy {
    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };
    public static RandomListNode getCopyLink(RandomListNode head){
        RandomListNode node = head;
        //复制链表得到顺序结构
        while (node != null){
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        //复制random指针节点
        node = head;
        while (node != null){
            if(node.random != null) node.next.random = node.random.next;
            node = node.next.next;
        }
        //detach list
        RandomListNode n2 = head.next;
        node = head;
        RandomListNode head2 = head.next;
        while(n2 != null && node != null){
            node.next = node.next.next;
            if (n2.next == null){
                break;
            }
            n2.next = n2.next.next;

            n2 = n2.next;
            node = node.next;
        }
        return head2;


    }
    public static void main(String[] args){

    }
}
