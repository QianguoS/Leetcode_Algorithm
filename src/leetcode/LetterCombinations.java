package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.equals(""))return result;
        String[] map = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        char[] temp = new char[digits.length()];
        dfsCombinations(result,digits,temp,map,0);

        return result;
    }

    private static void dfsCombinations(List<String> result, String digits,
                                 char[] temp, String[] map, int index) {
        if(index==digits.length()){
            result.add(new String(temp));
            return;
        }

        char strChar = digits.charAt(index);
        for (int i = 0; i < map[strChar-'0'].length(); i++) {
            temp[index] = map[strChar-'0'].charAt(i);
            dfsCombinations(result,digits,temp,map,index+1);
        }
    }

    public static void main(String[] args){
        List<String> result = letterCombinations("23");
        for(String str:result){
            System.out.println(str);
        }
    }
}
