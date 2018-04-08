package leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S
 * such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that
 * each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        int minValue = Integer.MAX_VALUE;
        int sumResult = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])){
                int low = i+1;
                int high = nums.length-1;
                while (low < high){
                    int temp = nums[i]+nums[low]+nums[high]-target;
                    if(Math.abs(temp) < minValue){
                        minValue = Math.abs(temp);
                        sumResult = nums[i]+nums[low]+nums[high];
                    }
                    if(nums[i]+nums[low]+nums[high] < target){
                        low++;
                    }else if(nums[i]+nums[low]+nums[high] > target){
                        high--;
                    }
                }
            }
        }
        return sumResult;
    }
    public static void main(String[] args){
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums,1));
    }
}
