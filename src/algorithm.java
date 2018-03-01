import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public static void main(String[] args){

    }
}
