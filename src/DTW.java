/**
 * 动态时间规整算法。
 * 思路：动态规划。
 * 递推公式：Cum_Dis[i][j] = min{Cum_Dis[i-1][j]+dis[i][j],Cum_Dis[i][j-1]+dis[i][j],Cum_Dis[i-1][j-1]+2*dis[i][j]}
 */
public class DTW {
    /**
     * 动态时间规整算法
     */
    public static double dynamicTimeWarping(double[][] seq1, double[][] seq2) {
        if (seq1 == null || seq1.length == 0 || seq2 == null || seq2.length == 0)
            throw new IllegalArgumentException("Argument Error!");

        // cumDis: Cumulative distance 累积距离矩阵
        double[][] cumDis = new double[seq1.length][seq2.length];
        //初始化cumDis[0][0]为seq1[0], seq2[0]的欧氏距离
        cumDis[0][0] = getEuclideanDis(seq1[0], seq2[0]);
        //计算第一列的累积距离
        for (int i = 1; i < seq1.length; i++) {
            cumDis[i][0] = cumDis[i - 1][0] + getEuclideanDis(seq1[i], seq2[0]);
        }
        //计算第一行的累积距离
        for (int i = 1; i < seq2.length; i++) {
            cumDis[0][i] = cumDis[0][i - 1] + getEuclideanDis(seq1[0], seq2[i]);
        }
        //计算剩余的累积距离
        for (int i = 1; i < seq1.length; i++) {
            for (int j = 1; j < seq2.length; j++) {
                cumDis[i][j] =
                        getMin(cumDis[i - 1][j] + getEuclideanDis(seq1[i], seq2[j])
                                , cumDis[i][j - 1] + getEuclideanDis(seq1[i], seq2[j])
                                , cumDis[i - 1][j - 1] + 2 * getEuclideanDis(seq1[i], seq2[j]));
            }
        }
        return cumDis[seq1.length - 1][seq2.length - 1];
    }

    /**
     * 计算向量vector1和vector2的欧几里得距离。
     *
     * @param vector1 向量1
     * @param vector2 向量2
     * @return
     */
    private static double getEuclideanDis(double[] vector1, double[] vector2) {
        if (vector1 == null || vector1.length == 0
                || vector2 == null || vector2.length == 0
                || vector1.length != vector2.length)
            throw new IllegalArgumentException("Argument Error!");
        double sqDis = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            sqDis += Math.pow(vector1[i] - vector2[i], 2);
        }
        return Math.sqrt(sqDis);
    }

    /**
     * 找到3个数中较小的那个数
     */
    private static double getMin(double d1, double d2, double d3) {
        return Math.min(Math.min(d1, d2), d3);
    }

    //DTW算法
    public static double calDTW(int[] seq1, int[] seq2) {
        if (seq1 == null || seq1.length == 0 || seq2 == null || seq2.length == 0) {
            return -1;
        }
        double[][] culDistance = new double[seq1.length][seq2.length];
        culDistance[0][0] = getEucDis(seq1[0], seq2[0]);
        //处理第一列数据
        for(int i = 1; i < seq1.length; i++){
            culDistance[i][0] = culDistance[i-1][0] + getEucDis(seq1[i],seq2[0]);
        }
        //处理第一行数据
        for (int i = 1; i < seq2.length; i++) {
            culDistance[0][i] = culDistance[0][i-1] + getEucDis(seq1[0],seq2[i]);
        }

        for(int i = 1; i < seq1.length; i++){
            for(int j = 1; j < seq2.length; j++){
                culDistance[i][j] = getMin(culDistance[i-1][j]+ getEucDis(seq1[i],seq2[j]),
                        culDistance[i][j-1] + getEucDis(seq1[i],seq2[j]),
                        culDistance[i-1][j-1]+2 * getEucDis(seq1[i],seq2[j]));
            }
        }
        return culDistance[seq1.length-1][seq2.length-1];

    }

    private static double getEucDis(int num1, int num2) {
        return Math.abs(num1-num2);
    }

    public static void main(String[] args) {
        double seq1[][] = {{1, 2}, {3, 5}, {1, 3}};
        double seq2[][] = {{1, 5}, {2, 5}};
        System.out.println(dynamicTimeWarping(seq1, seq2));
    }
}

