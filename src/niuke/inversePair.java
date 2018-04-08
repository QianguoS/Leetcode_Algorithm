package niuke;

public class inversePair {
    public static int InversePairss(int [] array) {
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
    public static int InversePairs(int[] array){
        if(array.length==0)return 0;
        int [] copy = new int[array.length];
        int count = getInverPairs(array, copy, 0, array.length-1)%1000000007;
        return count;
    }

    private static int getInverPairs(int[] array, int[] copy, int low, int high) {
        if(low == high)return 0;
        int mid = low + (high - low)/2;
        int leftCount = getInverPairs(array, copy,low,mid);
        int rightCount = getInverPairs(array,copy,mid+1,high);

        int leftPtr = mid;
        int rightPtr = high;
        int locHigh = high;
        int tempCount = 0;
        while (leftPtr>=low && rightPtr>mid){
            if(array[leftPtr] > array[rightPtr]){
                tempCount += rightPtr-mid;
                copy[locHigh--] = array[leftPtr--];
                if(tempCount>=1000000007)//数值过大求余
                {
                    tempCount%=1000000007;
                }
            }else{
                copy[locHigh--] = array[rightPtr--];
            }
        }
        while (leftPtr>=low){
            copy[locHigh--] = array[leftPtr--];
        }
        while (rightPtr>mid){
            copy[locHigh--] = array[rightPtr--];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (tempCount+leftCount+rightCount)%1000000007;
    }

    public static void main(String[] args){
        int[] num = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(num));
    }
}
