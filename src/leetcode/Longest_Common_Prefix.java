package leetcode;

/**
 * Write a function to find the longest common
 * prefix string amongst an array of strings.*/
public class Longest_Common_Prefix {
    public static String getResult(String[] strs){
        if(strs.length==0)return null;
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = maxPreix(result,strs[i]);
        }
        return result;
    }

    private static String maxPreix(String result, String str) {
        char[] reArr = result.toCharArray();
        char[] strArr = str.toCharArray();
        int length = Math.min(reArr.length,strArr.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(reArr[i]==strArr[i])
                sb.append(reArr[i]);
            else
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String[] strs = new String[]{"abcedfg","abce","abc"};
        System.out.println(getResult(strs));
    }
}
