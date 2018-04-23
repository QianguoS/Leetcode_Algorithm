package leetcode;

public class MaxPairo {
    public static int getHuiwenLength(String str){
        if(str.equals(""))return 0;
        char[] strArr = str.toCharArray();
        int[][] dp = new int[str.length()][str.length()];

        for (int i = strArr.length-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < strArr.length; j++) {
                if(strArr[i] == strArr[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][strArr.length-1];

    }
    public static int getNumOfHuiwen(String str){
        if(str.equals(""))return 0;
        int[][] dp = new int[str.length()][str.length()];
        char[] strArr = str.toCharArray();

        for (int i = strArr.length-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < strArr.length; j++) {
                dp[i][j] = dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                if(strArr[i] == strArr[j])
                    dp[i][j] += dp[i+1][j-1]+1;
            }
        }
        return dp[0][strArr.length-1];
    }
    public static void main(String[] args){
        String str="abcffggcbda";
        System.out.println(getHuiwenLength(str));
        System.out.println(getNumOfHuiwen(str));
    }
}
