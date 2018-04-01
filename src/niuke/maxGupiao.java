package niuke;

public class maxGupiao {
    //求解股票的最大收益
    public static void getMax(int[] num){
        if(num.length == 0)return;
        int min = num[0];
        int maxValue = num[1]-min;
        for (int i = 2; i < num.length; i++) {
            if(num[i-1] < min)min = num[i-1];
            int diff = num[i] - min;
            if(diff > maxValue)maxValue = diff;
        }
        System.out.println(maxValue);
    }
    public static void main(String[] args){

    }
}
