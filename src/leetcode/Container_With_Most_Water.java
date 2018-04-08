package leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which
 * together with x-axis forms a container, such that the
 * container contains the most water.

 Note: You may not slant the container and n is at least 2.*/
public class Container_With_Most_Water {
    public static int getMaxContainer(int[] height){
        if(height.length==0)return -1;
        int low = 0;
        int max = height.length-1;
        int maxValue = Integer.MIN_VALUE;

        while (low < max){
            int contain = Math.min(height[low],height[max])*(max-low);
            maxValue = Math.max(contain,maxValue);
            if(height[low] < height[max]){
                low++;
            }else{
                max--;
            }
        }
        return maxValue;
    }
    public static void main(String[] args){
        int[] num = new int[]{4,6,2,6,7,11,2};
        System.out.println(getMaxContainer(num));
    }
}
