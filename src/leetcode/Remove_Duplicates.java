package leetcode;

public class Remove_Duplicates {

    public static int removeDuplicates(int[] nums) {
        int i=0,j=1;
        while (i<nums.length-1 && j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else if(i+1!=j){
                nums[++i] = nums[j++];
            }else{
                i++;
                j++;
            }
        }

        return i+1;

    }
    public static void main(String[] args){
        int[] nums = new int[]{1,3,3,4,5,6,6,6,9};
        System.out.println(removeDuplicates(nums));
    }
}
