public class maxValue {
    //solution1
    public static void getMax(int[] num, int m){
        int n = num.length;
        int currValue = 0;
        int maxValue = 0;
        int index = m;
        for (int i = 0; i < num.length; i++) {
            int index1 = (i-m+1+n)%n;
            currValue = 0;
            index = m;
            while (index>0){
                currValue += num[(i-index+1+n)%n];
                index--;
            }
            if(maxValue<currValue){
                maxValue = currValue;
            }
        }
        System.out.println(maxValue);

    }
    //solution2
    public static void getMax2(int[] num, int m){
        int n = num.length;
        int currValue = 0;
        int maxValue = 0;
        int index = m;
        while (index>0){
            currValue += num[(0-index+1+n)%n];
            index--;
        }
        index = m;
        for (int i = 1; i < num.length; i++) {
            currValue -= num[(i-index+n)%n];
            currValue += num[i];

            if(maxValue<currValue){
                maxValue = currValue;
            }
        }
        System.out.println(maxValue);

    }
    public static void main(String[] args){
        int[] num = new int[]{1,2,3,4,5};
        getMax2(num,3);
    }
}
