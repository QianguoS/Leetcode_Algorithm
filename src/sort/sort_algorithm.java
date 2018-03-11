package sort;
/**
 * 本文主要介绍了常用的几大排序算法*/


public class sort_algorithm {
    //public static int[] nums = new int[]{5,2,6,3,7,8,9,1};
    public static int[] nums = new int[]{122,87,78,45,17,65,53,9,32};

    //冒泡排序算法
    public static void maopao_sort(){
        int n = nums.length;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    swap(j,j+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }
    private static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //插入排序算法
    public static void insert_sort(){
        int n = nums.length;
        int i;
        int j;
        for(i=1;i<n;i++){
            int temp = nums[i];
            for(j=i-1;j>=0;j--){
                if(nums[j]>temp){
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            nums[++j] = temp;
        }
        for(int st=0;st<n;st++){
            System.out.print(nums[st]+" ");
        }
    }
    //选择排序算法
    public static void select_sort(){
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int index = i;
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[index]){
                    index = j;
                }
            }
            if(index!=i){
                swap(i,index);
            }
        }
        for(int st=0;st<n;st++){
            System.out.print(nums[st]+" ");
        }
    }
    //快速排序
    public static void quick_sort(){
        for(int st=0;st<nums.length;st++){
            System.out.print(nums[st]+" ");
        }
        System.out.println();
        recquick_sort(0,nums.length-1);
        for(int st=0;st<nums.length;st++){
            System.out.print(nums[st]+" ");
        }
    }
    public static void recquick_sort(int left,int right){
        if(left>=right){
            return;
        }else{
            int partion = getPartions(left,right);
            recquick_sort(left,partion-1);
            recquick_sort(partion+1,right);
        }
    }

    private static int getPartions(int left, int right) {
        int leftPtr = left;
        int rightPtr = right-1;
        while(true){
            while(leftPtr<right && nums[leftPtr]<=nums[right]) leftPtr++;
            while(rightPtr>=0 && nums[rightPtr]>nums[right])rightPtr--;
            if(leftPtr<rightPtr){
                swap(leftPtr,rightPtr);
            }else{
                break;
            }
        }
        swap(leftPtr,right);
        return leftPtr;


    }
    //希尔排序
    public static void shell_sort(){
        int n = nums.length;
        int h=1;
        int out,inner;
        while(h<=(n/3)){
            h = h*3+1;
        }
        while(h>0){
            for(out=h;out<n;out++){
                int temp = nums[out];
                inner = out;
                while (inner>h-1 && nums[inner-h] > temp){
                    nums[inner] = nums[inner-h];
                    inner -= h;
                }
                nums[inner] = temp;
            }
            h = (h-1)/3;
        }
        for(int st=0;st<nums.length;st++){
            System.out.print(nums[st]+" ");
        }

    }

    //堆排序
    public static void heap_sort(){
        int length = nums.length;
        for(int i=length-1;i>0;i--){
            swap(i,0);
            sink(0,i);
        }
        for(int st=0;st<nums.length;st++){
            System.out.print(nums[st]+" ");
        }
    }

    private static void sink(int k, int len) {
        int temp = nums[0];
        for(int i = 2*k+1;i<len;i=2*k+1){
            if(i<len-1 && nums[i]<nums[i+1]){
                i++;
            }
            if(temp>nums[i]){
                break;
            }else{
                nums[k] = nums[i];
                k = i;

            }
        }
        nums[k] = temp;
    }

    public static void main(String[] args){
        //maopao_sort();
        //insert_sort();
        //select_sort();
        //quick_sort();
        //shell_sort();//{5,2,6,3,7,8,9,1}
        heap_sort();

    }
}
