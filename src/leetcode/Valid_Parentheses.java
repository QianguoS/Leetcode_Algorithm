package leetcode;

import java.util.Stack;

public class Valid_Parentheses {
    public static boolean isValid(String s) {
        if(s.equals(""))return true;
        char[] charArr = s.toCharArray();
        Stack<Character> validStack = new Stack<>();
        //'(', ')', '{', '}', '[' and ']'
        for (int i = 0; i < charArr.length; i++) {
            switch (charArr[i]){
                case '(':
                    //validStack.push(charArr[i]);
                    //break;
                case '{':
                    //break;
                case '[':

                    validStack.push(charArr[i]);
                    break;
                case ')':
                    if(!validStack.isEmpty()){
                        char temp = validStack.pop();
                        if(temp != '(')return false;
                    }else
                        return false;

                    break;
                case '}':
                    if(!validStack.isEmpty()){
                        char temps = validStack.pop();
                        if(temps != '{')return false;
                    }else return false;
                    break;
                case ']':
                    if(!validStack.isEmpty()){
                        char tempss = validStack.pop();
                        if(tempss != '[')return false;
                    }else{
                        return false;
                    }

                    break;
            }
        }
        if(validStack.isEmpty())
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        System.out.println(isValid("{}"));
    }
}
