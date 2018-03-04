public class DP_algorithm {
    //=================动态规划第一题=====================================//
    /**
     * ========
     * ========================题目=========================
     * 198. House Robber
     * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
     *
     *Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
     *
     * */
    /**
     * 解法一：
     * 暴力搜索
     * 我们假设从最后往前进行抢
     * 第一步有两种思路：
     * n-1 则第二步只能（n-3,n-4,....）
     * n-2 则第二步只能(n-4,,n-5,...)
     * */
    public static int solve1(int idx,int[] nums){
        if(idx<0){
            return 0;
        }
        return Math.max(nums[idx]+solve1(idx-2,nums),
                solve1(idx-1,nums));
    }
    /**
     * 解法二：
     * 优化之后的算法
     * 我们假设从最后往前进行抢
     * 第一步有两种思路：
     * n-1 则第二步只能（n-3,n-4,....）
     * n-2 则第二步只能(n-4,,n-5,...)
     * 通过观察我们可以看到n-4,n-5重复计算了，接下来我们将计算过的结果进行保存下来，
     * 这样就节省时间了
     * */
    //public static int[]
    public static int solve2(int idx,int[] nums){
        if(idx<0){
            return 0;
        }
        if(results[idx]>0){
            return results[idx];
        }
        results[idx] = Math.max(nums[idx]+solve2(idx-2,nums),
                solve2(idx-1,nums));
        return results[idx];
    }
    static int[] results;
    /**
     * 解法三：
     * 优化之后的算法
     * 我们将递归式更改为递推式
     * 递归式是从上往下，递推式是从底网上
     * */
    public static void get_result(){
        int[] nums = new int[3];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        results = new int[nums.length];
        results[0] = nums[0];
        results[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            results[i] = Math.max(nums[i]+results[i-2],results[i-1]);
        }
        System.out.print(results[nums.length-1]);
    }
    public static void main(String[] args){

//        int[] nums = new int[3];
//        nums[0] = 1;
//        nums[1] = 2;
//        nums[2] = 3;
//        results = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            results[i] = -1;
//        }
//
//        int result = solve2(nums.length-1, nums);
//        System.out.print(result);
        get_result();
    }
}
