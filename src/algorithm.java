import java.util.*;

public class algorithm {
    /**
     * 本部分代码主要解决path sum问题，
     * Given a binary tree and a sum,
     * find all root-to-leaf paths where each path's sum equals the given sum.
     *For example:
     *Given the below binary tree and sum = 22,
     * */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
            return result;
        }
        Stack<Integer> path = new Stack<Integer>();
        pathIner(root,sum,path);
        return result;
    }

    public void pathIner(TreeNode root, int sum, Stack path){
        path.push(root.val);
        if(root.left==null && root.right==null){
            if(sum==root.val) result.add(new ArrayList(path));
        }else{
            if(root.left!=null) pathIner(root.left,sum-root.val,path);
            if(root.right!=null) pathIner(root.right,sum-root.val,path);
        }
        path.pop();
    }

    /**
     * 本部分代码主要解决全部排列问题，
     *
     * */
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    static int[] paths = new int[100];
    static boolean[] v = new boolean[100];
    public static void dfs(int idx, int[] nums){
        if(idx>=nums.length){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                tmp.add(nums[paths[i]]);
                System.out.print(nums[paths[i]]);
                System.out.print(' ');

            }
            System.out.println();
            ans.add(tmp);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(v[i]==false) {
                v[i] = true;
                paths[idx]=i;
                dfs(idx + 1, nums);
                v[i] = false;
            }

        }
    }

    public static void pertations(){
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        dfs(0,nums);

    }
    /**
     * 本部分代码主要解决path sum问题，
     * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

     For example,
     If n = 4 and k = 2, a solution is:

     [
     [2,4],
     [3,4],
     [2,3],
     [1,2],
     [1,3],
     [1,4],
     ]
     * */

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combine(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if(k==0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=start;i<=n;i++) {
            comb.add(i);
            combine(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
    //方法二测试from-chao
    public static List<List<Integer>> combines(int n, int k) { //1 ... n 取k个全排列
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1)
            return res;
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                res.add(al);
            }
            return res;
        }
        for (int i = n; i >= k ; i--) {
            List<List<Integer>> als = combines(i-1, k-1);
            for (List<Integer> al : als) {
                al.add(i);
                res.add(al);
            }
        }
        Collections.sort(res, new Comparator<List<Integer>>() {

            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) != l2.get(i))
                        return l1.get(i) - l2.get(i);
                }
                return 0;
            }
        });
        return res;
    }
    //===============pow(x,n)==================
    /**
     * Implement pow(x, n).
     *Example 1:
     *Input: 2.00000, 10
     *Output: 1024.00000
     * */
    public static double fastpow(double x,int n){
        if(n==0){
            return 1.0;
        }
        double half = fastpow(x,n/2);
        if(n%2==0){
            return half*half;
        }else{
            return half*half*x;
        }
    }
    public static double myPow(double x, int n) {
        if(n<0){
            x = 1/x;
            n = -n;
        }
        return fastpow(x,n);
    }

    //判断一个序列是否为二叉查找序列
    public static boolean isBinarySearch(int[] num){
        int tmp1 = 0;
        int tmp2 = 0;
        int[] bidData = new int[num.length];
        int[] smallData = new int[num.length];
        for(int i=0;i<num.length-1;i++){
            if(num[i]>num[num.length-1]){
                bidData[tmp1++] = num[i];
            }else{
                smallData[tmp2++] = num[i];
            }
        }
        for(int i=0;i<tmp1;i++){
            if(bidData[i]<bidData[i+1])
                return false;
        }
        for(int i=0;i<tmp2-1;i++){
            if(smallData[i]>smallData[i+1])
                return false;
        }
        return true;


    }

    private static void swap(int[] num, int tmp1, int tmp2) {
        int temp = num[tmp1];
        num[tmp1] = num[tmp2];
        num[tmp2] = temp;
    }
    /**
     * 给定一颗二叉排序树，给定一个节点，找出这个节点的下一个节点，
     * 节点中包含了指向父节点的指针*/
    public static void findNextNode(){

    }

    public static void main(String[] args){
        int[] num = new int[]{21,12,9,11,10};
        System.out.println(isBinarySearch(num));
        isBinarySearch(num);

        //pertations();
        //combines(5,3);
        //System.out.println(myPow(2.0,4));
    }
}
