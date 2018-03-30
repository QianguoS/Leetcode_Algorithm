package niuke;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！*/
public class xuanzhaun {
    public static String LeftRotateString(String str,int n) {
        if(str == ""){
            return null;
        }

        String result = "";
        char[] array = str.toCharArray();
        int start= 0 ;
        int end = n-1;
        rever(array,start,end);
        rever(array,n,array.length-1);
        rever(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            result += array[i];
            //System.out.print(array[i]);
        }
        return result;

    }
    private static void rever(char[] array, int start, int end) {
        while(start < end){
            swap(array, start, end);
            start++;
            end--;
        }
    }

    private static void swap(char[] array, int start, int end) {
        char temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
    public static void main(String[] args){
        System.out.println(LeftRotateString("abcdefg",2));
    }
}
