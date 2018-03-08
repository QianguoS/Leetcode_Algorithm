package sort;
/**
 * 本文主要介绍了常用的几大排序算法*/


public class sort_algorithm {
    public static int[] nums = new int[]{5,2,6,3,7,8,9,1};
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

    public static void main(String[] args){
        //maopao_sort();
        insert_sort();
    }
}
