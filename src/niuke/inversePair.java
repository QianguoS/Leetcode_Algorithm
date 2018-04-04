package niuke;

public class inversePair {
    public static int InversePairs(int [] array) {
        long count = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length; j++) {
                if(array[i]>array[j]){
                    count++;
                }
            }
        }
        return (int)(count%1000000007);
    }
    public static void main(String[] args){
        int[] num = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(num));
    }
}
