package leetcode;

public class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int i=0,index=1;
        while(nums[i]!=val)i++;
        index = i+1;
        while(index<nums.length && i<nums.length){
            if(nums[index]==val)index++;
            else{
                nums[i] = nums[index];
                i++;
                index++;
            }
        }
        return i;
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,4,5};
        System.out.println(removeElement(nums,4));
    }
}
