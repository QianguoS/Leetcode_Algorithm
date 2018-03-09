package niuke;

import javax.sql.rowset.spi.SyncProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class niuke_algorithm {
    /**
     * 给定一个二叉树和其中的一个结点，
     * 请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，
     * 同时包含指向父结点的指针。*/
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        //可以分成两种情况，一种是存在右子树，一种是不存在右子树
        //若存在右子树，则下一个节点就是右子树最左边的一个节点
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null){
                pNode = pNode.left;

            }
            return pNode;
        }
        //剩下的一种情况是，节点不存在右子树，此时应该又可以分成两种情况，此节点为左子树，此节点为右子树
        //若此节点为左子树，则父节点就是下一个要访问的节点

        if(pNode.next!=null && pNode.next.left == pNode){
            return pNode.next;
        }
        //若此节点为右子树，则需要遍历到成为父节点的左子树才可以
        while(pNode.next!=null){
            if(pNode.next.left==pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;

    }
    /**
     * 输入一颗二叉树和一个整数，
     * 打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。*/
    //solution1
    public static ArrayList<ArrayList<Integer>> FindPaths(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> auxAL = new ArrayList<>();
        findPathSumOfTarget(root, target, auxAL, res);
        return res;
    }

    private static void findPathSumOfTarget(TreeNode root, int target,
                                            ArrayList<Integer> auxAL, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                ArrayList<Integer> newAL = new ArrayList<>(auxAL.size());
                for (Integer i : auxAL) {
                    newAL.add(i);
                }
                newAL.add(root.val);
                res.add(newAL);
            }
            return;
        }
        auxAL.add(root.val);
        findPathSumOfTarget(root.left, target - root.val, auxAL, res);
        findPathSumOfTarget(root.right, target - root.val, auxAL, res);
        auxAL.remove(auxAL.size()-1);
    }



    //solution2

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //solution
    private static List<List<Integer>> result = new ArrayList<List<Integer>>();


    public static void pathIner(TreeNode root, int sum, Stack path){
        path.push(root.val);
        if(root.left==null && root.right==null){
            if(sum==root.val) result.add(new ArrayList(path));
        }else{
            if(root.left!=null) pathIner(root.left,sum-root.val,path);
            if(root.right!=null) pathIner(root.right,sum-root.val,path);
        }
        path.pop();
    }

    public static void findsum(TreeNode root, int target, Stack<Integer> path){
        path.push(root.val);
        if(root.left==null && root.right==null){
            if(target == root.val)result.add(new ArrayList<Integer>(path));
        }else{
            if(root.left!=null) findsum(root.left,target-root.val,path);
            if(root.right!=null) findsum(root.right,target-root.val,path);
        }
        path.pop();
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        findsum(root,target,path);
        return null;
    }
    /**
     *  5
     /    \
     4       8
     /     /    \
     11    13  4
     /  \       \
     7    2      1*/

    /**
     * 输入两个链表，找出它们的第一个公共结点。*/
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //solution1
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        int p1_length = get_length(pHead1);
        int p2_length = get_length(pHead2);
        int diff = p1_length-p2_length;
        ListNode plong;
        ListNode pshort;

        if(p1_length>p2_length){
            diff = p1_length-p2_length;
            plong = pHead1;
            pshort = pHead2;
        }else{
            diff = p2_length-p1_length;
            plong = pHead2;
            pshort = pHead1;
        }
        for(int i=0;i<diff;i++){
            plong = plong.next;
        }
        while(plong!=null && pshort!=null &&plong!=pshort){
            plong = plong.next;
            pshort = pshort.next;
        }
        return plong;


    }
    private static int get_length(ListNode pHead1) {
        ListNode p_curr = pHead1;
        int length = 0;
        while(p_curr!=null){
            length++;
            p_curr=p_curr.next;
        }
        return length;
    }
    /**
     * 统计一个数字在排序数组中出现的次数。
     * */
    public static int GetNumberOfK(int [] array , int k) {
        int L = 0;
        int R = array.length-1;
        int mid = 0;
        int count=0;
        while(L<=R){
            mid = (L+R)/2;
            if(array[mid]==k){
                break;
            }
            if(array[mid] < k){
                L = mid+1;
            }else{
                R = mid-1;
            }
        }
        int second = mid;
        if(array[mid]==k){
            //count+=1;
            while(mid>=0){
                if(array[mid]==k){
                    count++;
                }else {
                    break;
                }
                mid--;
            }
            while(second<=array.length-1){
                if(array[second]==k){
                    count++;
                }else {
                    break;
                }
                second++;
            }
        }
        System.out.println(count-1);
        return count;
    }
    public static void main(String[] args){
        int[] nums = new int[]{2,4,5,5,5,5,5,6,8,9};
        GetNumberOfK(nums,5);



//        TreeNode phead = new TreeNode(5);
//        TreeNode pcurr = phead;
//        pcurr.left = new TreeNode(4);
//        pcurr = pcurr.left;
//        pcurr.left = new TreeNode(11);
//        pcurr.right = new TreeNode(2);
//        pcurr = phead;
//        pcurr.right = new TreeNode(8);
//        pcurr = pcurr.right;
//        pcurr.left = new TreeNode(13);
//        pcurr.right = new TreeNode(4);
//        FindPath(phead,17);
        //
//        ListNode phead1 = new ListNode(6);
//        ListNode phead2 = new ListNode(2);
//        phead1.next = new ListNode(8);
//        phead1.next.next = new ListNode(9);
//        phead1.next.next.next = new ListNode(4);
//        phead1.next.next.next.next = new ListNode(5);
//
//        phead2.next = new ListNode(3);
//        phead2.next.next = new ListNode(4);
//        phead2.next.next.next = new ListNode(5);
//
//
//        ListNode temp = FindFirstCommonNode(phead1,phead2);
//        System.out.println(temp.val);

    }
}


