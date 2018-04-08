package leetcode;

/**
 * Given an integer, convert it to a roman numeral.
 *
 *Input is guaranteed to be within the range from 1 to 3999.*/
public class integerToRoman {
    public static String integerToRo(int num){
        String result = "";
        int index = 0;
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        while(num!=0){
            int temp = num%10;
            result = roman[index][temp] + result;
            index++;
            num /=10;
        }
        return result;

    }
    public static void main(String[] args){
        System.out.println(integerToRo(10));
    }
}
