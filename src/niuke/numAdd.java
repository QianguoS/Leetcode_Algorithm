package niuke;

public class numAdd {
    public static int getNum(int num1, int num2) {
        while (num2 != 0) {
            int result = num1 ^ num2;
            int cash = (num1 & num2) << 1;
            num1 = result;
            num2 = cash;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(getNum(2,5));
    }
}
