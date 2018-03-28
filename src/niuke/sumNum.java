package niuke;

import java.util.ArrayList;

/**
 * 找到数组中和为s的两个数*/
public class sumNum {
    public static void findNum(int[] num,int target){
        int left = 0;
        int right = num.length-1;
        while(left<right){
            if(num[left]+num[right]==target){
                System.out.println(num[left]+" "+num[right]);
            }
            if(num[left]+num[right]>target){
                right--;
            }else{
                left++;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        int currSum = left+right;
        int middle = (sum+1)/2;
        while(left<middle && left>0){
            if(currSum==sum){
                addResult(result,left,right);
                right++;
                currSum +=right;
            }else if(currSum<sum){
                right++;
                currSum += right;

            }else{
                currSum -= left;
                left++;

            }
        }
        return result;
    }

    private static void addResult(ArrayList<ArrayList<Integer>> result, int left, int right) {
        ArrayList<Integer> temp  =new ArrayList<>();
        for (int i = left; i <= right; i++) {
            temp.add(i);
        }
        result.add(temp);
    }

    public static void main(String[] args){
        int[] num = new int[]{1,2,4,7,11,15};
        //findNum(num,18);
        ArrayList<ArrayList<Integer>> result = FindContinuousSequence(15);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
