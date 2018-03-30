package niuke;

public class shaizi {
    public static void getSum(int idx, int sum, int[] array){
        if(idx==0){
            array[sum]++;
            return;
        }
        for (int i = 1; i <= 6; i++) {
            sum+=i;
            getSum(idx-1,sum,array);
        }
    }

    public static void main(String[] args){
        int n=10;
        int[] array = new int[10*n+2];
        getSum(10,0,array);
    }
}
