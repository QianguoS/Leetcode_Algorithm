package niuke;

public class matrixPath {
    public static boolean isHasPath(char[][] matrix,String str){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(hasRealPaht(matrix, i, j,visited, str, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean hasRealPaht(char[][] matrix, int row, int col,
                                       boolean[][] visited, String str, int index) {
        if(index >= str.length())return true;
        if(row <0 || col < 0 || row>=matrix.length || col >=matrix[0].length){
            return false;
        }
        if(!visited[row][col] && matrix[row][col]==str.charAt(index)){
            visited[row][col] = true;
            boolean result = hasRealPaht(matrix,row+1,col,visited,str,index+1)||
                    hasRealPaht(matrix,row-1,col,visited,str,index+1)||
                    hasRealPaht(matrix,row,col+1,visited,str,index+1)||
                    hasRealPaht(matrix,row,col-1,visited,str,index+1);
            if(result){
                return true;
            }else {
                visited[row][col] = false;
                return false;
            }
        }else{
            return false;
        }
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(gethasRealPaht(matrix, rows, cols, i, j,visited, str, 0))
                    return true;
            }
        }
        return false;

    }

    private static boolean gethasRealPaht(char[] matrix, int rows, int cols,
                                          int row, int col, boolean[][] visited,
                                          char[] str, int index) {
        if(index >= str.length)return true;
        if(row <0 || col < 0 || row>=rows || col >=cols){
            return false;
        }
        if(!visited[row][col] && matrix[row*cols+col]==str[index]){
            visited[row][col] = true;
            boolean result = gethasRealPaht(matrix, rows, cols,row+1,col,visited,str,index+1)||
                    gethasRealPaht(matrix,rows,cols,row-1,col,visited,str,index+1)||
                    gethasRealPaht(matrix,rows,cols,row,col+1,visited,str,index+1)||
                    gethasRealPaht(matrix,rows,cols,row,col-1,visited,str,index+1);
            if(result){
                return true;
            }else {
                visited[row][col] = false;
                return false;
            }
        }else{
            return false;
        }
    }


    public static void main(String[] args){
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        System.out.println(isHasPath(data,"bfce")); //true


    }
}
