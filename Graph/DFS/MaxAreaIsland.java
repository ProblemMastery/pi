package Graph.DFS;

public class MaxAreaIsland {



    public static int maxAreaOfIsland(char[][] grid) {

        int rows = grid.length-1;
        int cols =  grid[0].length-1;

        int maxArea = 0 ;

        for (int i = 0 ; i <= rows ; i++){
            for (int j = 0 ; j <= cols; j++){
                if(grid[i][j] == '1'){
                   int area =  dfsHelper(grid, i , j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int dfsHelper(char[][] grid, int i, int j) {

        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j]=='0'){
            return 0;
        }

        grid[i][j] = '0';
        int len = 1, ht = 1;
         ht += dfsHelper(grid, i+1,j) ;
         ht += dfsHelper(grid, i-1, j);
        len += dfsHelper(grid, i, j+1);
        len += dfsHelper(grid, i , j-1);
        return len * ht;

    }
    public static void main(String [] args) {
        char [][] board = new char[][]{{'0', '0', '0'}, {'1', '1', '0'}, {'1', '1', '1'}};

        System.out.print(maxAreaOfIsland(board));
    }
}
