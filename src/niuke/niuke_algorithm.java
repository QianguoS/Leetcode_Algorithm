package niuke;

import javax.sql.rowset.spi.SyncProvider;
import java.util.*;

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
    //最大连续子数组
    public static void max_sequence(int[] a){
        int thisSum = 0,maxSum = 0;
        for(int i = 0;i<a.length;i++){
            thisSum+=a[i];
            if(thisSum<0){
                thisSum=0;
            }else if(thisSum>maxSum){
                maxSum = thisSum;
            }
        }
        System.out.println(maxSum);
    }
    //按层次打印二叉树的节点数值
    public static class TreeNodes {
        int data;
        TreeNodes left;
        TreeNodes right;

        public TreeNodes(int data) {
            this.data = data;
        }
    }
    public static void print_cengci(TreeNodes root){
        Queue<TreeNodes> quenue = new LinkedList<>();
        quenue.add(root);
        TreeNodes last = root;
        TreeNodes nLast = root;
        while(!quenue.isEmpty()){
            TreeNodes t = quenue.poll();
            System.out.print(t.data + " ");
            if(t.left!=null){
                quenue.add(t.left);
                nLast = t.left;

            }
            if(t.right!=null){
                quenue.add(t.right);
                nLast = t.right;
            }
            if(last == t){
                System.out.println();
                last = nLast;
            }
        }


    }
    /*
    * 题目：
 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，
 要求时间复杂度：O(n)，空间复杂度：O(1)**/
    public static void get_maxNum(int[] a){
        if(a==null || a.length<3){
            return;
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>();
        PriorityQueue<Integer> minPQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<a.length;i++){
            if(maxPQ.size()<3 || a[i]>=maxPQ.peek()){
                offerMax(maxPQ,a[i]);
            }
            if(minPQ.size()<2 || a[i]<=minPQ.peek()){
                offerMin(minPQ,a[i]);
            }
        }
        int max1 = maxPQ.poll();
        int max2 = maxPQ.poll();
        int max3 = maxPQ.poll();
        int min1 = minPQ.poll();
        int min2 = minPQ.poll();
        int max = Math.max(max1*max2*max3,min1*min2*max3);
        System.out.println(max);

    }

    private static void offerMin(PriorityQueue<Integer> minPQ, int i) {
        minPQ.offer(i);
        if(minPQ.size()>2)minPQ.poll();
    }

    private static void offerMax(PriorityQueue<Integer> maxPQ, int i) {
        maxPQ.offer(i);
        if(maxPQ.size()>3)maxPQ.poll();
    }



    //n从1开始，每个操作可以对n加1或加倍，如果要使n是2014，
    // 最少需要 个操作。
    public static void get_minStep(int target){
        int[] nums = new int[target+1];
        nums[1] = 0;
        int i;
        for(i=2;i<=target;i++){
            nums[i] = nums[i-1]+1;
            if(i%2==0){
                nums[i] = Math.min(nums[i],nums[i/2]+1);
            }
        }
        System.out.println(nums[--i]);
    }


    //全排列
    public static List<List<Integer>> results = new ArrayList<>();
    public static int[] paths = new int[100];
    public static boolean[] v = new boolean[100];
    public static void all_pailie(int[] nums,int idx){
        if(idx>=nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[paths[i]]);
                System.out.print(nums[paths[i]]);
                System.out.print(' ');
            }
            System.out.println();
            results.add(temp);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(v[i]==false){
                v[i] = true;
                paths[idx] = i;
                all_pailie(nums,idx+1);
                v[i] = false;
            }
        }
    }
    //最大字段积
    public static void max_ziduanji(int[] a){
        int n = a.length;
        int Maxsum=1,thisSum=1,Minsum=1;
        for(int i=0;i<n;i++){

            if(a[i]>0){
                Maxsum = Maxsum*a[i];
                Minsum = Math.min(Minsum*a[i],1);
            }else if(a[i]==0){
                Minsum = 0;
                Maxsum = 0;
            }else{
                int temp = Maxsum;
                Maxsum = Math.max(Minsum*a[i],1);
                Minsum = Math.min(temp*a[i],a[i]);
            }

        }
        System.out.println(Maxsum);
    }

    //两个大数相加
    public static void big_add(String A,String B){
        char[] dataA = A.toCharArray();
        char[] dataB = B.toCharArray();
        char[] temp1 = new char[dataA.length];
        char[] temp2 = new char[dataB.length];
        char[] result = new char[dataA.length>dataB.length ? dataA.length+1:dataB.length+1];
        int j=0;
        StringBuilder str = new StringBuilder();
        for(int i=dataA.length-1;i>=0;i--){
            temp1[j++] = dataA[i];
        }
        j=0;
        for(int i=dataB.length-1;i>=0;i--){
            temp2[j++] = dataB[i];
        }
        j=0;
        int flag = 0;
        while (j<temp1.length && j<temp2.length){
            int sum = temp1[j]-'0'+temp2[j]-'0'+flag;
            if(sum>9){
                //result[j] = (char)(sum%10);
                str.append(sum%10);
                flag = 1;
            }else{
                //result[j] = (char)(sum);
                str.append(sum);
                flag=0;
            }
            j++;
        }
        while(j<dataA.length){
            if(flag==1){
                //result[j] = (char)(temp1[j]-'0'+flag);
                str.append(temp1[j]-'0'+flag);
                flag=0;
            }
            else {
                str.append(temp1[j]);
                //result[j] =temp1[j];
            }
            j++;
        }

        while(j<dataB.length){
            if(flag==1){
                result[j] = (char)(temp2[j]-'0'+flag);
                flag=0;
            }
            else {
                result[j] =temp2[j];
            }
            j++;
        }
        if(flag==1){
            //result[j] = (char)flag;
            str.append(flag);
        }

        System.out.print(str.toString());


    }
    //前k小的数
    public static void getMinum(int[] a,int k){
        PriorityQueue<Integer> minQuen = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<a.length;i++){
            if(minQuen.size()<k || a[i]<minQuen.peek()){
                add_to_quence(a[i],minQuen,k);
            }
        }
        for(int i=0;i<k;i++){
            System.out.println(minQuen.poll());
        }
    }

    private static void add_to_quence(int i, PriorityQueue<Integer> minQuen,int k) {
        minQuen.offer(i);
        if(minQuen.size()>k)minQuen.poll();
    }

    //三项切分快速排序
    public static void three_cut_sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        rec_three_sort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private static void rec_three_sort(int[] a, int low, int high) {
        if(low>=high){
            return;
        }
        int lo=low;
        int hi=high;
        int piovt = a[low];
        int i=low+1;
        while(i<=hi){
            if(a[i]<piovt){
                swap(a,i++,lo++);
            }else if(a[i]>piovt){
                swap(a,i,hi--);
            }else{
                i++;
            }
        }
        rec_three_sort(a,low,lo-1);
        rec_three_sort(a,hi+1,high);
    }

    private static void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }
    //数组中次数超过一半的数
    public static void count_than_half(int[] a){
        three_cut_sort(a);
        int num = a[a.length/2];
        int count=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==num)count++;
        }
        System.out.println("num count"+count);
    }
    //二叉树的深度
    public static int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right)+1;
    }
    //寻找数组中重复的元素
    public static void find_dupli(int[] a){
        int len = a.length;
        for(int i=0;i<len;i++){

            while(a[i]!=i){
                if(a[i]==a[a[i]]){
                    System.out.println("find the dulpli"+a[i]);
                    break;
                }
                swap(a,i,a[i]);
            }

        }
    }
    //判断序列是否为二叉查找树序列
    public static boolean isChazhaoshu(int[] a){
        for(int i=0;i<a.length-1;i++){
            int temp=a[i];
            if(a[i+1]>a[i]){
                int j=i+1;
                while(j<a.length){
                    if(a[j]>temp){
                        j++;
                    }else{
                        return false;
                    }
                }
            }else{
                int j=i+1;
                while(j<a.length){
                    if(a[j]<temp){
                        j++;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //


    public static void main(String[] args){
        int[] nums = new int[]{2,4,5,5,5,5,5,6,8,9};
        //GetNumberOfK(nums,5);
        int[] a = new int[]{2,10,-5,-1,3,-4};
        int[] seq = new int[]{1,2,3};
        //max_sequence(a);
        //get_minStep(2014);
        //get_maxNum(a);
        //all_pailie(seq,0);
        int[] b = new int[]{3,2,-1,6,2};
        //max_ziduanji(b);
        //big_add("12345","23456");
        //getMinum(a,3);
        int[] c = new int[]{2,5,1,2,2,2,2};
        int[] d = new int[]{35,39,65,56};
        //count_than_half(c);
        //find_dupli(c);
        System.out.println(isChazhaoshu(d));

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
        //TreeDepth(phead);







        //TreeNodes phead = new TreeNodes(5);
//        TreeNodes pcurr = phead;
//        pcurr.left = new TreeNodes(4);
//        pcurr = pcurr.left;
//        pcurr.left = new TreeNodes(11);
//        pcurr.right = new TreeNodes(2);
//        pcurr = phead;
//        pcurr.right = new TreeNodes(8);
//        pcurr = pcurr.right;
//        pcurr.left = new TreeNodes(13);
//        pcurr.right = new TreeNodes(4);
//        print_cengci(phead);

        //FindPath(phead,17);
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


