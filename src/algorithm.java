import java.util.*;

public class algorithm {
    /**
     * 本部分代码主要解决path sum问题，
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
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

    public static void main(String[] args){
        //pertations();
        combines(5,3);
    }
}
