package niuke;

public class countPath {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        int result = getCount(threshold,rows,cols,0,0,visited);
        return result;
    }

    private int getCount(int threshold, int rows, int cols, int row,
                         int col, boolean[][] visited) {
        if(visited[row][col] ||row>=rows || col>=cols || row<0 || col <0 || (getDigit(row)+getDigit(col)>threshold)) return 0;
        visited[row][col] = true;
        return (getCount(threshold, rows, cols, row+1, col, visited) +
                getCount(threshold, rows, cols, row-1, col, visited) +
                getCount(threshold, rows, cols, row, col+1, visited) +
                getCount(threshold, rows, cols, row, col-1, visited))+1;
    }

    private int getDigit(int num) {
        int result = 0;
        while (num>0){
            result += num%10;
            num = num/10;
        }
        return result;
    }
}
