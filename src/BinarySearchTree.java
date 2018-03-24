/**
 * 携程笔试：
 * 写一棵二叉搜索树，实现插入功能。
 * 树中有一个域count，如果第一次插入此结点，值为1；如果不是第一次，count++。
 */
public class BinarySearchTree {
/**
 *
    private static class TreeNode {
        Comparable val;
        int count = 1;
        TreeNode left, right;
        public TreeNode(Comparable val){
            this.val = val;
        }
    }

    private TreeNode head;

    public TreeNode getHead() {
        return head;
    }

    public BinarySearchTree(TreeNode head) {
        this.head = head;
    }

    public boolean insert(Comparable val) {
        if (val == null) return false;
        return insert(val, head, true, null);
    }

    private boolean insert(Comparable val, TreeNode root, boolean isLeft, TreeNode parent) {
        if (root == null) {
            if (parent != null) {
                if (isLeft) {
                    parent.left = new TreeNode(val);
                } else {
                    parent.right = new TreeNode(val);
                }
            } else {
                head = new TreeNode(val);
            }
            return true;
        }

        int cmp = root.val.compareTo(val);
        if (cmp == 0) {
            root.count ++;
            return true;
        } else if (cmp < 0) {
            return insert(val, root.right, false, root);
        } else {
            return insert(val, root.left, true, root);
        }
    }
 */
    private static class TreeNode{
        public int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }

        private static TreeNode head;
        public static boolean insert(int val){
            //if(val==null) return null;
            return insert(val,head,true,null);
        }

    private static boolean insert(int val, TreeNode curr, boolean isleft, TreeNode parent) {
            if(curr==null){
                if(parent==null){
                    curr = new TreeNode(val);
                }else{
                    if(isleft){
                        parent.left = new TreeNode(val);

                    }else{
                        parent.right = new TreeNode(val);
                    }
                }
                return true;
            }

            if(curr.val>val){
                return insert(val,curr.left,true,curr);
            }else if(curr.val<val){
                return insert(val,curr.right,false,curr);
            }else{
                return false;
            }
            //return false;
    }
}

    public static void main(String[] args) {
//        BinarySearchTree bst = new BinarySearchTree(new TreeNode(1));
//        bst.insert(2);
//        bst.insert(3);
//        bst.insert(2);
//        bst.insert(2);
//        System.out.println(bst.getHead().right.count);
    }
}

