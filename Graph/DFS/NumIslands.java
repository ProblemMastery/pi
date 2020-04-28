package Graph.DFS;

import Graph.Graph;

// dU
public class NumIslands {

    public static int numIslands(char[][] grid) {

        int rows = grid.length-1;
        int cols =  grid[0].length-1;

        int islands=0;

        for (int i = 0 ; i <= rows ; i++){
            for (int j = 0 ; j <= cols; j++){
                if(grid[i][j] == '1'){
                    dfsHelper(grid, i , j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void dfsHelper(char[][] grid, int i, int j) {

        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j]=='0'){
            return;
        }

        grid[i][j] = '0';
        dfsHelper(grid, i+1,j) ;
        dfsHelper(grid, i-1, j);
        dfsHelper(grid, i, j+1);
        dfsHelper(grid, i , j-1);

    }
    public static void main(String [] args) {
        char [][] board = new char[][]{{'0', '0', '0'}, {'1', '1', '1'}, {'1', '1', '1'}};

        System.out.print(numIslands(board));
    }
}
