package niuke;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。*/
public class getAglyNum {
    public static int getUglyNumbers(int index){
        if(index <0)return -1;
        int[] num = new int[index+1];
        num[0] = 1;
        int count = 0;
        int mul2 = 0,mul3 = 0,mul5 = 0;
        while (count < index){
            count++;
            int nextMinUgly = Math.min(Math.min(num[mul2]*2,num[mul3]*3),num[mul5]*5);
            num[count] = nextMinUgly;
            while (num[mul2]*2<=nextMinUgly)mul2++;
            while (num[mul3]*3<=nextMinUgly)mul3++;
            while (num[mul5]*5<=nextMinUgly)mul5++;
        }

        return num[index-1];
    }
    public static void main(String[] args){
        System.out.println(getUglyNumbers(5));
    }

}
