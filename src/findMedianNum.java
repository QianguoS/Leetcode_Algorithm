import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 找出一个无序数组的中位数
 * */
public class findMedianNum {
    //solution1 采用快速排序的思想
    public static int findMe(int[] num){
        int index = recQuick(num,0,num.length-1);
        return num[index];
    }

    private static int recQuick(int[] num, int left, int right) {
        int mid = (right - left)/2;
        int partiton = getPartiton(num,left,right);
        while(partiton != mid){
            if(partiton<mid){
                partiton = getPartiton(num,partiton+1,right);
            }else{
                partiton = getPartiton(num,left,partiton-1);
            }
        }
        return partiton;
    }

    private static int getPartiton(int[] num, int left, int right) {
        int leftPtr = left;
        int rightPtr = right-1;
        while(true){
            while(leftPtr<right && num[leftPtr]<num[right])leftPtr++;
            while(rightPtr>=0 && num[rightPtr]>num[right])rightPtr--;
            if(leftPtr<rightPtr){
                swap(num,leftPtr,rightPtr);
            }else{
                break;
            }
        }
        swap(num,leftPtr,right);
        return leftPtr;
    }

    private static void swap(int[] num, int leftPtr, int rightPtr) {
        int temp = num[leftPtr];
        num[leftPtr] = num[rightPtr];
        num[rightPtr] = temp;
    }
    //solution2 采用最小堆来实现
    public static int getMedian(int[] num){
        PriorityQueue<Integer> minQuen = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int mid = (num.length-1)/2;
        //int index = 0;
        for (int i = 0; i < num.length; i++) {
            if(minQuen.size()<=mid+1 || num[i]>=minQuen.peek()){
                offerNum(minQuen,num[i],mid);
            }
        }
        int index = minQuen.poll();
        return index;
    }

    private static void offerNum(PriorityQueue<Integer> minQuen, int i, int mid) {
        minQuen.offer(i);
        if(minQuen.size()>mid+1) minQuen.poll();
    }

    public static void main(String[] args){
        int[] num =new int[]{5,2,9,6,7,100,20};
        //System.out.println(findMe(num));
        System.out.println(getMedian(num));
    }
}
