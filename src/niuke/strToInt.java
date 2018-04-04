package niuke;

public class strToInt {
    public static int strToInt(String str) {
        if(str.equals(""))return 0;
        char[] array = str.toCharArray();
        int result = 0;
        int i = 0;
        if(array[i] == '+'){
            i++;
        }
        for (; i < array.length; i++) {
            if(array[i]>='0' && array[i]<='9'){
                result *= 10;
                result += array[i]-'0';
            }else{
                return 0;
            }
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(strToInt("+35635"));
    }
}
