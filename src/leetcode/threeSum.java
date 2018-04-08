package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array
 * which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.*/

public class threeSum {
    public static List<List<Integer>> threeSums(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        for (int i = 0; i < nums.length-2; i++) {
            int low = i+1;
            int high = nums.length-1;
            while (low < high){
                if(nums[low]+nums[high]==-nums[i]){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[low]);
                    temp.add(nums[high]);
                    if(!result.contains(temp))
                        result.add(temp);
                    low++;

                }else if(nums[low]+nums[high]+nums[i]>0){
                    high--;
                }else if(nums[low]+nums[high]+nums[i]<0){
                    low++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSums(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}
