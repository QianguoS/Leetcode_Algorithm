package niuke;



/**
 * 找到数组中只出现了一次的数字*/
public class oneTimeNum {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        int index = findFirstNon(result);
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if(((array[i]>>index)&1)!=0){
                num1[0]^=array[i];
            }else{
                num2[0]^=array[i];
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    private static int findFirstNon(int result) {
        int count = 0;
        while((result & 1)==0){
            result = result>>1;
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        int[] num = new int[]{2,3,3,6,8,6,9,8};
        int[] num1 = new int[8];
        int[] num2=  new int[8];
        FindNumsAppearOnce(num,num1,num2);
    }

}
