package niuke;



import java.util.ArrayList;

public class findKthNode {
    //寻找二叉搜索树的第k大的节点，采用中序遍历就可以实现
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    static ArrayList<TreeNode> arrayList = new ArrayList<>();
    public static TreeNode findKthNode(TreeNode pHead,int k){
        if(pHead==null)return null;

        middleFindKth(pHead);
        if(arrayList.size()>=k)return arrayList.get(k-1);
        return null;

    }

    private static void middleFindKth(TreeNode pHead) {
        if(pHead==null){
            return;
        }
        middleFindKth(pHead.left);
        arrayList.add(pHead);
        middleFindKth(pHead.right);
    }
    //将一颗二叉查找树转换为双端链表
    static TreeNode head = null;
    static TreeNode realHead = null;
    public static TreeNode changeList(TreeNode pHead){
        if(pHead==null){
            return null;
        }

        convertTree(pHead);
        return realHead;
    }

    private static void convertTree(TreeNode pHead) {
        if(pHead==null){
            return;
        }
        convertTree(pHead.left);
        if(realHead==null){
            realHead = pHead;
            head = pHead;
        }else{
            head.right = pHead;
            pHead.left = head;

            head = pHead;
        }
        convertTree(pHead.right);
    }

    //字符串的全排列
    public static ArrayList<String> result = new ArrayList<>();
    public static boolean[] v = new boolean[10];
    public static int[] path = new int[10];
    public static ArrayList<String> quanpailie(String str){

        for (int i = 0; i < 10; i++) {
            v[i]=false;
        }
        char[] array = str.toCharArray();
        iter(array,0);
        return result;
    }

    private static void iter(char[] array,int idx) {
        if(idx>=array.length){
            String temp = "";
            for (int i = 0; i < array.length; i++) {
                temp+=array[path[i]];
            }
            if(!result.contains(temp)){
                result.add(temp);
            }

        }
        for(int i=0;i<array.length;i++){
            if(v[i]==false){
                v[i]=true;
                path[idx] = i;
                iter(array,idx+1);
                v[i]=false;
            }
        }
    }

    public static void main(String[] args){
        TreeNode pHead = new TreeNode(5);
        pHead.left = new TreeNode(3);
        pHead.left.left = new TreeNode(2);
        pHead.left.right = new TreeNode(4);

        pHead.right = new TreeNode(7);
        pHead.right.left = new TreeNode(6);
        pHead.right.right = new TreeNode(8);
        //System.out.println(findKthNode(pHead,3).val);
        //System.out.println(changeList(realHead).val);
        ArrayList res = quanpailie("abc");
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
