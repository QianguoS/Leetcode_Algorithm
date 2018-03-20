public class Tsp_solution {
    static int cityNum = 4;
    static int[] s = new int[]{-1,-1,-1,-1};
    static int[][] distance = new int[][]{{999,2,6,5},
                                    {2,999,5,4},
                                    {6,5,999,2},
                                    {5,4,2,999}   };
    public static void cal_distance(int curr_city){
        int tempClost = 9999;
        for(int i=0;i<cityNum;i++){
            if(isVisited(i) && distance[i][s[curr_city]]<tempClost){
                tempClost = distance[i][s[curr_city]];
                s[curr_city+1]=i;
            }
        }
        boolean isShouldStop = true;
        for(int i=0;i<cityNum;i++){
            if(s[i]==-1){
                isShouldStop=false;
                break;
            }
        }
        if(isShouldStop==false){
            cal_distance(s[curr_city+1]);
        }else{
            return;
        }

    }

    private static boolean isVisited(int k) {
        for(int i=0;i<cityNum;i++){
            if(s[i]==k){
                return true;
            }
        }
        return false;
    }

    public static void tsp_solution(){
        s[0]=0;
        cal_distance(s[0]);
        int all_distance=0;
        for(int i=0;i<cityNum;i++){
            if(i==cityNum-1){
                System.out.println("回到原点的距离为"+distance[s[i]][s[0]]);
            }
            all_distance+=distance[s[i+1]][s[i]];
        }
    }

    public static void main(String[] args){
        tsp_solution();
    }
}
