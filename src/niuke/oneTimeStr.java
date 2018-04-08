package niuke;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置*/
public class oneTimeStr {
    public static int getFirstStr(String str){
        char[] strArray = str.toCharArray();
        //char result ;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < strArray.length; i++) {
            if(!hashMap.containsKey(strArray[i])){
                hashMap.put(strArray[i],1);
            }else {
                int num = hashMap.get(strArray[i]);
                hashMap.put(strArray[i],num+1);
            }
        }
        for (int i = 0; i < strArray.length; i++) {
            if(hashMap.get(strArray[i])==1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(getFirstStr("abca"));
    }
}
