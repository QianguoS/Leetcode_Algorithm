package niuke;

public class isMiorr {
    //判断一颗二叉树是否为镜像
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public static boolean isMorr(TreeNode pNode){
        if(pNode==null || pNode.left==null || pNode.right==null){
            return false;
        }
        return isSystemMiorr(pNode.left,pNode.right);
    }

    private static boolean isSystemMiorr(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        if(left.val == right.val){
            return isSystemMiorr(left.left,right.right) && isSystemMiorr(left.right,right.left);
        }
        return false;
    }


    public static void main(String[] args){
        TreeNode pHead = new TreeNode(8);
        pHead.left = new TreeNode(6);
        pHead.left.left = new TreeNode(5);
        pHead.left.right = new TreeNode(7);

        pHead.right = new TreeNode(6);
        pHead.right.left = new TreeNode(7);
        pHead.right.right = new TreeNode(5);
        //System.out.println(isMorr(pHead));
    }
}
