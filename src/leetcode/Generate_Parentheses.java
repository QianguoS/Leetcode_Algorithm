package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to
 * generate all combinations of well-formed parentheses.
 * */
public class Generate_Parentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String item = new String();
        if(n<0)return result;
        dfs(result,item,n,n);
        return result;
    }

    private static void dfs(List<String> result, String item, int left, int right) {
        if(left > right)return;
        if(left==0 && right==0){
            result.add(item);
            return;
        }
        if(left>0)dfs(result,item+'(',left-1,right);
        if(right>0)dfs(result,item+')',left,right-1);
    }

    public static void main(String[] args){
        List<String> res = generateParenthesis(2);
        for(String str:res){
            System.out.println(str);
        }

    }
}
