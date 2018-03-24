public class Tsp_solution {
    //static int cityNum = 4;
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
    public boolean[] row = new boolean[10];
    public boolean[] col = new boolean[10];
    static int cityNum = 4;
    //public int[][] distance = new int[][]{};

    //TSP solution2
    public void solveTSP(){
        int currentNode = 0;
        int nextNode = 0;
        int sumDistance = 0;
        col[0] = true;
        int[] temp = new int[distance[0].length];
        while(!row[currentNode]){
            for(int i=0;i<distance[0].length;i++){
                temp[i] = distance[currentNode][i];
            }
            nextNode = selectMinDistance(temp);
            sumDistance+=distance[currentNode][nextNode];
            row[currentNode]=true;
            col[nextNode] = true;
            currentNode = nextNode;
        }

    }

    private int selectMinDistance(int[] temp) {
        int node=0,minDis = temp[0],minIndex=0;
        while(col[node]){//寻找第一个可用节点
            node++;
            if(node>=cityNum){
                minDis = temp[0];
                break;
            }else{
                minDis = temp[node];
            }
        }
        for(;node<cityNum;node++){
            if(col[node]!=false){
                if(minDis>temp[node]){
                    minDis = temp[node];
                    minIndex = node;
                }
            }
        }
        return minIndex;
    }

    public static void main(String[] args){
        //tsp_solution();
    }
}
