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

    //=================动态规划第二题=====================================//
    /**
     * 求斐波那契数列*/
    //第一种解法，这一种方式复杂度很高，面试官到时候肯定还会问有没有优化算法，这个时候
    // 仿照上一题存储计算过的中间变量。这一步留给读者完成。如果大家遇到问题可以发送给。
    static int fib(int n){
        if(n<=2){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }
    //第二种解法使用递推公式解决
    static int fib_ditui(int n){
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;

        for(int i=3;i<=n;i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n-1];

    }
    //=================动态规划第三题=====================================//
    /**
     * 话说有一哥们去森林里玩发现了一堆宝石，他数了数，
     * 一共有n个。 但他身上能装宝石的就只有一个背包，背包的容量为C。
     * 这哥们把n个宝石排成一排并编上号： 0,1,2,…,n-1。
     * 第i个宝石对应的体积和价值分别为V[i]和W[i] 。排好后这哥们开始思考：
     * 背包总共也就只能装下体积为C的东西，那我要装下哪些宝石
     * 才能让我获得最大的利益呢？*/
    //solution1 暴力搜索算法
    static int n=10;
    static int W;
    static int[] w = new int[n];
    static int[] v = new int[n];
    static int search(int idx, int s){
        if(s>W){
            return 0;
        }
        if(idx>=n){
            return 0;
        }

        return Math.max(search(idx+1,s+w[idx])+v[idx],
                search(idx+1,s));
    }
    //solution2 保存已经计算过的变量
    static int[][] f = new int[n][n];
    static int searchs(int idx, int s){
        if(s>W){
            return 0;
        }
        if(idx>=n){
            return 0;
        }
        if(f[idx][s]>0){
            return f[idx][s];
        }

        f[idx][s] = Math.max(searchs(idx+1,s+w[idx])+v[idx],
                searchs(idx+1,s));
        return f[idx][s];
    }

    //=================动态规划第四题=====================================//
    /**
     * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

     Example 1:
     coins = [1, 2, 5], amount = 11
     return 3 (11 = 5 + 5 + 1)

     Example 2:
     coins = [2], amount = 3
     return -1.

     Note:
     You may assume that you have an infinite number of each kind of coin.*/
    //solution1 暴力解法
    public static int maxValue = 1000000;
    public int search(int idx,int amount,int[] coins){
        if(amount==0){
            return 0;
        }
        if(amount < 0){
            return maxValue;
        }
        if(idx>=coins.length){
            return maxValue;
        }
        return Math.min(search(idx, amount-coins[idx],coins)+1,search(idx+1, amount,coins));
    }
    public int coinChange(int[] coins, int amount) {
        int res = search(0,amount,coins);
        if(res<maxValue){
            return res;
        }else{
            return -1;
        }
    }

    //solution2
    public static int coinChange(int[] coins, int amount) {
        int maxValue = amount+1;
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = maxValue;
        }

        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
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
        //get_result();

    }
}
