package Graph.DFS;

import java.util.ArrayList;
import java.util.List;

public class RiverSize {
    /**
     *
     *
     * @param matrix
     * @return
     */
    public static List<Integer> riverSizes(int[][] matrix) {
        int rows = matrix.length-1;
        int cols = matrix[0].length-1;

        List<Integer> result = new ArrayList<>();

        int riverSize;
        for (int i = 0 ; i <= rows; i++){
            for (int j = 0 ; j <= cols ;j++){
                if(matrix[i][j] == 1){
                    riverSize =  helper(i, j, matrix);
                    result.add(riverSize);
                }


            }

        }
        return result;
    }

    private static int helper(int i, int j , int[][] matrix){

        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length
                || matrix[i][j] == 0)
            return 0;

        matrix[i][j] = 0;
        int val = helper(i+1, j, matrix) + helper(i, j+1, matrix) + helper(i-1, j, matrix) +
                helper(i, j-1, matrix) + 1;
        matrix[i][j] = 0;
        return val;

    }
    public static void main(String [] args) {
        int [][] board = new int[][]{{1,0,0,1,0},{1,0,1,0,0} ,{0,0,1,0,1}, {1,0,1,0,1},{1,0,1,1,0}};

        System.out.print(riverSizes(board));
    }

}
