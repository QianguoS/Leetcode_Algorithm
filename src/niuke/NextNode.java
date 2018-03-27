package niuke;

public class NextNode {
    /**
     * 给定一颗二叉排序树，给定一个节点，找出这个节点的下一个节点，
     * 节点中包含了指向父节点的指针*/
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public static TreeLinkNode findNextNode(TreeLinkNode pNode){
        //分两种情况进行讨论，如果有右孩子，则找右孩子最左边的节点
        //如果没有右孩子，则找祖宗的右孩子最左边的节点
        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            TreeLinkNode rightNode = pNode.right;
            while(rightNode.left!=null){
                rightNode = rightNode.left;
            }
            return rightNode;
        }
        if(pNode.next!=null){
            //TreeLinkNode parent = pNode.next;
            while(pNode.next!=null && pNode.next.left!=pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }
        return null;
    }

    public static void main(String[] args){

    }
}
