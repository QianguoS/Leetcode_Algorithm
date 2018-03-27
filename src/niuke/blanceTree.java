package niuke;
/**
 * 判断一棵树是否为平衡二叉树*/
public class blanceTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //求一颗二叉树的深度
    public static int depth(TreeNode root){
        if(root==null)return 0;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
    //是否为一颗平衡二叉树
    public static boolean isBanlaced(TreeNode root){
        if(root==null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBanlaced(root.left) && isBanlaced(root.right);
    }
    public static void main(String[] args){
        TreeNode pHead = new TreeNode(5);
        pHead.left = new TreeNode(3);
        pHead.left.left = new TreeNode(2);
        pHead.left.right = new TreeNode(4);

        pHead.right = new TreeNode(7);
        pHead.right.left = new TreeNode(6);
        pHead.right.right = new TreeNode(8);
        System.out.println(isBanlaced(pHead));
    }
}
